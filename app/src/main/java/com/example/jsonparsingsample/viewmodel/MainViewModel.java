package com.example.jsonparsingsample.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.jsonparsingsample.model.CoinDeskResponse;
import com.example.jsonparsingsample.repo.CoinDeskRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

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
}
