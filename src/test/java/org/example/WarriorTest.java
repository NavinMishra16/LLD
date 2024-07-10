package org.example;
import org.example.domain.Warrior;
import org.junit.Before;
import  org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

public class WarriorTest {
    private Warrior warrior;
    private Random random;
    private int initialHealth;
    @Before
    public void setup() {
        warrior  = new Warrior("Navin", 90, 10, 6);
        random = new Random();
        initialHealth = warrior.getHealth();
    }

    @Test
    public void testAttack() {
        int diceRoll = random.nextInt(6) + 1;
        int attack  =  warrior.getAttack();
        int expectedAttack = attack * diceRoll;
        assertEquals(expectedAttack, warrior.attack(diceRoll));
    }
    @Test
    public void testDefend() {
        int diceRoll = random.nextInt(6) + 1;
        int strength = warrior.getStrength();
        int expectedDefense = strength * diceRoll;
        assertEquals(expectedDefense, warrior.defend(diceRoll));
    }

    @Test
    public void testReduceHealth(){
        int damage = warrior.getAttack()*(random.nextInt(6)+1);
        warrior.reduceHealth(damage);
        assertEquals(initialHealth - damage, warrior.getHealth());
    }

    @Test
    public void testIsAlive() {
        assertTrue(warrior.isAlive());
        warrior.reduceHealth(warrior.getHealth());
        assertFalse(warrior.isAlive());
    }

    @Test
    public void testAttackZeroDiceRoll() {
        int expectedAttack = 0;
        assertEquals(expectedAttack, warrior.attack(0));
    }

    @Test
    public void testDefendZeroDiceRoll() {
        int expectedDefense = 0;
        assertEquals(expectedDefense, warrior.defend(0));
    }

    @Test
    public void testReduceHealthNegativeDamage() {
        warrior.reduceHealth(-10);
        assertEquals(initialHealth, warrior.getHealth());
    }

    @Test
    public void testIsAliveWithNegativeHealth() {
        warrior.reduceHealth(initialHealth + 1);
        assertFalse(warrior.isAlive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeHealth() {
        new Warrior("Invalid", -10, 10, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeStrength() {
        new Warrior("Invalid", 90, -10, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeAttack() {
        new Warrior("Invalid", 90, 10, -6);
    }
}
