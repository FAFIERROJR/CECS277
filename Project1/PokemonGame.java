import java.lang.Math;

public class PokemonGame{
    public static void main(String[] args){
        int pokeChoice;
        Pokemon pokemon;
        Trainer player = new Trainer("Ash Ketchum", 30);

        System.out.println("Hey Ash. Choose a pokemon");
        pokeMenu();
        pokeChoice = CheckInput.checkInt();
        if (pokeChoice == 1){
            pokemon = new Pikachu();
        }
        else{
            pokemon = new Charmander();
        }
            
        player.setPokemon(pokemon);

        
        while(true){
            Pokemon opp = loadScenario();
            boolean run = false;

            while(!run){
                status(player, opp);
                mainMenu();
                int mainChoice = CheckInput.checkInt();

                switch(mainChoice){
                    case 1:
                        battleRound(player, opp);
                        break;
                    case 2:
                        player.getPokemon().gainHp(20);
                        System.out.format("%s gained 20 HP\n", player.getPokemon().getName());
                        oppAttack(player, opp);
                        break;
                    case 3:
                        run = true;
                        break;
                    case 4:
                        System.out.println("Thanks for playing!");
                        System.exit(0);
                        break;
                }

                if(player.getPokemon().getHp() <= 0){
                    System.out.format("%s fainted. Game Over. Thanks for Playing!\n", player.getPokemon().getName());
                    System.exit(0);
                }
                if(opp.getHp() <= 0){
                    int xpGain = 100 + (int)(50 * Math.random());
                    System.out.format("%s fainted. You win. %s gained %d EXP\n", opp.getName(),
                        player.getPokemon().getName(), xpGain);
                    player.getPokemon().gainExp(xpGain);
                    run = true;
                }
            }
        }
    }

    public static void battleRound(Trainer player, Pokemon opp){
        int fightChoice;

        fightMenu();
        fightChoice = CheckInput.checkInt();
        
        int attackChoice= 0;
        int playerIsHit = 0;
        int oppIsHit = 0;
        
        switch(fightChoice){
            case 1:          
                player.getPokemon().displayBasicMenu();
                attackChoice = CheckInput.checkInt();
                oppIsHit = player.getPokemon().basicFight(attackChoice);
                break;
            case 2:
                player.getPokemon().displaySpecialMenu();
                attackChoice = CheckInput.checkInt();
                oppIsHit = player.getPokemon().specialFight(attackChoice);
                break;
        }
        opp.loseHp(oppIsHit);
        
        System.out.format("\n%s was hit for %d points\n",
            opp.getName(), oppIsHit);
        
        oppAttack(player, opp);
    }

   public static void oppAttack(Trainer player, Pokemon opp){
        int oppMoves[] = oppMove();
        int playerIsHit;

        if(oppMoves[0] ==1){
            playerIsHit = opp.basicFight(oppMoves[1]);
            player.getPokemon().loseHp(playerIsHit);
        }
        else{
            playerIsHit = opp.specialFight(oppMoves[0]);
            player.getPokemon().loseHp(playerIsHit); 
        }  
        System.out.format("\n%s was hit for %d points\n\n",
            player.getPokemon().getName(), playerIsHit);
    }

    public static Pokemon loadScenario(){
        Scenario scene = new Scenario();
        int randomSceneInt = (int)Math.round(Math.random() * (scene.length() -1));
        int randomLevel = (int)Math.round(Math.random() + 1);        
        
        System.out.println(scene.getScenario(randomSceneInt));
        Pokemon pokemon = scene.getPokemon(randomSceneInt);
        pokemon.setLevel(randomLevel);

        return pokemon;
    }
        
    public static void status(Trainer player, Pokemon opp){
        System.out.format("%s LVL: %d HP: %d\n", player.getPokemon().getName(),
            player.getPokemon().getLevel(), player.getPokemon().getHp());
        System.out.format("%s LVL: %d HP: %d\n", opp.getName(),
            opp.getLevel(), opp.getHp());
    }

    public static void mainMenu(){
        System.out.println("\t1. Fight");
        System.out.println("\t2. Heal" );
        System.out.println("\t3. Run");
        System.out.println("\t4. Exit");
    }

    public static void fightMenu(){
        System.out.println("\t1. Basic");
        System.out.println("\t2. Special");
        }

    public static void pokeMenu(){
        System.out.println("\t1. Pikachu");
        System.out.println("\t2. Charmander");
    }

    public static int[] oppMove(){
        int[] moves = new int[2];
        moves[0] = (int)Math.round(Math.random() + 1);
        moves[1] = (int)Math.round(Math.random() * 2 + 1);
        return moves;
    }

}
