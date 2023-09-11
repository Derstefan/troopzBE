package com.trooping.backend.core.units;

import lombok.Data;
import lombok.NonNull;

@Data
public class Unit {
    private final UnitType unitType;
    @NonNull
    private float quantity;

    public void reduceQuantityBy(float amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid negative amount: " + amount);
        }
        this.quantity -= amount;
    }

    public boolean isDefeated() {
        return quantity <= 0f;
    }
}
