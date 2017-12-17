package pl.mjuSimpleRPG.addons;

public class AddonCoffeeCup extends GenericAddon {

    public AddonCoffeeCup() {
        super();
        super.setHealthPointsBonus(20);
        super.setDefencePointsBonus(0);
        super.setAttackPointsBonus(5);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(false);
        super.setAddonName("Kawa w kubku na wynos");
    }
}
