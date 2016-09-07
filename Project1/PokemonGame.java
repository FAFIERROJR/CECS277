/**
 * PokemonGame class
 * This is the main file
 * handles all of the outermost
 * mechanics of the games
 *
 * @author Francisco Fierro
 *
 */

import java.lang.Math;

public class PokemonGame{
    public static void main(String[] args){
        int startPoke;
        Player player = new Player("Ash", 80);

        do{
            /* choosing a starter pokemon */
            System.out.println("Hey Ash. Choose a pokemon");
            pokeMenu();
            startPoke = CheckInput.checkInt();
            if(startPoke < 1 || startPoke > 4){
                System.out.println("That's not an option. Try again.");
            }
        }while(startPoke < 1 || startPoke > 4);
        player.addPokemon(PokemonMaker.makeStartPokemon(startPoke));

        /* outer most game loop */
        while(true){
            int randomScenario = (int) Math.round(Math.random() * 5);
            int mainChoice;
            player.gainHp(10);

            do{
                /* Main menu */
                displayMainMenu();
                mainChoice = CheckInput.checkInt();
                if(mainChoice < 1 || mainChoice > 6){
                    System.out.println("That's not an option. Try again.");
                }
            }while(mainChoice < 1 || mainChoice > 6);
            switch(mainChoice){
                case 1:
                switch(randomScenario){
                    /* player-opponent battle */
                    case 0:
                        Opponent opponent = OpponentMaker.makeRandomOpponent();
                        opponent.attackSpeech();
                        player.attackSpeech();
                        pvpBattle(player, opponent);
                        break;
                    /* player-wild battle */
                    case 1:
                        Pokemon wildPokemon = PokemonMaker.makeWildPokemon();
                        pveBattle(player, wildPokemon);
                        break;
                    /* pokecenter */
                    case 3:
                        pokeCenter(player);
                        break;
                    /* angry Pokemon scene */
                    case 4:
                        PokemonBattles.angryPokemon(player);
                        if(player.getHp() == 0){
                            playerDeath();
                            System.exit(0);
                        }
                        break;
                    /* angry Trainer scene */
                    case 5:
                        PokemonBattles.angryTrainer(player);
                        if(player.getHp() == 0){
                            playerDeath();
                            System.exit(0);
                        }
                        break;
                }
                break;
                /* heal */
                case 2:
                    player.usePotion();
                    break;
                /* switch Pokemon */
                case 3:
                    switchPokemon(player);
                    break;
                /* status */
                case 4:
                    player.listPokemon();
                    break;
                /* shop */
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                    shop(player,item);
                    break;
                /* quit */
                case 6:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    break;
            }
    }   }

    /**
     * pvpBattle()
     * handles an entire player v opponent battle
     *
     * @param player    the player character
     * @param opp       the cpu trainer
     *
     */
    private static void pvpBattle(Player player, Opponent opp){
        boolean run = false;
        int mainChoice;
        /* loop unti win, loss, run, or quit */
        while(!run){
            /* display pokemon statuses */
            pvpStatus(player, opp);
            displayMainBattleMenu();
            do{
                mainChoice = CheckInput.checkInt();
                if(mainChoice < 1 || mainChoice > 7){
                    System.out.println("That's not an option. Try again");
                }
            }while(mainChoice < 1 || mainChoice > 7);

            switch(mainChoice){
                /* fight */
                case 1:
                    PokemonBattles.opponentBattle(player, opp);
                    break;
                /* heal */
                case 2:
                    player.usePotion();
                    break;
                /* switch Pokemon */
                case 3:
                    switchPokemon(player);
                    break;
                /* run */
                case 4:
                    run = true;
                    break;
                /* shop */
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                    shop(player,item);
                    break;
                /* catch */
                case 6:
                    System.out.println("That pokemon belongs to " + opp.getName());
                    break;
                /* quit */
                case 7:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    break;
            }

            
            /* player loss */
            if(player.getCurrentPokemon().getHp() <= 0){
                if(player.getNextCurPokemon() == -1){
                    opp.winSpeech();
                    player.lossSpeech();
                    System.out.println("All of your pokemon have fainted. Game Over. Thanks for Playing!\n");
                    System.exit(0);
                }
                chooseNewPokemon(player);
            }
            /* player win */
            if(opp.getCurrentPokemon().getHp() <= 0){
                if(opp.getNextCurPokemon() ==-1){
                    pvpWin(player, opp);
                    run = true;
                }
                else{
                    System.out.println(opp.getCurrentPokemon().getName() + " fainted.");
                    opp.setCurrentPokemon(opp.getNextCurPokemon());
                    System.out.println(opp.getName() + " chooses " + opp.getCurrentPokemon().getName());
                }
            }
        }
    }

    /**
     * pveBattle()
     * handles an entire player v Wild Pokemon battle
     *
     * @param player    the player character
     * @param opp       the cpu Pokemon
     *
     */
    private static void pveBattle(Player player, Pokemon opp){
        boolean run = false;
        /* loop unti win, loss, run, or quit */
        while(!run){
            pveStatus(player, opp);
            displayMainBattleMenu();
            int mainChoice;
            do{
                mainChoice = CheckInput.checkInt();
                if(mainChoice < 1 || mainChoice > 7){
                    System.out.println("That's not an option. Try again");
                }
            }while(mainChoice < 1 || mainChoice > 7);

            switch(mainChoice){
                /* fight */
                case 1:
                    PokemonBattles.wildPokemonBattle(player, opp);
                    break;
                /* heal */
                case 2:
                    player.usePotion();
                    break;
                /* switch Pokemon */
                case 3:
                    switchPokemon(player);
                    break;
                /* run */
                case 4:
                    run = true;
                    break;
                /* shop */
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                    shop(player,item);
                    break;  
                /* catch */    
                case 6:
                    if(catchPokemon(player,opp)){
                        System.out.println("You've caught a " + opp.getName() + "!");
                        run = true;
                    }
                    else{
                        System.out.println("It just escaped capture!");
                    }
                    break;
                /* quit */
                case 7:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    break;
            }

            /* player loss */
            if(player.getCurrentPokemon().getHp() <= 0){
                if(player.getNextCurPokemon() == -1){
                    System.out.println("All of your pokemon have fainted. Game Over. Thanks for Playing!\n");
                    System.exit(0);
                }
                chooseNewPokemon(player);
            }
            /* player win */
            if(opp.getHp() <= 0){
                pveWin(player, opp);
                run = true;
            }
        }
        
    }

    /**
     * pvpStatus()
     * displays player and opponent Pokemon name,hp, level
     *
     * @param player    the player character
     * @param opp       the opponent character
     *
     */
    
    private static void pvpStatus(Player player, Opponent opp){
        displayItems(player);
        player.displayCurrentPokemon();
        opp.displayCurrentPokemon();
    }

    /**
     * pvpStatus()
     * displays player and wild Pokemon name,hp, level
     *
     * @param player    the player character
     * @param opp       the wild Pokemon
     *
     */
    
    private static void pveStatus(Player player, Pokemon opp){
        displayItems(player);
        player.displayCurrentPokemon();
        System.out.println(opp.getName() + " LVL: " + opp.getLevel() + " HP: " + opp.getHp());
    }

    /**
     * displayMainMenu()
     * prints Main Menu
     *
     */

    private static void displayMainMenu(){
        System.out.println("\n What now?");
        System.out.println("1. Travel");
        System.out.println("2. Heal" );
        System.out.println("3. Switch");
        System.out.println("4. Status");
        System.out.println("5. Shop");
        System.out.println("6. Exit");
    }

    /**
     * displayMainBattleMenu()
     * prints initial battle menu
     *
     */
    private static void displayMainBattleMenu(){
        System.out.println("1. Fight");
        System.out.println("2. Heal" );
        System.out.println("3. Switch");
        System.out.println("4. Run");
        System.out.println("5. Shop");
        System.out.println("6. Catch");
        System.out.println("7. Exit");
    }


    /**
     * pokeMenu()
     * prints Starting pokemon options
     *
     */
    private static void pokeMenu(){
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Bulbasaur");
        System.out.println("4. Pikachu");
    }


    /**
     * displayItems()
     * prints # of potions and pokeballs
     *
     */
    private static void displayItems(Player player){
        System.out.println("\nPOTIONS: " + player.getNumPotionsLeft() + " POKEBALLS: " + player.getNumPokeballsLeft());
    }

    /**
     * chooseNewPokemon()
     * handles listing, choosing, switching of Pokemon
     *
     * @param player    the player character
     *
     */
    private static void chooseNewPokemon(Player player){
        do{
            System.out.println("Choose a Pokemon");
            player.listPokemon();
            int choice = CheckInput.checkInt();
            player.setCurrentPokemon(choice - 1);
            if(player.getCurrentPokemon().getHp() <= 0){
                System.out.println("That pokemon is unconscious!");
            }
        }while(player.getCurrentPokemon().getHp() <= 0);
    }

    /**
     * pvpWin()
     * handles win event in a player v opponent battle
     *
     * @param player    the player character
     * @param opp       the cpu trainer
     *
     */
    private static void pvpWin(Player player, Opponent opp){
        int xpGain = 100 + (int)(50 * Math.random());
        int money = (100 + (int)(50 * Math.random() * 2)) * -1;

        player.winSpeech();
        opp.lossSpeech();
        System.out.format("%s fainted. You win %d Money. %s gained %d EXP\n", opp.getCurrentPokemon().getName(),
        money * -1, player.getCurrentPokemon().getName(), xpGain);
        player.getCurrentPokemon().gainExp(xpGain);
        player.spendMoney(money);
        
    }

    /**
     * pveWin()
     * handles win event in player v wild Pokemon battle
     *
     * @param player    the player character
     * @param opp       the wild Pokemon
     *
     */
    private static void pveWin(Player player, Pokemon opp){
        int xpGain = 100 + (int)(50 * Math.random());
        System.out.format("%s fainted. You win. %s gained %d EXP\n", opp.getName(),
        player.getCurrentPokemon().getName(), xpGain);
        player.getCurrentPokemon().gainExp(xpGain);
    }

    
    /**
     * displayShopMenu()
     * prints shop menu
     *
     */
    private static void displayShopMenu(){
        System.out.println("1. Potion\t250 munny\n2. Pokeball\t 100 munny");
        System.out.println("Enter any other integer to leave");
    }
    
    /**
     * shop()
     * handles buying of items
     *
     */
    private static void shop(Player player, int item){
       while(item == 1 || item == 2){  
            if (item == 1){
                player.buyPotion();
                player.spendMoney(250);
            }
            else if (item == 2){
                player.buyPokeball();
                player.spendMoney(100);
            }
            item = CheckInput.checkInt();
        }
    }

    /**
     * catchPokemon()
     * handles catching of wild pokemon
     *
     * @param player    the player character
     * @param wildPoke  the wild pokemon
     * @return          true if caught, false if not
     */
    private static boolean catchPokemon(Player player, Pokemon wildPoke){
        double chanceToCatch;
    
        /** increase in chanceToCatch based on Hp */
        chanceToCatch = Math.random() + (1/wildPoke.getHp());
    
        if(chanceToCatch >= 0.5){
            player.addPokemon(wildPoke);
            return true;
        }
        else return false;
    }


    /**
     * switchPokemon()
     * handles switching of Pokemon
     *
     * @param player    the player character
     *
     */    
    private static void switchPokemon(Player player){
        System.out.println("Choose a pokemon");
        int choice;

        player.listPokemon();
        choice = CheckInput.checkInt();
        
        player.setCurrentPokemon(choice - 1);
    }   

    /**
     * pokeCenter()
     * handles PokeCenter encounter
     *
     * @param player    the player character
     *
     */
    private static void pokeCenter(Player player){
        int choice = 0;

        System.out.println("You've arrived at a PokeCenter.\n1. Heal Pokemon\n2. Leave");
         
        do{
            choice = CheckInput.checkInt();
            if(choice < 1 || choice > 2){
                System.out.println("That's not an option. Try again");
            }
        }while(choice < 1 || choice > 2);
         
        if (choice == 1){
            player.healAllPokemon();
            System.out.println("...\nYour pokemon are healed");
        }
    }
     
    /**
     * playerDeath()
     * handles player death from angry trainer or pokemon attack
     *
     */
     private static void playerDeath(){
        System.out.println("Your HP has dropped to 0. Ash has fainted");
        System.out.println("Thanks for playing!");
     }
}
