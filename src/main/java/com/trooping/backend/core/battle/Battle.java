package com.trooping.backend.core.battle;

import com.trooping.backend.core.general.Updatable;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.troop.Army;
import com.trooping.backend.core.units.Unit;
import com.trooping.backend.core.units.UnitType;

public class Battle implements Updatable {
    private final Army attacker;
    private final Army defender;
    private final Pos pos;

    private float duration = 0;

    public Battle(Army attacker, Army defender, Pos pos) {
        this.attacker = attacker;
        this.defender = defender;
        this.pos = pos;
    }

    public boolean willTheDefendingUnitSurvive(Unit attackingUnit, Unit defendingUnit, float delta) {
        UnitType attackingUnitType = attackingUnit.getUnitType();
        if (duration >= attackingUnitType.getAttackDelay()) {
            float attackMultiplier = attackingUnitType.getAttackMultiplierAgainst(defendingUnit.getUnitType());
            float quantity = attackingUnit.getQuantity();
            defendingUnit.reduceQuantityBy(quantity * attackMultiplier * delta);
        }
        return defendingUnit.isDefeated();
    }

    @Override
    public boolean update(float delta) {
        duration += delta;
        boolean attackerLost = false;
        boolean defenderLost = true;
        for (Unit attackingUnit : attacker.getUnits()) {
            for (Unit defendingUnit : defender.getUnits()) {
                defenderLost = defenderLost && willTheDefendingUnitSurvive(attackingUnit, defendingUnit, delta);
            }
        }

        for (Unit attackingUnit : defender.getUnits()) {
            for (Unit defendingUnit : attacker.getUnits()) {
                attackerLost = attackerLost && willTheDefendingUnitSurvive(attackingUnit, defendingUnit, delta);
            }
        }
        System.out.println("battle is ongoing");
        if (attackerLost || defenderLost) {
            System.out.println("battle is over");
            return true;
        }
        return false;
    }

    public Pos getPos() {
        return pos;
    }
}
