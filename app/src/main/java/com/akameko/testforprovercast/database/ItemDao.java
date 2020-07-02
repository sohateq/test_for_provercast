package com.akameko.testforprovercast.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.akameko.testforprovercast.repository.pojos.Item;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Item> items);

    @Delete
    void delete(Item item);

    @Query("DELETE FROM item")
    void deleteAll();

    @Query("SELECT * FROM item")
    List<Item> getAllItems();
}
