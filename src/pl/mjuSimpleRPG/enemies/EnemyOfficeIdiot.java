package pl.mjuSimpleRPG.enemies;

public class EnemyOfficeIdiot extends Enemy {
    public EnemyOfficeIdiot() {
        super();
        super.setHealthPoints(10);
        super.setDefencePoints(10);
        super.setAttackPoints(10);
        super.setCanUseAddons(true);
        super.setEnemyName("Biurowy Głupek");
    }
}
