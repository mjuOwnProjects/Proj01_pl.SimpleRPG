package pl.mjuSimpleRPG;

import pl.mjuSimpleRPG.addons.GenericAddon;
import pl.mjuSimpleRPG.enemies.Enemy;
import pl.mjuSimpleRPG.players.GenericPlayer;
import pl.mjuSimpleRPG.service.AddonsService;
import pl.mjuSimpleRPG.service.CharacterService;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private GenericPlayer player;
    private Enemy enemy;
    private int mainRoundsNumber = 1;
    private int currentRoundNumber = 1;
    private List<GenericPlayer> playerCharacters;
    private List<Enemy> enemiesList;
    private List<GenericAddon> addonsList;
    private CharacterService characterService = new CharacterService();
    private AddonsService addonsService = new AddonsService();

    public Game() {

        addonsService.createAddonsList();
        this.addonsList = addonsService.getAddonsList();

        characterService.createListOfPlayers();
        this.playerCharacters = characterService.getPlayerCharacters();
        this.characterService.displayPossiblePlayerCharacters(this.playerCharacters);
        this.player = characterService.chooseYourCharacter(playerCharacters);
        this.player.setGenericAddon1(addonsService.getRandomAddon(addonsList,true));


        characterService.createListOfEnemies();
        this.enemiesList = characterService.getListOfEnemies();
        askForNumberOfMainRounds();
        addonsService.displayDetailsAboutAddon(this.player.getGenericAddon1());
        characterService.displayPlayerDetails(this.player,true);

        mainRoundFight();


        //getRandomEnemyAndRemoveFromEnemiesList();

    }


    private void askForNumberOfMainRounds() {
        int tempEnemiesQunatity = enemiesList.size();
        System.out.print("Wybierz liczbę przeciwników, z którymi chcesz walczyć (maksymalnie " + tempEnemiesQunatity + "): ");
        Scanner readLine = new Scanner(System.in);

        String tempString = null;
        tempString = readLine.next();
        int tempInteger = Integer.parseInt(tempString);


        while (tempInteger>tempEnemiesQunatity || Integer.parseInt(tempString)<=0) {
            System.out.print("Wprowadź prawidłową liczbę przeciwników (od 1 do " + enemiesList.size() + "): ");
            tempString = readLine.next();
            try {
                tempInteger = Integer.parseInt(tempString);
            } catch (java.lang.NumberFormatException e) {
                System.out.print("Wprowadź prawidłową liczbę przeciwników (od 1 do " + enemiesList.size() + "): ");
                tempInteger=tempEnemiesQunatity+10;
            }
        }
        System.out.println("----------------------");
        this.mainRoundsNumber = Integer.parseInt(tempString);

    }

    public void mainRoundFight() {
        int roundNumber = 1;
        int doesThePlayerStarts =0;

        while (this.currentRoundNumber<=this.mainRoundsNumber && this.player.getHealthPointsWithAddon()>0) {
            this.enemy = characterService.getRandomEnemyAndRemoveFromEnemiesList(enemiesList);

            if (this.enemy.isCanUseAddons()) {
                this.enemy.setGenericAddon1(addonsService.getRandomAddon(addonsList,false));
            }

            System.out.print("Przeciwnik numer " + this.currentRoundNumber + " to " + characterService.displayEnemyDetails(this.enemy,true) + ". ");

            doesThePlayerStarts = isThePlayerFirst();
            if (doesThePlayerStarts == 1) {
                System.out.println("W tej rundzie jako pierwszy atak wykona " + player.getPlayerName().toLowerCase() + ". ");
            } else {
                System.out.println("W tej rundzie jako pierwszy atak wykona " + enemy.getEnemyName().toLowerCase() + ". ");
            }

            while (player.getHealthPointsWithAddon() > 0 && enemy.getHealthPointsWithAddon() > 0) {
                if (doesThePlayerStarts == 1) {
                    player.attack(enemy);
                    if (enemy.getHealthPointsWithAddon() > 0) {
                        enemy.attack(player);
                    }
                } else {
                    enemy.attack(player);
                    if (player.getHealthPointsWithAddon() > 0) {
                        player.attack(enemy);
                    }
                }
                ++roundNumber;
            }
            System.out.println("Walka trwała rund: " + roundNumber + ". Pozostałe punkty życia po walce: " +
                    player.getPlayerName() + "(" + player.getHealthPointsWithAddon() + "), " + enemy.getEnemyName() + "(" + enemy.getHealthPointsWithAddon() + ")");

            addonsService.stealAddonFromEnemy(player,enemy);
            ++this.currentRoundNumber;
            System.out.println("----------------------");
        }
        System.out.print("Koniec gry! ");
        if (player.getHealthPointsWithAddon()>0) {
            System.out.println("Wygrywasz");
        } else {
            System.out.println("Przegrywasz");
        }
    }



//
//        player.stealAddonFromEnemy(enemy);


    private int isThePlayerFirst() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(2);
    }

    public int getMainRoundsNumber() {
        return mainRoundsNumber;
    }



    public GenericPlayer getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
