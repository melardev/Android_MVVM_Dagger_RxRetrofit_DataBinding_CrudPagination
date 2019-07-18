package com.melardev.android.crud.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.melardev.android.crud.di.ViewModelKey;
import com.melardev.android.crud.factories.AppViewModelFactory;
import com.melardev.android.crud.todos.list.TodoListViewModel;
import com.melardev.android.crud.todos.show.TodoDetailsViewModel;
import com.melardev.android.crud.todos.write.TodoWriteViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(TodoListViewModel.class)
    protected abstract ViewModel bindTodoListViewModel(TodoListViewModel todoListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TodoWriteViewModel.class)
    protected abstract ViewModel bindTodoWriteViewModel(TodoWriteViewModel todoWriteViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TodoDetailsViewModel.class)
    protected abstract ViewModel bindTodoDetailsViewModel(TodoDetailsViewModel todoWriteViewModel);
}
