package pl.mjuSimpleRPG.enemies;

public class EnemyGobblin extends Enemy {
    public EnemyGobblin() {
        super();
        super.setHealthPoints(5);
        super.setDefencePoints(5);
        super.setAttackPoints(5);
        super.setCanUseAddons(true);
        super.setEnemyName("Chudy goblin");
    }
}
