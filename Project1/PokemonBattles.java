/**
 * PokemonBattles class
 * contains static methods to be used by main
 * to perform battle rounds
 * 
 * @author  Francisco Fierro
 *
 */
public class PokemonBattles{
    /** fightTable is a 4x4 array to determine damage type bonuses */
    private final static double [][] fightTable = {{.5,.5,2,1},{2,.5,.5,1},{.5,2,.5,1},{1,2,.5,.5}};

    /** 
     * trainerBattle()
     * performs a single turn of battle
     * 
     * @param attacker  trainer whose turn it is for attack
     * @param defener   trainer whose pokemon is being attacked
     *
     */
    private static void trainerBattle(Trainer attacker, Trainer defender){
        int hit = attacker.battle();
        hit = (int)(hit * fightTable[defender.getCurrentPokemon().getType()][attacker.getCurrentPokemon().getType()]);
        System.out.println("\n" + defender.getCurrentPokemon().getName() + " was hit for " + hit + " points");
        defender.getCurrentPokemon().loseHp(hit);
    }

    /**
     * opponentBattle()
     * performs a round of battle using trainerBattle()
     *
     * @param player    the player character
     * @param player    the CPU opponent
     *
     */
    public static void opponentBattle(Player player, Opponent opponent){
        trainerBattle(player, opponent);
        trainerBattle(opponent, player);
    }

    /**
     * wildPokemonBattle()
     * performs a round of battle agains wild pokemon
     * using wilPokeAttack to determine wild pokemon's attack
     *
     * @param player    the player character
     * @param poke      the wild pokemon
     *
     */
    public static void wildPokemonBattle(Player player, Pokemon poke){
        int playerHit = player.battle();
        playerHit = (int)(playerHit * fightTable[player.getCurrentPokemon().getType()][poke.getType()]);
        poke.loseHp(playerHit);
        System.out.println("\n" + poke.getName() + " was hit for " + playerHit + " points");

        wildPokeAttack(player, poke);
    }

    /**
     * angryPokemon()
     * performs scene in which player is directly hurt
     * by a random wild pokemon
     *
     * @param trainer   the player character
     *
     */
    public static void angryPokemon(Trainer trainer){
        Pokemon angryPoke = PokemonMaker.makeWildPokemon();
        /** stall so that player may read */
        int stall;
        
        System.out.println("An angry " + angryPoke.getName() + " has approached!\nIt's coming straight for you!");
        angryPokeAttack(trainer, angryPoke);

        System.out.println("Enter any integer to continue");
        stall = CheckInput.checkInt();
    }

    /**
     * angryTrainer()
     * performs scene in which player is directly hurt
     * by a random angry trainer
     *
     * @param trainer   the player character
     */
    public static void angryTrainer(Trainer trainer){
        int random = (int)(Math.random() * 2 + 1);
        int randomDamage =(int)(Math.random() * 10  + 1);
        /** stall so that player may read */
        int stall;

        switch(random){
            case 1:
                System.out.println("\nIt's Misty!\nMISTY: Where's my bike!\nMisty used Dropkick");
                break;
            case 2:
                System.out.println("\nIt's Gary!\nGARY: Move over, punk!\nGary used Shove");
                break;
            case 3:
                System.out.println("\nIt's Officer Jenny\nJENNY: Stop right there!\nJenny used Tase\nJENNY:Oh, it's you, Ash! Sorry!");
                break;
        }
        System.out.println("You were hit for " + randomDamage + " points");
        trainer.loseHp(randomDamage);

        System.out.println("Enter any integer to continue");
        stall = CheckInput.checkInt();
    }     

    /**
     * wildPokeAttack()
     * helper function for wildPokemonBattle()
     * determines and deals attack by wild pokemon
     *
     * @param player    the player character
     * @param poke      the wild pokemon
     */
    private static void wildPokeAttack(Player player, Pokemon poke){
        int pokeHit;
        int random1;
        int random2;
        random1 = (int) Math.round(Math.random() + 1);
        random2 = (int) Math.round(Math.random() * 2 + 1);
        
        pokeHit = poke.fight(random1, random2);
        pokeHit = (int)(pokeHit * fightTable[poke.getType()][player.getCurrentPokemon().getType()]);
        System.out.println("\n" + player.getCurrentPokemon().getName() + " was hit for " + pokeHit + " points");
        player.getCurrentPokemon().loseHp(pokeHit);
    }

    /**
     * angryPokeAttack()
     * helper function for angryPokemon()
     * determines and deals attack by angry pokemon
     *
     * @param trainer   the player character
     * @param poke      the angry pokemon
     *
     */
    private static void angryPokeAttack(Trainer trainer, Pokemon poke){
        int pokeHit;
        int random1;
        int random2;
        random1 = (int) Math.round(Math.random() + 1);
        random2 = (int) Math.round(Math.random() * 2 + 1);
        
        pokeHit = poke.fight(random1, random2);
        System.out.println("\n" + trainer.getName() + " was hit for " + pokeHit + " points");
        trainer.loseHp(pokeHit);
    }
        
}


