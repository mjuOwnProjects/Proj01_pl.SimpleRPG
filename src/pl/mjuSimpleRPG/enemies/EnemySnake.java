package pl.mjuSimpleRPG.enemies;

public class EnemySnake extends Enemy {
    public EnemySnake() {
        super();
        super.setHealthPoints(40);
        super.setDefencePoints(40);
        super.setAttackPoints(15);
        super.setCanUseAddons(false);
        super.setEnemyName("Wąż");
    }
}
