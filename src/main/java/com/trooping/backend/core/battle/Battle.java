package com.trooping.backend.core.battle;

import com.trooping.backend.core.general.Updatable;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.troop.Army;
import com.trooping.backend.core.units.UnitType;

public class Battle implements Updatable {
    private Army attacker;
    private Army defender;
    private Pos pos;

    private float time = 0;

    public Battle(Army attacker, Army defender, Pos pos) {
        this.attacker = attacker;
        this.defender = defender;
        this.pos = pos;
    }


    //returns true if battle is over
    @Override
    public boolean update(float delta) {
        time += delta;
        boolean attackerLost = false;
        boolean defenderLost = true;
        for (UnitType attackUnitType : attacker.getUnitTypes()) {
            for (UnitType defendUnitType : defender.getUnitTypes()) {
                float num = attacker.getNumber(attackUnitType);
                float attack = attackUnitType.attMultiplier(defendUnitType, time);
                defenderLost = defenderLost && defender.reduceNumber(defendUnitType, num * attack*delta);
            }
        }

        for (UnitType attackUnitType : defender.getUnitTypes()) {
            for (UnitType defendUnitType : attacker.getUnitTypes()) {
                float num = defender.getNumber(attackUnitType);
                float attack = attackUnitType.attMultiplier(defendUnitType, time);
                attackerLost = attackerLost && attacker.reduceNumber(defendUnitType, num * attack*delta);
            }
        }
        System.out.println("battle is ongoing");
        if(attackerLost || defenderLost){
            System.out.println("battle is over");
            return true;
        }
        return false;
    }


    public Pos getPos() {
        return pos;
    }

}
