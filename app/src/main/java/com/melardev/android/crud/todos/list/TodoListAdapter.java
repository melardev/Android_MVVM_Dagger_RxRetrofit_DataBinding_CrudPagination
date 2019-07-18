package com.melardev.android.crud.todos.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melardev.android.crud.databinding.TodoListItemBinding;
import com.melardev.android.crud.datasource.common.entities.Todo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

    interface TodoRowEventListener {
        void onClicked(Todo todo);
    }

    private final ArrayList<Todo> todos;
    private final TodoRowEventListener todoRowEventListener;

    public TodoListAdapter(TodoRowEventListener todoRowEventListener) {
        this.todoRowEventListener = todoRowEventListener;
        this.todos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TodoListItemBinding itemBinding = TodoListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Todo todo = todos.get(position);
        viewHolder.binding.txtId.setText(String.valueOf(todo.getId()));
        viewHolder.binding.txtTitle.setText(todo.getTitle());
        viewHolder.binding.txtDescription.setText(todo.getDescription());
        viewHolder.binding.checkboxCompleted.setChecked(todo.isCompleted());
        viewHolder.binding.txtCreatedAt.setText(todo.getCreatedAt());
        viewHolder.binding.txtUpdatedAt.setText(todo.getUpdatedAt());
        viewHolder.itemView.setOnClickListener(v -> todoRowEventListener.onClicked(todo));
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public void addItems(List<Todo> todos) {
        this.todos.clear();
        setItems(todos);
    }

    public void setItems(List<Todo> todos) {
        if (todos == null)
            return;
        int startPosition = this.todos.size();
        this.todos.addAll(todos);
        notifyItemRangeChanged(startPosition, todos.size());
    }

    public Todo getItem(int position) {
        return todos.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TodoListItemBinding binding;


        public ViewHolder(TodoListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
