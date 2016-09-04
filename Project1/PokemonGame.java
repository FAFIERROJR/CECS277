import java.lang.Math;

public class PokemonGame{
    public static void main(String[] args){
        int startPoke;
        Player player = new Player("Ash", 80);

        System.out.println("Hey Ash. Choose a pokemon");
        pokeMenu();
        startPoke = CheckInput.checkInt();
        player.addPokemon(PokemonMaker.makeStartPokemon(startPoke));

        
        while(true){
            int randomScenario = (int) Math.round(Math.random() * 5);
            player.gainHp(10);
            switch(randomScenario){
                case 0:
                    Opponent opponent = OpponentMaker.makeRandomOpponent();
                    opponent.attackSpeech();
                    player.attackSpeech();
                    pvpBattle(player, opponent);
                    break;
                case 1:
                    Pokemon wildPokemon = PokemonMaker.makeWildPokemon();
                    pveBattle(player, wildPokemon);
                    break;
                case 3:
                    pokeCenter(player);
                    break;
                case 4:
                    PokemonBattles.angryPokemon(player);
                    break;
                case 5:
                    PokemonBattles.angryTrainer(player);
                    break;
            }
        }
    }

    private static void pvpBattle(Player player, Opponent opp){
        boolean run = false;
        while(!run){
            pvpStatus(player, opp);
            displayMainBattleMenu();
            int mainChoice = CheckInput.checkInt();

            switch(mainChoice){
                case 1:
                    PokemonBattles.opponentBattle(player, opp);
                    break;
                case 2:
                    player.usePotion();
                    break;
                case 3:
                    switchPokemon(player);
                    break;
                case 4:
                    run = true;
                    break;
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                    shop(player,item);
                    break;
                case 6:
                    System.out.println("That pokemon belongs to " + opp.getName());
                    break;
                case 7:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    break;
            }

            if(player.getCurrentPokemon().getHp() <= 0){
                if(player.getNextCurPokemon() == -1){
                    opp.winSpeech();
                    player.lossSpeech();
                    System.out.println("All of your pokemon have fainted. Game Over. Thanks for Playing!\n");
                    System.exit(0);
                }
                chooseNewPokemon(player);
            }
            if(opp.getCurrentPokemon().getHp() <= 0){
                if(opp.getNextCurPokemon() ==-1){
                    pvpWin(player, opp);
                    run = true;
                }
                else{
                    opp.setCurrentPokemon(opp.getNextCurPokemon());
                }
            }
        }
    }

    private static void pveBattle(Player player, Pokemon opp){
        boolean run = false;
        while(!run){
            pveStatus(player, opp);
            displayMainBattleMenu();
            int mainChoice = CheckInput.checkInt();

            switch(mainChoice){
                case 1:
                    PokemonBattles.wildPokemonBattle(player, opp);
                    break;
                case 2:
                    player.usePotion();
                    break;
                case 3:
                    switchPokemon(player);
                    break;
                case 4:
                    run = true;
                    break;
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                    shop(player,item);
                    break;      
                case 6:
                    if(catchPokemon(player,opp)){
                        System.out.println("You've caught a " + opp.getName() + "!");
                        run = true;
                    }
                    else{
                        System.out.println("It just escaped capture!");
                    }
                    break;
                case 7:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    break;
            }

            if(player.getCurrentPokemon().getHp() <= 0){
                if(player.getNextCurPokemon() == -1){
                    System.out.println("All of your pokemon have fainted. Game Over. Thanks for Playing!\n");
                    System.exit(0);
                }
                chooseNewPokemon(player);
            }
            if(opp.getHp() <= 0){
                pveWin(player, opp);
                run = true;
            }
        }
        
    }
    
    private static void pvpStatus(Player player, Opponent opp){
        displayItems(player);
        player.displayCurrentPokemon();
        opp.displayCurrentPokemon();
    }

    
    private static void pveStatus(Player player, Pokemon opp){
        displayItems(player);
        player.displayCurrentPokemon();
        System.out.println(opp.getName() + " LVL: " + opp.getLevel() + " HP: " + opp.getHp());
    }

    private static void displayMainBattleMenu(){
        System.out.println("\t1. Fight");
        System.out.println("\t2. Heal" );
        System.out.println("\t3. Switch");
        System.out.println("\t4. Run");
        System.out.println("\t5. Shop");
        System.out.println("\t6. Catch");
        System.out.println("\t7. Exit");
    }


    private static void pokeMenu(){
        System.out.println("\t1. Charmander");
        System.out.println("\t2. Squirtle");
        System.out.println("\t3. Bulbasaur");
        System.out.println("\t4. Pikachu");
    }


    private static void displayItems(Player player){
        System.out.println("\nPOTIONS: " + player.getNumPotionsLeft() + " POKEBALLS: " + player.getNumPokeballsLeft());
    }

    private static void chooseNewPokemon(Player player){
        do{
            System.out.println("Choose a Pokemon");
            player.listPokemon();
            int choice = CheckInput.checkInt();
            player.setCurrentPokemon(choice);
            if(player.getCurrentPokemon().getHp() <= 0){
                System.out.println("That pokemon is unconscious!");
            }
        }while(player.getCurrentPokemon().getHp() <= 0);
    }

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

    private static void pveWin(Player player, Pokemon opp){
        int xpGain = 100 + (int)(50 * Math.random());
        System.out.format("%s fainted. You win. %s gained %d EXP\n", opp.getName(),
        player.getCurrentPokemon().getName(), xpGain);
        player.getCurrentPokemon().gainExp(xpGain);
    }

    

    private static void displayShopMenu(){
        System.out.println("1. Potion\t250 munny\n2. Pokeball\t 100 munny");
    }
    
    private static void shop(Player player, int item){
        if (item == 1){
            player.buyPotion();
            player.spendMoney(250);
        }
        else{
            player.buyPokeball();
            player.spendMoney(100);
        }
    }

    private static boolean catchPokemon(Player player, Pokemon wildPoke){
        double chanceToCatch;
    
        chanceToCatch = Math.random() + (1/wildPoke.getHp());
    
        if(chanceToCatch >= 0.5){
            player.addPokemon(wildPoke);
            return true;
        }
        else return false;
    }

    private static void switchPokemon(Player player){
        System.out.println("Choose a pokemon");
        int choice;

        player.listPokemon();
        choice = CheckInput.checkInt();
        
        try{
            player.setCurrentPokemon(choice - 1);
        }
        catch(Exception e){
            System.out.println("That's not an option.");
        }
        finally{
            System.out.println("Reverting to first pokemon...");
            player.setCurrentPokemon(0);
        }
    }   

    private static void pokeCenter(Player player){
        int choice = 0;

        System.out.println("You've arrived at a PokeCenter.\n1. Heal Pokemon\n2. Leave");

        choice = CheckInput.checkInt();
         
        if (choice == 1){
            player.healAllPokemon();
            System.out.println("...\nYour pokemon are healed");
        }
    }
    
}
