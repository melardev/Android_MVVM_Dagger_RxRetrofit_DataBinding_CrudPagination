package com.melardev.android.crud.todos.show;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.melardev.android.crud.datasource.common.entities.Todo;
import com.melardev.android.crud.datasource.common.models.DataSourceOperation;
import com.melardev.android.crud.datasource.common.repositories.TodoRepository;
import com.melardev.android.crud.datasource.remote.dtos.responses.SuccessResponse;

import javax.inject.Inject;

public class TodoDetailsViewModel extends ViewModel {
    private final TodoRepository todoRepository;
    private MutableLiveData<DataSourceOperation<Todo>> todoLiveData = new MutableLiveData<>();
    private MutableLiveData<DataSourceOperation<SuccessResponse>> deleteLiveData = new MutableLiveData<>();

    @Inject
    public TodoDetailsViewModel(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public LiveData<DataSourceOperation<Todo>> getTodo() {
        return todoLiveData;
    }

    public void loadTodo(long todoId) {
        todoRepository.getById(todoId).subscribe(resource -> todoLiveData.postValue(resource));
    }

    public void deleteTodo(Long todoId) {
        todoRepository.delete(todoId).subscribe(response -> deleteLiveData.postValue(response));
    }

    public LiveData<DataSourceOperation<SuccessResponse>> getDeleteTodo() {
        return deleteLiveData;
    }
}
