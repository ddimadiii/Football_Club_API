package com.example.footballclub.spain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.footballclub.MainActivity;
import com.example.footballclub.R;

public class MainMenu extends AppCompatActivity {

    Button btEnglish, btTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        btEnglish = (Button) findViewById(R.id.btEnglish);
        btTeam = (Button) findViewById(R.id.btTeam);
//
//        btnPlayer.setOnClickListener(v -> {
//            Toast.makeText(MainMenu.this, "Player clicked!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Ma)
//            startActivity(new Intent(MainMenu.this, MainActivity.class));
//        });

        btEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        btnTeam.setOnClickListener(v -> {
//            Toast.makeText(MainMenu.this, "Team clicked!", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainMenu.this, MainActivityTeam.class));
//        });

        btTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, MainActivityTeam.class);
                startActivity(intent);
            }
        });
    }
}