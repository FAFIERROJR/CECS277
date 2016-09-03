import java.lang.Math;

public class PokemonGame{
    public static void main(String[] args){
        int startPoke;
        Player player = new Player("Ash", 30);

        System.out.println("Hey Ash. Choose a pokemon");
        pokeMenu();
        startPoke = CheckInput.checkInt();
        player.addPokemon(PokemonMaker.makeStartPokemon(startPoke));

        
        while(true){
            int randomScenario = (int) Math.round(Math.random());
            switch(randomScenario){
                case 0:
                    Opponent opponent = OpponentMaker.makeRandomOpponent();
                    pvpBattle(player, opponent);
                    break;
                case 1:
                    Pokemon wildPokemon = PokemonMaker.makeWildPokemon();
                    pveBattle(player, wildPokemon);
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
                case 4:
                    run = true;
                    break;
                case 5:
                    displayShopMenu();
                    int item = CheckInput.checkInt();
                case 6:
                    System.out.println("That pokemon belongs to " + opp.getName());
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
                case 4:
                    run = true;
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

    public static void chooseNewPokemon(Player player){
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

    public static void pvpWin(Player player, Opponent opp){
        int xpGain = 100 + (int)(50 * Math.random());
        int money = (100 + (int)(50 * Math.random() * 2)) * -1;
        System.out.format("%s fainted. You win %d Money. %s gained %d EXP\n", opp.getCurrentPokemon().getName(),
        money * -1, player.getCurrentPokemon().getName(), xpGain);
        player.getCurrentPokemon().gainExp(xpGain);
        player.spendMoney(money);
    }

    public static void pveWin(Player player, Pokemon opp){
        int xpGain = 100 + (int)(50 * Math.random());
        System.out.format("%s fainted. You win. %s gained %d EXP\n", opp.getName(),
        player.getCurrentPokemon().getName(), xpGain);
        player.getCurrentPokemon().gainExp(xpGain);
    }

    

    public static void displayShopMenu(){
        System.out.println("1. Potion\t250 munny\n2. Pokeball\t 100 munny");
    }
    
    public void shop(Player player, int item){
        if (item == 1){
            player.buyPotion();
            player.spendMoney(250);
        }
        else{
            player.buyPokeball();
            player.spendMoney(100);
        }
    }

    public static boolean catchPokemon(Player player, Pokemon wildPoke){
        double chanceToCatch;
    
        chanceToCatch = Math.random() + (1/wildPoke.getHp());
    
        if(chanceToCatch >= 0.5){
            player.addPokemon(wildPoke);
            return true;
        }
        else return false;
    }

    public static void switchPokemon(Player player){
        System.out.println("Choose a pokemon");
        int choice;

        player.listPokemon();
        choice = CheckInput.checkInt();
        
        player.setCurrentPokemon(choice);
    }
    
}
