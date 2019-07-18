package com.melardev.android.crud.todos.list;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.melardev.android.crud.R;
import com.melardev.android.crud.databinding.MainActivityBinding;
import com.melardev.android.crud.datasource.common.entities.Todo;
import com.melardev.android.crud.datasource.remote.dtos.responses.PageMeta;
import com.melardev.android.crud.datasource.remote.dtos.responses.TodoPagedResponse;
import com.melardev.android.crud.factories.AppViewModelFactory;
import com.melardev.android.crud.todos.base.BaseActivity;
import com.melardev.android.crud.todos.show.TodoDetailsActivity;
import com.melardev.android.crud.todos.write.TodoCreateEditActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements TodoListAdapter.TodoRowEventListener {


    @Inject
    AppViewModelFactory appViewModelFactory;

    private MainActivityBinding binding;

    private TodoListViewModel todoListViewModel;

    private TodoListAdapter todoListAdapter;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initViewModel();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        todoListAdapter = new TodoListAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        binding.rvTodos.setLayoutManager(linearLayoutManager);
        binding.rvTodos.setAdapter(todoListAdapter);

        binding.rvTodos.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                if (!isLoading) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                        if (!isLastPage) {
                            isLoading = true;
                            todoListViewModel.loadMore(currentPage + 1, 5);
                        }
                    }
                }
            }
        });
    }

    private void initViewModel() {

        todoListViewModel = ViewModelProviders.of(this, appViewModelFactory)
                .get(TodoListViewModel.class);

        // Observe the list, if
        todoListViewModel.getTodoList().observe(this, getTodoListOperation -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Looper.getMainLooper().isCurrentThread())
                    throw new AssertionError("");
            } else {
                if (Looper.getMainLooper() != Looper.myLooper())
                    throw new AssertionError("");
            }

            if (getTodoListOperation.isLoading()) {
                displayLoader();
            } else if (getTodoListOperation.data != null) {
                populateRecyclerView(getTodoListOperation.data);
            } else {
                handleErrorResponse(getTodoListOperation.fullMessages);
            }
        });

        todoListViewModel.loadMore(1, 5);
    }


    private void populateRecyclerView(TodoPagedResponse pagedResponse) {
        hideLoader();
        isLoading = false;
        PageMeta pageMeta = pagedResponse.getPageMeta();
        currentPage = pageMeta.getCurrentPageNumber();
        isLastPage = currentPage >= pageMeta.getNumberOfPages();
        binding.rvTodos.setVisibility(View.VISIBLE);
        todoListAdapter.setItems(new ArrayList<>(pagedResponse.getTodos()));
    }


    public void createTodo(View view) {
        Intent intent = new Intent(this, TodoCreateEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClicked(Todo todo) {
        Intent intent = new Intent(this, TodoDetailsActivity.class);
        intent.putExtra("TODO_ID", todo.getId());
        startActivity(intent);
    }
}
