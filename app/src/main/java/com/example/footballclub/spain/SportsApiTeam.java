package com.example.footballclub.spain;

import com.example.footballclub.spain.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface SportsApiTeam {
    @GET("search_all_teams.php")
    Call<com.example.footballclub.spain.TeamResponse> getAllTeams(
            @Query("s") String sport,
            @Query("c") String country
    );
}
