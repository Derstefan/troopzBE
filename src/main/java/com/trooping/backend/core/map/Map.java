package com.trooping.backend.core.map;

import com.trooping.backend.core.battle.Battle;
import com.trooping.backend.core.troop.Troop;

import java.util.ArrayList;
import java.util.UUID;

public class Map {

    private float width;
    private float height;

    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<Troop> troops = new ArrayList<>();
    private ArrayList<Battle> battles = new ArrayList<>();

    public Map(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void update(float delta) {
        for (Location location : locations) {
            location.update(delta);
        }
        for (Troop troop: troops){
            troop.update(delta, this);
            //TODO: maybe start battle
        }
        ArrayList<Battle> endedBattles = new ArrayList<>();
        for (Battle battle : battles) {
            boolean isOver = battle.update(delta);
            if(isOver){
                endedBattles.add(battle);
                //TODO: battle is Over
            }
        }
        battles.removeAll(endedBattles);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addTroop(Troop troop) {
        troops.add(troop);
    }

    public void startBattle(Troop attacker, Troop defender, Pos pos){
        System.out.println("battle started");
        battles.add(new Battle(attacker.getArmy(),defender.getArmy(),pos));
    }

    public void startBattle(Troop attacker, Location location, Pos pos){
        // battles.add(new Battle(attacker.getArmy(),location.getArmy(),pos));
    }

    public void changeMovement(UUID troopId, Pos vec){
        getTroop(troopId).setVec(vec);
    }

    public void changeMovement(UUID troopId, UUID targetId){
        getTroop(troopId).setVec(getLocation(targetId).getPos());
    }

    public void stop(UUID troopId){
        getTroop(troopId).setVec(null);
    }



    public Troop getTroop(UUID troopId){
        return troops.stream().filter(troop -> troop.getUuid().equals(troopId))
                .findFirst()
                .orElse(null);
    }

    public Location getLocation(UUID locationId){
        return locations.stream().filter(location -> location.getUuid().equals(locationId))
                .findFirst()
                .orElse(null);
    }
}
