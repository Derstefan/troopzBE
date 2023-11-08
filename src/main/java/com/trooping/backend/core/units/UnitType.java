package com.trooping.backend.core.units;

import java.util.Arrays;
import java.util.List;

public enum UnitType {

    CAVALRY(
            "cavalry",
            1.5f,
            1,
            Arrays.asList(1f,1.5f,1f)
    ),
    SWORDSMAN(
            "swordsman",
            1,
            2,
            Arrays.asList(1f,1f,1.3f)),
    SPEAR_WARRIOR(
            "spear warrior",
            1.2f,
            2,
            Arrays.asList(1.5f,1f,1f));

    private String name;
    private float speed;
    private float attackDelay;

    private List<Float> attackMultipliers;

    private UnitType(String name, float speed, float attackDelay, List<Float> attackMultipliers) {
        this.name = name;
        this.speed = speed;
        this.attackDelay = attackDelay;
        this.attackMultipliers = attackMultipliers;
    }

    public String getName() {
        return name;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAttackDelay() {
        return attackDelay;
    }

    public float getAttackMultiplierAgainst(UnitType unitType) {
        return attackMultipliers.get(unitType.ordinal());
    }
}
