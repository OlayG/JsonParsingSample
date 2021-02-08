package com.example.jsonparsingsample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jsonparsingsample.model.CoinDeskResponse;
import com.example.jsonparsingsample.repo.CoinDeskRepo;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    public void getCurrentPrice() {
        new CoinDeskRepo().getCurrentPrice("bpi").enqueue(
                new Callback<CoinDeskResponse>() {
                    @Override
                    public void onResponse(Call<CoinDeskResponse> call, Response<CoinDeskResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<CoinDeskResponse> call, Throwable t) {

                    }
                }
        );
    }

    public void getCurrentPriceRx() {
        new CoinDeskRepo().getCurrentPriceRx("bpi")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CoinDeskResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
// Before everything starts, here we can start a circular progress for example
                        _isLoading.setValue(true);
                        //_isLoading.postValue(true); // When updating from a background thread
                    }

                    @Override
                    public void onNext(@NonNull CoinDeskResponse coinDeskResponse) {
// This is where we get our data AKA onSucess method
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
// Something went wrong
                    }

                    @Override
                    public void onComplete() {
// Process completed, this runs after onNext or onError, can also hide the circular progress here
                        _isLoading.setValue(false);
                    }
                });
    }
}
