public class PokemonBattles{
    private final static double [][] fightTable = {{.5,.5,2,1},{2,.5,.5,1},{.5,2,.5,1},{1,2,.5,.5}};
    private static void trainerBattle(Trainer attacker, Trainer defender){
        int hit = attacker.battle();
        hit = (int)(hit * fightTable[attacker.getCurrentPokemon().getType()][defender.getCurrentPokemon().getType()]);
        System.out.println("\n" + defender.getCurrentPokemon().getName() + " was hit for " + hit + " points");
        defender.getCurrentPokemon().loseHp(hit);
    }

    public static void opponentBattle(Player player, Opponent opponent){
        trainerBattle(player, opponent);
        trainerBattle(opponent, player);
    }

    public static void wildPokemonBattle(Player player, Pokemon poke){
        int playerHit = player.battle();
        playerHit = (int)(playerHit * fightTable[player.getCurrentPokemon().getType()][poke.getType()]);
        poke.loseHp(playerHit);
        System.out.println("\n" + poke.getName() + " was hit for " + playerHit + " points");

        wildPokeAttack(player, poke);
    }

    public static void angryPokemon(Trainer trainer){
        Pokemon angryPoke = PokemonMaker.makeWildPokemon();
        
        System.out.println("An angry " + angryPoke.getName() + " has approached!\nIt's coming straight for you!");
        angryPokeAttack(trainer, angryPoke);
    }

    public static void angryTrainer(Trainer trainer){
        int random = (int)(Math.random() * 2 + 1);
        int randomDamage =(int)(Math.random() * 10  + 1);
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
    }     

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


