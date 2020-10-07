package com.example.idillika.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("catalogList.php")
    Call<List<ModelCatalog>> getData( @Query  ( "section"  ) Integer section, @Query ( "session_id" ) String session_id);

}
