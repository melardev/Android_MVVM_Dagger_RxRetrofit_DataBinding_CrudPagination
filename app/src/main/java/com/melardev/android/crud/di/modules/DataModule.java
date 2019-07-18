package com.melardev.android.crud.di.modules;

import com.google.gson.Gson;
import com.melardev.android.crud.datasource.common.repositories.TodoRepository;
import com.melardev.android.crud.datasource.remote.api.RxTodoApi;
import com.melardev.android.crud.datasource.remote.repositories.RetrofitTodoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    TodoRepository todoRepository(RxTodoApi todoApi, Gson gson) {
        return new RetrofitTodoRepository(todoApi, gson);
    }
}
