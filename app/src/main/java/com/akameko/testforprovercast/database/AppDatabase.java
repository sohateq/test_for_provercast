package com.akameko.testforprovercast.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.akameko.testforprovercast.repository.pojos.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao getItemDao();
}