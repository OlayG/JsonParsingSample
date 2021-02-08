package com.example.jsonparsingsample.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsingsample.model.CoinDeskResponse;

import java.util.List;

public class CoinDeskAdapter extends RecyclerView.Adapter<CoinDeskAdapter.CoinDeskViewHolder> {
    private final List<CoinDeskResponse> coinDeskResponseList;

    public CoinDeskAdapter(List<CoinDeskResponse> coinDeskResponseList) {
        this.coinDeskResponseList = coinDeskResponseList;
    }

    @NonNull
    @Override
    public CoinDeskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinDeskViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return coinDeskResponseList.size();
    }

    static class CoinDeskViewHolder extends RecyclerView.ViewHolder {
        public CoinDeskViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void loadCoinDesk(CoinDeskResponse response) {
            //binding.tvName.setText(response.getTime().getUpdated());
            String time = response.getTime().getUpdated();
        }
    }
}
