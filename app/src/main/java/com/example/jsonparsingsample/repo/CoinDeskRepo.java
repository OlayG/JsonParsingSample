package com.example.jsonparsingsample.repo;

import com.example.jsonparsingsample.model.CoinDeskResponse;

import retrofit2.Call;

public class CoinDeskRepo {

    public Call<CoinDeskResponse> getCurrentPrice(String ticker) {
        return RetrofitInstance.getCoinDeskService().getCurrentPrice(ticker);
    }
}
