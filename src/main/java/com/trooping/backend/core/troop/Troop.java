package com.trooping.backend.core.troop;

import com.trooping.backend.core.map.Location;
import com.trooping.backend.core.map.Map;
import com.trooping.backend.core.map.MapObject;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.team.Team;
import com.trooping.backend.core.units.UnitType;
import lombok.Getter;

public class Troop extends MapObject {
    //TODO: buffs
    @Getter
    private Army army;
    private TroopStats troopStats = new TroopStats(1);
    private Pos vec = new Pos(0, 0);//moves this direction
    private Pos targetPos;
    private MapObject target;// move to this and compute each update the vec, if null just move constant to vec

    public Troop(String name, Pos pos, Team team) {
        super(name, pos, team);
        this.army = new Army();
    }

    private boolean move(float delta) {
        float speed = troopStats.getSpeed();
        if (target != null) {
            setTargetPos(target.getPos());
        }
        Pos futurePos = vec.times(speed * delta);
        if (checkCollision(getPos().getX(), getPos().getY(), targetPos.getX(), targetPos.getY(), futurePos.getX(), futurePos.getY())) {

            setPos(targetPos);
            return true;
        }
        setPos(getPos().add(vec.times(speed * delta)));
        return false;
    }

    public void update(float delta, Map map) {
        if (vec.getX() == 0 && vec.getY() == 0) {
            //don't move
            return;
        }
        boolean arrived = move(delta);

        if (arrived && target != null) {
            //TODO: if neutral or own team?
            if (target instanceof Troop && target.getTeam() != this.getTeam()) {
                map.startBattle(this, (Troop) target, this.getPos());
            }
            //TODO: what happens if neutral or own team location?
            if (target instanceof Location && target.getTeam() != this.getTeam()) {
                map.startBattle(this, (Location) target, this.getPos());
            }
        }
    }

    private boolean checkCollision(float x1, float y1, float targetX, float targetY, float futureX, float futureY) {
        float initialDifferenceX = targetX - x1;
        float initialDifferenceY = targetY - y1;

        float futureDifferenceX = targetX - futureX;
        float futureDifferenceY = targetY - futureY;

        return (initialDifferenceX * futureDifferenceX < 0) || (initialDifferenceY * futureDifferenceY < 0);
    }


    public void setTroopStats(TroopStats troopStats) {
        this.troopStats = troopStats;
    }

    //FIXME: seems odd to just replicate the method form Army here
    public void addUnit(UnitType unitType, int amount) {
        army.addUnit(unitType, amount);
    }

    public void setVec(Pos vec) {
        this.vec = vec.normalized().times(troopStats.getSpeed());
    }

    public void setTarget(MapObject target) {
        this.target = target;
        setVec(target.getPos().minus(getPos()).normalized());
    }

    //FIXME: Why is this private?
    private void setTargetPos(Pos targetPos) {
        this.targetPos = targetPos;
        setVec(targetPos.minus(getPos()).normalized());
    }

    public void incorporateArmy(Army army) {
        army.getUnits().stream()
            .forEach(unit -> this.army.addUnit(unit.getUnitType(), unit.getQuantity()));
        army.getUnits().clear();
    }
}
