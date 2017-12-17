package pl.mjuSimpleRPG.service;

import org.junit.Before;
import org.junit.Test;
import pl.mjuSimpleRPG.addons.GenericAddon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddonsServiceTest {

    private AddonsService addonsServiceTest;
    private List<GenericAddon> addonsTestList;
    private GenericAddon randomAddonForPlayer;
    private GenericAddon randomAddonForEnemy;
    private GenericAddon randomAddonForMultipleGeneration;

    @Before
    public void setUp() {
        this.addonsServiceTest = new AddonsService();
        this.addonsTestList = new ArrayList<>();

        this.addonsServiceTest.createAddonsList();
        this.addonsTestList = addonsServiceTest.getAddonsList();
        this.randomAddonForPlayer = addonsServiceTest.getRandomAddon(addonsTestList,true);
        this.randomAddonForEnemy = addonsServiceTest.getRandomAddon(addonsTestList,false);
    }

    @Test
    public void testAddonsListCreation() {
        assertEquals(true, addonsTestList.size()>0);
    }

    @Test
    public void testGetRandomAddonForPlayer() {
        assertNotNull(randomAddonForPlayer.getHealthPointsBonus());
        assertNotNull(randomAddonForPlayer.getAttackPointsBonus());
        assertNotNull(randomAddonForPlayer.getDefencePointsBonus());
        assertTrue(randomAddonForPlayer.getPossibleForPlayer());
        assertNotNull(randomAddonForPlayer.getPossibleForEnemy());
        assertNotNull(randomAddonForPlayer.getAddonName());
    }

    @Test
    public void testGetRandomAddonForEnemy() {
        assertNotNull(randomAddonForEnemy.getHealthPointsBonus());
        assertNotNull(randomAddonForEnemy.getAttackPointsBonus());
        assertNotNull(randomAddonForEnemy.getDefencePointsBonus());
        assertNotNull(randomAddonForEnemy.getPossibleForPlayer());
        assertTrue(randomAddonForEnemy.getPossibleForEnemy());
        assertNotNull(randomAddonForEnemy.getAddonName());
    }

    @Test
    public void checkIfEveryTimeRandomAddonIsGeneratedForProperCharacter() {
        //check if generated properly for enemy
        for (int i=0;i<1000;i++) {
            this.randomAddonForMultipleGeneration = addonsServiceTest.getRandomAddon(addonsTestList,false);
            assertTrue(this.randomAddonForMultipleGeneration.getPossibleForEnemy());
        }

        //check if generated properly for enemy
        for (int i=0;i<1000;i++) {
            this.randomAddonForMultipleGeneration = addonsServiceTest.getRandomAddon(addonsTestList,true);
            assertTrue(this.randomAddonForMultipleGeneration.getPossibleForPlayer());
        }
    }

    @Test
    public void checkDisplayDetailsAboutAddon() {
        for (int i=0;i<1000;i++) {
            this.randomAddonForMultipleGeneration = addonsServiceTest.getRandomAddon(addonsTestList,false);
            assertTrue( addonsServiceTest.displayDetailsAboutAddon(randomAddonForMultipleGeneration).length()>0 );
        }

        for (int i=0;i<1000;i++) {
            this.randomAddonForMultipleGeneration = addonsServiceTest.getRandomAddon(addonsTestList,true);
            assertTrue( addonsServiceTest.displayDetailsAboutAddon(randomAddonForMultipleGeneration).length()>0 );
        }
    }

}