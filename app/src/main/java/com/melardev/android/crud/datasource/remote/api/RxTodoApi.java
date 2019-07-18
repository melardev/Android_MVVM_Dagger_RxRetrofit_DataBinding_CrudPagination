package com.melardev.android.crud.datasource.remote.api;

import com.melardev.android.crud.datasource.common.entities.Todo;
import com.melardev.android.crud.datasource.remote.dtos.responses.SuccessResponse;
import com.melardev.android.crud.datasource.remote.dtos.responses.TodoPagedResponse;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RxTodoApi {
    @GET("todos")
    Observable<TodoPagedResponse> fetchTodos(@Query("page") int page, @Query("page_size") int pageSize);

    @GET("todos")
    Observable<TodoPagedResponse> fetchTodos();

    @GET("todos/{id}")
    Observable<Response<ResponseBody>> fetchTodo(@Path("id") Long id);

    @POST("todos")
    Observable<Todo> createTodo(@Body Todo todo);

    @PUT("todos/{id}")
    Observable<Todo> update(@Path("id") Long id, @Body Todo todo);

    @DELETE("todos/{id}")
    Observable<SuccessResponse> deleteTodo(@Path("id") Long todoId);
}
