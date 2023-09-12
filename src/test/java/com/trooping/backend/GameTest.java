package com.trooping.backend;

import com.trooping.backend.core.Game;
import com.trooping.backend.core.map.Location;
import com.trooping.backend.core.map.Map;
import com.trooping.backend.core.map.Pos;
import com.trooping.backend.core.team.Diplomacy;
import com.trooping.backend.core.team.Team;
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
         Location village1 = new Location("village1",new Pos(0, 10),team1);
         Location town1 = new Location("town1",new Pos(-6.2f, 2),team2);
         map.addLocation(village1);
         map.addLocation(town1);

         Troop troop1 = new Troop("troop1",new Pos(0, 0), team1);
         troop1.addUnit(UnitType.CAVALRY, 10);
         troop1.addUnit(UnitType.SWORDSMAN, 10);
         System.out.println(troop1.getArmy());
         Troop troop2 = new Troop("troop2",new Pos(1, 4), team2);
         troop2.addUnit(UnitType.SPEAR_WARRIOR, 20);
         troop2.addUnit(UnitType.SWORDSMAN, 10);
         System.out.println(troop2.getArmy());

         troop1.setTarget(troop2);

         map.addTroop(troop1);
         map.addTroop(troop2);

         assert new Pos(0,0).equals(new Pos(0,0));

         troop1.incorporateArmy(troop2.getArmy());
         System.out.println(troop1.getArmy());
         System.out.println(troop2.getArmy());


         return new Game(map, diplomacy);
     }
}
