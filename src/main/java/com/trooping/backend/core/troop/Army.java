package com.trooping.backend.core.troop;

import com.trooping.backend.core.units.Unit;
import com.trooping.backend.core.units.UnitType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(UnitType unitType, float number){
        units.stream()
                .filter(unit -> unit.getUnitType() == unitType)
                .forEach(unit -> unit.setQuantity(unit.getQuantity() + number));
    }
}
