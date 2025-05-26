package com.example.footballclub.spain;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballclub.R;
import com.example.footballclub.spain.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityTeam extends AppCompatActivity {

    private RecyclerView recyclerViewTeam;
    private TeamAdapter adapterTeam;
    private List<Team> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_team);

        // 1. Inisialisasi RecyclerView
        recyclerViewTeam = findViewById(R.id.recyclerViewTeam);
        recyclerViewTeam.setLayoutManager(new LinearLayoutManager(this));

        // 2. Panggil method untuk fetch data
        getTeamsData();

    }

    private void getTeamsData() {
        // 1. Buat instance interface SportsApi
        SportsApiTeam apiService = ApiClient.getClient().create(SportsApiTeam.class);

        // 2. Panggil endpoint searchPlayers
        apiService.getAllTeams("Soccer", "Spain")
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            teamList = response.body().getTeams();
                            adapterTeam = new TeamAdapter(teamList);
                            recyclerViewTeam.setAdapter(adapterTeam);
                        } else {
                            Toast.makeText(MainActivityTeam.this,
                                    "Data tidak ditemukan: " + response.message(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        Toast.makeText(MainActivityTeam.this,
                                "Koneksi gagal: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}