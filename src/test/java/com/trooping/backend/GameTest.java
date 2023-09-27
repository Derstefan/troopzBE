package com.trooping.backend;

import com.trooping.backend.core.Game;
import com.trooping.backend.core.map.Location;
import com.trooping.backend.core.map.LocationType;
import com.trooping.backend.core.map.Map;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.team.Diplomacy;
import com.trooping.backend.core.team.Team;
import com.trooping.backend.core.troop.Army;
import com.trooping.backend.core.troop.Troop;
import com.trooping.backend.core.units.UnitType;
import org.junit.jupiter.api.Test;

public class GameTest {




    @Test
    public void testGame() {


        Game game = createTestGame();
        //check if game is not null
        assert game != null;

        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);
        game.update(1);


     }

     private Game createTestGame(){
         Diplomacy diplomacy = new Diplomacy();
         Team team1 = new Team("Team1");
         Team team2 = new Team("Team2");

         diplomacy.addTeam(team1);
         diplomacy.addTeam(team2);

         diplomacy.war(team1, team2);

         Map map = new Map(100, 100);
         Location village1 = new Location("village1",new Pos(0, 10),team1, LocationType.VILLAGE);
         Location town1 = new Location("town1",new Pos(-6.2f, 2),team2, LocationType.TOWN);
         map.addLocation(village1);
         map.addLocation(town1);

         Troop troop1 = new Troop("troop1",new Pos(0, 0), team1, 100);
         troop1.addUnits(UnitType.cavalry, 10);
         troop1.addUnits(UnitType.swordsman, 10);
         Troop troop2 = new Troop("troop2",new Pos(1, 4), team2, 100);
         troop2.addUnits(UnitType.spearWarrior, 20);
         troop2.addUnits(UnitType.swordsman, 10);

         troop1.setTarget(troop2);

         map.addTroop(troop1);
         map.addTroop(troop2);

         troop1.updateBalance(20);
         troop2.updateBalance(-10);



         return new Game(map, diplomacy);
     }
}
