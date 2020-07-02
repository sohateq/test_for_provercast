package com.akameko.testforprovercast;

import android.util.Log;

import com.akameko.testforprovercast.repository.Repository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Repository repository = new Repository();

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
                    getViewState().updateRecycler(result.getItems());
                    //Log.d("123", result.getItems().get(0).toString());
                    Log.d("123", "Companies loaded!!");


                }, throwable -> {
                    Log.d("123", "Companies loading failed", throwable);
                    //Toast.makeText(this,"load error", Toast.LENGTH_SHORT).show();
                });
    }
}
