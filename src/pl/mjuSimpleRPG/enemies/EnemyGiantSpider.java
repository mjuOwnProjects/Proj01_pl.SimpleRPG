package pl.mjuSimpleRPG.enemies;

public class EnemyGiantSpider extends Enemy {
    public EnemyGiantSpider() {
        super();
        super.setHealthPoints(13);
        super.setDefencePoints(14);
        super.setAttackPoints(15);
        super.setCanUseAddons(false);
        super.setEnemyName("Wielka tarantula");
    }
}
