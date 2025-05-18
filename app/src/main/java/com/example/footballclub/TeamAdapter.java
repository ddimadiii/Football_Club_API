package com.example.footballclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.club_item, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);

        holder.txtTeamName.setText(team.getStrTeam());
        holder.txtTeamId.setText("ID: " + team.getIdTeam());
        Picasso.get()
                .load(team.getStrTeamBadge())     // opsional, jika gagal load
                .into(holder.imgTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTeamBadge;
        TextView txtTeamName, txtTeamId;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTeamBadge = itemView.findViewById(R.id.imgTeamBadge);
            txtTeamName = itemView.findViewById(R.id.txtTeamName);
            txtTeamId = itemView.findViewById(R.id.txtTeamId);
        }
    }
}

