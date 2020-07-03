package com.akameko.testforprovercast.dagger;

import android.app.Application;

import com.akameko.testforprovercast.MainActivity;
import com.akameko.testforprovercast.MainPresenter;
import com.akameko.testforprovercast.database.AppDatabase;
import com.akameko.testforprovercast.database.ItemDao;
import com.akameko.testforprovercast.repository.Repository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class, RepositoryModule.class})
public interface AppComponent {

    void injectMainPresenter(MainPresenter mainPresenter);

    AppDatabase getAppDatabase();

    Repository getRepository();

    Application getApplication();
}