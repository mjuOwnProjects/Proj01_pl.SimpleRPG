package pl.mjuSimpleRPG.addons;

public class AddonChain extends GenericAddon {
    /**
     * Constructor for AddonChain
     */
    public AddonChain() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(5);
        super.setAttackPointsBonus(5);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(true);
        super.setAddonName("Lancuch");
    }
}
