package pl.mjuSimpleRPG.enemies;

public class EnemyBee extends Enemy {
    public EnemyBee() {
        super();
        super.setHealthPoints(5);
        super.setDefencePoints(5);
        super.setAttackPoints(5);
        super.setCanUseAddons(false);
        super.setEnemyName("Głodna pszczoła");
    }
}
