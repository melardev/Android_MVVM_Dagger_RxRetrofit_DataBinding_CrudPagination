package com.melardev.android.crud.di.modules;

import com.melardev.android.crud.todos.list.MainActivity;
import com.melardev.android.crud.todos.show.TodoDetailsActivity;
import com.melardev.android.crud.todos.write.TodoCreateEditActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector()
    abstract TodoCreateEditActivity contributeWriteTodoActivity();

    @ContributesAndroidInjector()
    abstract TodoDetailsActivity contributeTodoDetailsActivity();
}
