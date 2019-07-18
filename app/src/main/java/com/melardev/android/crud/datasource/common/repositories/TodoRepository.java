package com.melardev.android.crud.datasource.common.repositories;


import com.melardev.android.crud.datasource.common.entities.Todo;
import com.melardev.android.crud.datasource.common.models.DataSourceOperation;
import com.melardev.android.crud.datasource.remote.dtos.responses.TodoPagedResponse;

import io.reactivex.Observable;

public interface TodoRepository extends BaseRepository<Todo> {

    Observable<DataSourceOperation<TodoPagedResponse>> getAll(int page, int pageSize);

}
