package com.trooping.backend.core.troop;

import com.trooping.backend.core.units.Unit;
import com.trooping.backend.core.units.UnitType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(UnitType unitType, float number) {
        // Find existing units of the same unitType
        Optional<Unit> existingUnit = units.stream()
            .filter(unit -> unit.getUnitType() == unitType)
            .findFirst();

        if (existingUnit.isPresent()) {
            // If an existing unit of the same type is found, update its quantity
            Unit unit = existingUnit.get();
            unit.setQuantity(unit.getQuantity() + number);
        } else {
            // If no existing unit of the same type is found, create a new unit
            Unit newUnit = new Unit(unitType, number);
            units.add(newUnit);
        }
    }
}
