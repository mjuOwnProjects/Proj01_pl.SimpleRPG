package pl.mjuSimpleRPG.addons;

public class AddonKnife extends GenericAddon {

    public AddonKnife() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(5);
        super.setAttackPointsBonus(5);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(true);
        super.setAddonName("Nóż");
    }
}
