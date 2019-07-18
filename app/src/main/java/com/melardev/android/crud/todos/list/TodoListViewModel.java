package com.melardev.android.crud.todos.list;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.melardev.android.crud.datasource.common.models.DataSourceOperation;
import com.melardev.android.crud.datasource.common.repositories.TodoRepository;
import com.melardev.android.crud.datasource.remote.dtos.responses.TodoPagedResponse;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class TodoListViewModel extends ViewModel {

    private TodoRepository todoRepository;

    private MutableLiveData<DataSourceOperation<TodoPagedResponse>> todoListLiveData = new MutableLiveData<>();

    @Inject
    public TodoListViewModel(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @SuppressLint("CheckResult")
    public void loadMore(int page, int pageSize) {
        todoRepository.getAll(page, pageSize)
                .subscribe(resource -> todoListLiveData.postValue(resource));
    }

    public LiveData<DataSourceOperation<TodoPagedResponse>> getTodoList() {
        return todoListLiveData;
    }
}
