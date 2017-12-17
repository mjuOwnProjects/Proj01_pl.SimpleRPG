package pl.mjuSimpleRPG.service;

import pl.mjuSimpleRPG.addons.*;
import pl.mjuSimpleRPG.enemies.Enemy;
import pl.mjuSimpleRPG.players.GenericPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AddonsService {

    private List<GenericAddon> addonsList = new ArrayList<>();

    public void createAddonsList() {

        this.addonsList.add(new AddonChain());
        this.addonsList.add(new AddonCoffeeCup());
        this.addonsList.add(new AddonKnife());
        this.addonsList.add(new AddonM16());
        this.addonsList.add(new AddonMobilePhone());
        this.addonsList.add(new AddonShield());
        this.addonsList.add(new AddonTNT());
    }

    /**
     *
     * @param addonsList list of all addons created with usage of createAddonsList()
     * @param isItForPlayer defines if this addon might be used by player or only by enemy
     * @return Returns particular object of GenericAddon type
     */
    public GenericAddon getRandomAddon(List<GenericAddon> addonsList, boolean isItForPlayer) {

        int randomAddonID=0;

        Random randomGenerator = new Random();
        randomAddonID = randomGenerator.nextInt(addonsList.size() - 1);
        GenericAddon randomGeneratedAddon = addonsList.get(randomAddonID);

        if (isItForPlayer) {
            while (!randomGeneratedAddon.getPossibleForPlayer()) {
                randomAddonID = randomGenerator.nextInt(addonsList.size() - 1);
                randomGeneratedAddon = addonsList.get(randomAddonID);
            }
        } else {
            while (!randomGeneratedAddon.getPossibleForEnemy()) {
                randomAddonID = randomGenerator.nextInt(addonsList.size() - 1);
                randomGeneratedAddon = addonsList.get(randomAddonID);
            }
        }

        return randomGeneratedAddon;
    }

    public String displayDetailsAboutAddon(GenericAddon addon) {
        String message =addon.getAddonName() + " daje następujące premie" +
                " (HP: " + addon.getHealthPointsBonus() +
                ", AP: " + addon.getAttackPointsBonus() +
                ", DP: " + addon.getDefencePointsBonus() +
                "). ";
        System.out.print(message);
        return message;
    }

    public void stealAddonFromEnemy (GenericPlayer player, Enemy enemy) {
        if (checkIfEnemyHadAddon(enemy)) {
            System.out.print(enemy.getEnemyName() + " miał przy sobie " + enemy.getGenericAddon1().getAddonName() + ". Czy chcesz spróbować ukraść ten przedmiot? [t/n] ");
            Scanner getOption = new Scanner(System.in);

            String tempString = null;
            tempString = getOption.next();
            while ( !("t".equals(tempString.toLowerCase()) || "n".equals(tempString.toLowerCase())) ) {
                System.out.println("Coś nie kumasz chyba. Pytam raz jeszcz, czy chcesz spróbować ukraść ten przedmiot? [t/n] ");
                tempString = getOption.next();
            }

            if ("t".equals(tempString.toLowerCase())) {
                player.setGenericAddon2(enemy.getGenericAddon1());
                System.out.println("----------------------");
                System.out.println("Kradniesz przedmiot pokonanemu wrogowi. Twoje aktualne wyposażenie: ");
                if (null!=player.getGenericAddon1().getAddonName()) {
                    displayDetailsAboutAddon(player.getGenericAddon1());
                    System.out.println();
                }
                if (null!=player.getGenericAddon2().getAddonName()) {
                    displayDetailsAboutAddon(player.getGenericAddon2());
                }
                System.out.println();
            }
        }

    }

    private boolean checkIfEnemyHadAddon(Enemy enemy) {
        if (enemy.isCanUseAddons() && null!=enemy.getGenericAddon1().getAddonName()) {
            return true;
        } else return false;
    }

    public List<GenericAddon> getAddonsList() {
        return addonsList;
    }
}
