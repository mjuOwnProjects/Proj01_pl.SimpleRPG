package pl.mjuSimpleRPG.addons;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericAddonTest {

    private GenericAddon genericAddonTest;
    private GenericAddon genericAddonWithParameter1;
    private GenericAddon genericAddonWithParameter2;
    private GenericAddon genericAddonWithParameter3;
    private GenericAddon genericAddonWithParameter4;

    @Before
    public void setUp() {
        this.genericAddonTest = new GenericAddon();
        this.genericAddonWithParameter1 = new GenericAddon(10,10,10,false,false,"Test Addon 1");
        this.genericAddonWithParameter2 = new GenericAddon(10,10,10,true,false,"Test Addon 2");
        this.genericAddonWithParameter3 = new GenericAddon(10,10,10,false,true,"Test Addon 3");
        this.genericAddonWithParameter4 = new GenericAddon(-10,-10,-10,true,true,"Test Addon 4");
    }

    @Test
    public void genericAddonCreationWithDefaultConstructor() {
        assertEquals(0, genericAddonTest.getHealthPointsBonus());
        assertEquals(0,genericAddonTest.getAttackPointsBonus());
        assertEquals(0,genericAddonTest.getDefencePointsBonus());
        assertEquals(true,genericAddonTest.getPossibleForPlayer());
        assertEquals(true,genericAddonTest.getPossibleForEnemy());
        assertEquals(null,genericAddonTest.getAddonName());
    }

    @Test
    public void setGenericAddonWithParameter1() {
        assertEquals(10, genericAddonWithParameter1.getHealthPointsBonus());
        assertEquals(10,genericAddonWithParameter1.getAttackPointsBonus());
        assertEquals(10,genericAddonWithParameter1.getDefencePointsBonus());
        assertEquals(false,genericAddonWithParameter1.getPossibleForPlayer());
        assertEquals(false,genericAddonWithParameter1.getPossibleForEnemy());
        assertEquals("Test Addon 1",genericAddonWithParameter1.getAddonName());
    }

    @Test
    public void setGenericAddonWithParameter2() {
        assertEquals(10, genericAddonWithParameter2.getHealthPointsBonus());
        assertEquals(10,genericAddonWithParameter2.getAttackPointsBonus());
        assertEquals(10,genericAddonWithParameter2.getDefencePointsBonus());
        assertEquals(true,genericAddonWithParameter2.getPossibleForPlayer());
        assertEquals(false,genericAddonWithParameter2.getPossibleForEnemy());
        assertEquals("Test Addon 2",genericAddonWithParameter2.getAddonName());
    }

    @Test
    public void setGenericAddonWithParameter3() {
        assertEquals(10, genericAddonWithParameter3.getHealthPointsBonus());
        assertEquals(10,genericAddonWithParameter3.getAttackPointsBonus());
        assertEquals(10,genericAddonWithParameter3.getDefencePointsBonus());
        assertEquals(false,genericAddonWithParameter3.getPossibleForPlayer());
        assertEquals(true,genericAddonWithParameter3.getPossibleForEnemy());
        assertEquals("Test Addon 3",genericAddonWithParameter3.getAddonName());
    }

    @Test
    public void negativeParametersPassedToAddon() {
        assertEquals(-100, genericAddonWithParameter4.getHealthPointsBonus());
        assertEquals(-100,genericAddonWithParameter4.getAttackPointsBonus());
        assertEquals(-100,genericAddonWithParameter4.getDefencePointsBonus());
        assertEquals(true,genericAddonWithParameter4.getPossibleForPlayer());
        assertEquals(true,genericAddonWithParameter4.getPossibleForEnemy());
        assertEquals("Test Addon 4",genericAddonWithParameter4.getAddonName());
    }

}
