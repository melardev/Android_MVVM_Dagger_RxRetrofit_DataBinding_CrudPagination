package com.melardev.android.crud.todos.write;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.melardev.android.crud.datasource.common.entities.Todo;
import com.melardev.android.crud.datasource.common.models.DataSourceOperation;
import com.melardev.android.crud.datasource.common.repositories.TodoRepository;

import javax.inject.Inject;

public class TodoWriteViewModel extends ViewModel {
    private final TodoRepository todoRepository;
    private MutableLiveData<DataSourceOperation<Todo>> todoLiveData = new MutableLiveData<>();
    private MutableLiveData<DataSourceOperation<Todo>> writeResponseLiveData = new MutableLiveData<>();


    @Inject
    public TodoWriteViewModel(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public LiveData<DataSourceOperation<Todo>> getTodo() {
        return todoLiveData;
    }

    public void loadTodo(long todoId) {
        todoRepository.getById(todoId).subscribe(resource -> todoLiveData.postValue(resource));
    }

    public void createTodo(String title, String description) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todoRepository.create(todo).subscribe(writeResponse -> writeResponseLiveData.postValue(writeResponse));
    }

    public LiveData<DataSourceOperation<Todo>> getWriteTodoOperation() {
        return writeResponseLiveData;
    }

    public void update(Todo todo) {
        todoRepository.update(todo).subscribe(response -> writeResponseLiveData.postValue(response));
    }
}
