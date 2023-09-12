package com.trooping.backend.core;

import com.trooping.backend.core.map.Map;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.team.Diplomacy;
import com.trooping.backend.core.troop.Troop;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
@Slf4j
public class Game {

    private Map map;
    private Diplomacy diplomacy;

    public Game(Map map, Diplomacy diplomacy) {
        this.map = map;
        this.diplomacy = diplomacy;
    }
    public void update(float delta) {
        map.update(delta);
    }

    public Map getMap() {
        return map;
    }

    public Diplomacy getDiplomacy() {
        return diplomacy;
    }

    //dynamic gamecontroller


    public void changeMovement(UUID troopId, Pos vec){
        map.changeMovement(troopId,vec);
    }

    public void changeMovement(UUID troopId, UUID targetId){
        map.changeMovement(troopId,targetId);
    }
    public void stop(UUID troopId){
        map.stop(troopId);
    }

    // recruit

}
