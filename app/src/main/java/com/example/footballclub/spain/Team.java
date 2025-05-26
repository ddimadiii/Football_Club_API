package com.example.footballclub.spain;
import com.google.gson.annotations.SerializedName;
public class Team {
    @SerializedName("strLeague")
    private String strLeague;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")
    private String strBadge;


    // —— getters & setters ——



    public String getStrLeague() {
        return strLeague;
    }
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrBadge() {
        return strBadge;
    }
    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }
}
