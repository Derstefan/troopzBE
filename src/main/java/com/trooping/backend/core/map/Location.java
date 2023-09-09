package com.trooping.backend.core.map;

import com.trooping.backend.core.team.Team;

public class Location extends MapObject{
    public  Location(String name, Pos pos, Team team) {
        super(name,pos,team);
    }

    public void update(float delta) {

    }
}
