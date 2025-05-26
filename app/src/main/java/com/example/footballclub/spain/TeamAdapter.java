package com.example.footballclub.spain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.footballclub.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> teams;

    // Constructor: terima list Player dari Activity
    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }

    // 1. Inflate layout item dan buat ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new ViewHolder(v);
    }

    // 2. Bind data ke ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team t = teams.get(position);
        holder.tvLeague.setText(t.getStrLeague());
        holder.tvTeam.setText(t.getStrTeam());

        // load gambar thumbnail (bisa null – cek dulu)
        String badge = t.getStrBadge();
        if (badge != null && !badge.isEmpty()) {
            Glide.with(holder.itemView.getContext())
            .load(badge)
                    .into(holder.imgBadge);
        } else {
            holder.imgBadge.setImageResource(R.drawable.ic_launcher_background);
        }

//        if (t.getStrLeague() != null && !t.getStrBadge().isEmpty()) {
//            Glide.with(holder.itemView.getContext())
//                    .load(t.getStrBadge())
//                    .into(holder.imgBadge);
//        } else {
//            holder.imgBadge.setImageResource(R.drawable.ic_launcher_background);
//        }
    }

    // 3. Jumlah data
    @Override
    public int getItemCount() {
        return teams == null ? 0 : teams.size();
    }

    // 4. ViewHolder: cache view-item
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBadge;
        TextView tvLeague, tvTeam;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBadge = itemView.findViewById(R.id.imgTeam);
            tvTeam   = itemView.findViewById(R.id.tvTeamName);
            tvLeague = itemView.findViewById(R.id.tvLeagueName);
        }
    }
}
