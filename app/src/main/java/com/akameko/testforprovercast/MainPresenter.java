package com.akameko.testforprovercast;

import android.util.Log;

import androidx.room.Room;

import com.akameko.testforprovercast.database.AppDatabase;
import com.akameko.testforprovercast.repository.Repository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Repository repository = new Repository();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void init(){

    }

    public void search(String request){
        Disposable disposable = repository.getResults(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    getViewState().updateDatabase(result.getItems());
                    getViewState().updateRecycler(result.getItems());
                    //Log.d("123", result.getItems().get(0).toString());
                    Log.d("123", "Companies loaded!!");


                }, throwable -> {
                    Log.d("123", "Companies loading failed", throwable);
                    //Toast.makeText(this,"load error", Toast.LENGTH_SHORT).show();
                });
        compositeDisposable.add(disposable);
    }

    public void destroy(){
        compositeDisposable.dispose();
    }
}
