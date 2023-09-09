package com.trooping.backend.core.team;

import java.util.ArrayList;

public class Diplomacy {

    private ArrayList<Team> teams;

    public Diplomacy() {
        teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void alliance(Team team1, Team team2) {
        team1.addAlly(team2);
        team2.addAlly(team1);
    }

    public void war(Team team1, Team team2) {
        team1.addEnemy(team2);
        team2.addEnemy(team1);
    }

    public void neutral(Team team1, Team team2) {
        team1.removeAlly(team2);
        team2.removeAlly(team1);
        team1.removeEnemy(team2);
        team2.removeEnemy(team1);
    }

}
