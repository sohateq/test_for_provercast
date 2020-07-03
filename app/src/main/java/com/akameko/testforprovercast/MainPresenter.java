package com.akameko.testforprovercast;

import android.util.Log;

import androidx.room.Room;

import com.akameko.testforprovercast.dagger.App;
import com.akameko.testforprovercast.database.AppDatabase;
import com.akameko.testforprovercast.repository.Repository;
import com.akameko.testforprovercast.repository.pojos.Item;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Repository repository;
    @Inject
    AppDatabase db;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void init(){
        App.getComponent().injectMainPresenter(this);
        List<Item> siteListItem = db.getItemDao().getAllItems();
        if (siteListItem != null){
            getViewState().updateRecycler(siteListItem);
        }
    }

    public void search(String request){
        Disposable disposable = repository.getResults(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    updateDatabase(result.getItems());
                    getViewState().updateRecycler(result.getItems());
                    //Log.d("123", result.getItems().get(0).toString());
                    Log.d("123", "Items loaded!!");


                }, throwable -> {
                    Log.d("123", "Items loading failed", throwable);
                    //Toast.makeText(this,"load error", Toast.LENGTH_SHORT).show();
                });
        compositeDisposable.add(disposable);
    }

    private void updateDatabase(List<Item> siteListItem) {
        db.getItemDao().deleteAll();
        db.getItemDao().insertAll(siteListItem);
    }

    public void destroy(){
        compositeDisposable.dispose();
    }
}
