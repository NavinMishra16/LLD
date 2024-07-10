package org.example;
import  static org.junit.Assert.*;
import org.example.domain.Player;
import org.example.domain.Warrior;
import org.example.services.Arena;
import  org.junit.Test;
import  org.junit.Before;

public class ArenaTest {
    private Arena arena ;
    private Player player1;
    private  Player player2;

    @Before
    public void setup(){
        arena = new Arena();
        player1 = new Warrior("Navin", 90, 10, 6);
        player2 = new Warrior("Yuvraj", 100, 5, 10);
    }

    @Test
    public void testStartBattle(){
        arena.startBattle(player1, player2);
        assertEquals(1, arena.getOngoingBattles().size());
    }
    @Test
    public void testProcessBattle(){
        arena.startBattle(player1,player2);
        while(!arena.getOngoingBattles().isEmpty()){
            arena.processBattles();
        }
        assertTrue(arena.getOngoingBattles().isEmpty());
    }
    @Test
    public void BattleSequence(){
        arena.startBattle(player1,player2);
        while (!arena.getOngoingBattles().isEmpty()) {
            arena.processBattles();
        }
        assertFalse(player1.isAlive() && player2.isAlive());
    }

}
