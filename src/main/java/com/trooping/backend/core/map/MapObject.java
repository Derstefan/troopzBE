package com.trooping.backend.core.map;

import com.trooping.backend.core.team.Team;

import java.util.UUID;

public abstract class MapObject {

    private UUID uuid;
    private Pos pos;

    private String name;

    private Team team;

    public MapObject(String name,Pos pos, Team team) {
        this.uuid = UUID.randomUUID();
        this.pos = pos;
        this.name = name;
        this.team = team;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }


    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }
}
