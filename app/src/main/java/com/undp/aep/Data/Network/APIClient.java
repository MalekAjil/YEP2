package com.undp.aep.Data.Network;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    static final String BASE_URL="https://www.svgrepo.com/svg/137446/resume/";


    public static  APIInterface get()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create( APIInterface.class);

    }
    // Exclude fields from json serialization by using this strategy
    static ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return false;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    };

    static Gson gson = new GsonBuilder()
            .addSerializationExclusionStrategy(strategy)
            .create();

}
