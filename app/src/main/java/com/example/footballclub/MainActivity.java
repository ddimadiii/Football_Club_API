package com.example.footballclub;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TeamAdapter adapter;
    List<Team> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_e_football);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<TeamResponse> call = apiService.getAllTeams();

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    teamList = response.body().getTeams();
                    adapter = new TeamAdapter(teamList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
