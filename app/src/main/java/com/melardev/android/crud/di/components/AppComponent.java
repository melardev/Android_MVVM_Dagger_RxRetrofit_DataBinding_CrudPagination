package com.melardev.android.crud.di.components;

import android.app.Application;

import com.melardev.android.crud.AndroidCrudApplication;
import com.melardev.android.crud.di.modules.ActivityBuildersModule;
import com.melardev.android.crud.di.modules.DataModule;
import com.melardev.android.crud.di.modules.NetworkModule;
import com.melardev.android.crud.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;



@Component(modules = {
        NetworkModule.class,
        ViewModelModule.class,
        ActivityBuildersModule.class,
        DataModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(AndroidCrudApplication application);
}
