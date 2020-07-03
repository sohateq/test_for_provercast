package com.akameko.testforprovercast.dagger;

import android.app.Application;

import androidx.room.Room;

import com.akameko.testforprovercast.database.AppDatabase;
import com.akameko.testforprovercast.database.ItemDao;
import com.akameko.testforprovercast.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private AppDatabase db;

    public RoomModule(Application application) {
        db = Room.databaseBuilder(application.getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    AppDatabase provideAppDatabase() {
//        AppDatabase db =  Room.databaseBuilder(application,
//                AppDatabase.class, "database")
//                .allowMainThreadQueries()
//                .build();
        return db;
    }

    @Singleton
    @Provides
    public ItemDao provideItemDao(AppDatabase appDatabase){
        return db.getItemDao();
    }
}
