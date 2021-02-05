package com.example.jsonparsingsample.model;

import com.squareup.moshi.Json;

public class Bpi {

    @Json(name = "USD")
    private Currency usd;
    @Json(name = "GBP")
    private Currency gbp;
    @Json(name = "EUR")
    private Currency eur;

    public Bpi(Currency usd, Currency gbp, Currency eur) {
        this.usd = usd;
        this.gbp = gbp;
        this.eur = eur;
    }

    public Currency getUsd() {
        return usd;
    }

    public void setUsd(Currency usd) {
        this.usd = usd;
    }

    public Currency getGbp() {
        return gbp;
    }

    public void setGbp(Currency gbp) {
        this.gbp = gbp;
    }

    public Currency getEur() {
        return eur;
    }

    public void setEur(Currency eur) {
        this.eur = eur;
    }
}
