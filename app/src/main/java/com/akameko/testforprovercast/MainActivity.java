package com.akameko.testforprovercast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.akameko.testforprovercast.database.AppDatabase;
import com.akameko.testforprovercast.mainrecycler.MainAdapter;
import com.akameko.testforprovercast.repository.pojos.Item;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    EditText editTextSearch;
    Button buttonSearch;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        presenter.init();
        initDb();


    }

    private void initViews(){
        editTextSearch = findViewById(R.id.edit_text_site_search);
        buttonSearch = findViewById(R.id.button);
        buttonSearch.setOnClickListener(v -> {
            presenter.search(editTextSearch.getText().toString());
        });
    }
    @Override
    public void updateRecycler(List<Item> siteListItem) {

        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MainAdapter mainAdapter = new MainAdapter(siteListItem);
        recyclerView.setAdapter(mainAdapter);

        mainAdapter.notifyDataSetChanged();

    }



    private void initDb(){
        db =  Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
        List<Item> siteListItem = db.getItemDao().getAllItems();
        if (siteListItem != null){
            updateRecycler(siteListItem);
        }

    }

    @Override
    public void updateDatabase(List<Item> siteListItem) {
        db.getItemDao().deleteAll();
        db.getItemDao().insertAll(siteListItem);
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
