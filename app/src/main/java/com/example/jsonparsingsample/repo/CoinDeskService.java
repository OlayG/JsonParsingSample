package com.example.jsonparsingsample.repo;

import com.example.jsonparsingsample.model.CoinDeskResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinDeskService {
    /**
     *              JSON notes
     * [] -> Array
     * {} -> Object
     *
     *              Java
     * [] -> List, Array, any collections Class
     * {} -> This will be a custom object we will have to create using they
     * key value pair provided by the JSON
     *
     *                  EXAMPLE
     *
     *  JSON OBJECT EXAMPLE
     * "time":{
     *       "updated":"Feb 5, 2021 17:42:00 UTC",
     *       "updatedISO":"2021-02-05T17:42:00+00:00",
     *       "updateduk":"Feb 5, 2021 at 17:42 GMT"
     *    }
     *
     *  JSON OBJECT EXAMPLE in JAVA
     *  class Time {
     *      private String updated;
     *      private String updatedISO;
     *      private String updateduk;
     *
     *      // Create constructor
     *      Time(String updated, String updatedISO, String updateduk) {
     *          this.updated = updated;
     *          this.updatedISO = updatedISO;
     *          this.updateduk = updateduk;
     *      }
     *      // Create getters
     *      public String getUpdated() {
     *          return updated;
     *      }
     *      .... other properties ...
     *
     *      // Create setters
     *      pubic void setUpdated(String updated) {
     *          this.updated = updated;
     *      }
     *      .... other properties ...
     *  }
     *
     */

    @GET("{ticker}/currentprice.json")
    Call<CoinDeskResponse> getCurrentPrice(@Path("ticker") String ticker);
}
