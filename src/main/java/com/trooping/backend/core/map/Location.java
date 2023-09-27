package com.trooping.backend.core.map;

import com.trooping.backend.core.team.Team;

public class Location extends MapObject{
    private LocationType locationType;
    public  Location(String name, Pos pos, Team team, LocationType locationType) {
        super(name,pos,team);
        this.locationType = locationType;
    }

    public void update(float delta) {

    }
}
