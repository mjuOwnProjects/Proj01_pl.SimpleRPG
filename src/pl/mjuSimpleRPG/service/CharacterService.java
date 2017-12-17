package pl.mjuSimpleRPG.service;

import pl.mjuSimpleRPG.enemies.*;
import pl.mjuSimpleRPG.players.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CharacterService {

    private List<GenericPlayer> playerCharacters = new ArrayList<>();
    private List<Enemy> listOfEnemies = new ArrayList<>();

    public CharacterService() {
    }

    public void createListOfPlayers() {


        this.playerCharacters.add(new PlayerAnorectic());
        this.playerCharacters.add(new PlayerCompanyManager());
        this.playerCharacters.add(new PlayerKnight());
        this.playerCharacters.add(new PlayerPoliceman());
        this.playerCharacters.add(new PlayerProjectManager());
        this.playerCharacters.add(new PlayerSpy());

    }

    public void createListOfEnemies() {

        this.listOfEnemies.add(new EnemyBee());
        this.listOfEnemies.add(new EnemyGiantSpider());
        this.listOfEnemies.add(new EnemyGobblin());
        this.listOfEnemies.add(new EnemyOfficeIdiot());
        this.listOfEnemies.add(new EnemyOrc());
        this.listOfEnemies.add(new EnemySnake());

    }

    public Enemy getRandomEnemyAndRemoveFromEnemiesList(List<Enemy> enemiesList) {

        int randomEnemyID=0;

        Random randomGenerator = new Random();
        if (enemiesList.size() > 1) {
            randomEnemyID = randomGenerator.nextInt(enemiesList.size() - 1);
        } else {
            randomEnemyID = 0;
        }

        Enemy chosenEnemy = enemiesList.get(randomEnemyID);
        enemiesList.remove(randomEnemyID);

        return chosenEnemy;
    }

    public void displayPossiblePlayerCharacters(List<GenericPlayer> playerList) {
        for(GenericPlayer currentCharacter : playerList) {
            System.out.println(
                    "["+(playerList.indexOf(currentCharacter)+1)+"] "+currentCharacter.getPlayerName() +
                            " (HP: " + currentCharacter.getHealthPoints() +
                            ", AP: " + currentCharacter.getAttackPoints() +
                            ", DP: " + currentCharacter.getDefencePoints() +
                            ")");
        }
        System.out.println("----------------------");
    }

    public void displayPlayerDetails(GenericPlayer player, boolean considereAddons) {
        if (considereAddons) {
            System.out.print(player.getPlayerName() + " dzięki tym premiom staje do walki z następującą charaktestyką" +
                    " (HP: " + player.getHealthPointsWithAddon() +
                    ", AP: " + player.getAttackPointsWithAddon() +
                    ", DP: " + player.getDefencePointsWithAddon() +
                    ")");
            System.out.println("\n----------------------");
        } else {
            System.out.println(player.getPlayerName().toLowerCase() +
                    " (HP: " + player.getHealthPoints() +
                    ", AP: " + player.getAttackPoints() +
                    ", DP: " + player.getDefencePoints() +
                    ")");
            System.out.println("----------------------");
        }
    }

    public String displayEnemyDetails(Enemy enemy, boolean considereAddons) {
        if (considereAddons) {
            return enemy.getEnemyName().toLowerCase() +
                    " (HP: " + enemy.getHealthPointsWithAddon() +
                    ", AP: " + enemy.getAttackPointsWithAddon() +
                    ", DP: " + enemy.getDefencePointsWithAddon() +
                    ")";
        } else {
            return enemy.getEnemyName().toLowerCase() +
                    " (HP: " + enemy.getHealthPoints() +
                    ", AP: " + enemy.getAttackPoints() +
                    ", DP: " + enemy.getDefencePoints() +
                    ")";
        }
    }

    public GenericPlayer chooseYourCharacter(List<GenericPlayer> playerCharactersList) {


        Scanner getCharaceterID = new Scanner(System.in);


        int tempID = -1;
        while (tempID<0 || tempID>=playerCharactersList.size()) {
            String tempString = null;
            System.out.print("Wybieram postać numer: ");
            tempString = getCharaceterID.next();
            try {
                tempID=(Integer.parseInt(tempString))-1;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("\nWybierz poprawny numer postaci: ");
                tempID=-1;
            }
        }

        GenericPlayer chosenCharacter = playerCharactersList.get(tempID);

        return chosenCharacter;

    }

    public void confirmChosenCharacter(GenericPlayer chosenCharacter) {
        System.out.println("Wybrana postać to " + chosenCharacter.toString());
        System.out.println("----------------------");
    }

    public List<GenericPlayer> getPlayerCharacters() {
        return playerCharacters;
    }

    public List<Enemy> getListOfEnemies() {
        return listOfEnemies;
    }
}