package com.trooping.backend.core.team;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Team> allies = new ArrayList<>();
    private ArrayList<Team> enemies = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addAlly(Team ally) {
        allies.add(ally);
    }

    public void addEnemy(Team enemy) {
        enemies.add(enemy);
    }

    public void removeAlly(Team ally) {
        allies.remove(ally);
    }

    public void removeEnemy(Team enemy) {
        enemies.remove(enemy);
    }

}
