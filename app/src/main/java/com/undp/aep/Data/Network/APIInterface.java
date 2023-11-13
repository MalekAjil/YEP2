package com.undp.aep.Data.Network;

import com.undp.aep.Model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("")
    Call<List<News>> get_News();
}