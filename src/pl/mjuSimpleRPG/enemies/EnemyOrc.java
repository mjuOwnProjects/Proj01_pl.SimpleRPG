package pl.mjuSimpleRPG.enemies;

public class EnemyOrc extends Enemy {
    //private GenericAddon genericAddon1 = new AddonShield();

    public EnemyOrc() {
        super();
        super.setHealthPoints(50);
        super.setDefencePoints(50);
        super.setAttackPoints(5);
        super.setCanUseAddons(true);
        super.setEnemyName("Ork");
        //super.setGenericAddon1(genericAddon1);
    }
}