package com.trooping.backend.core.troop;

import com.trooping.backend.core.units.UnitType;

import java.util.ArrayList;
import java.util.HashMap;

public class Army {
    private HashMap<UnitType,Float> units = new HashMap<>();

    public float getNumber(UnitType unitType){
        if(units.keySet().contains(unitType)) {
            return units.get(unitType);
        }
        return 0;
    }

    public ArrayList<UnitType> getUnitTypes(){
        return new ArrayList<>(units.keySet());
    }

    //returns true if number<=0
    public boolean reduceNumber(UnitType unitType, float number){
        units.put(unitType,units.get(unitType)-number);
        if(units.get(unitType)<=0){
            units.remove(unitType);
            return true;
        }
        return false;
    }

    public void addUnits(UnitType unitType, float number){
        if(units.keySet().contains(unitType)) {
            units.put(unitType, units.get(unitType) + number);
        }else{
            units.put(unitType,number);
        }
    }

    //union of armies
}
