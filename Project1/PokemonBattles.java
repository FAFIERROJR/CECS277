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

        int pokeHit;
        int random1;
        int random2;
        random1 = (int) Math.round(Math.random() * 2);
        random2 = (int) Math.round(Math.random() * 3);
        
        pokeHit = poke.fight(random1, random2);
        pokeHit = (int)(pokeHit * fightTable[poke.getType()][player.getCurrentPokemon().getType()]);
        System.out.println("\n" + player.getCurrentPokemon().getName() + " was hit for " + pokeHit + " points");
        player.getCurrentPokemon().loseHp(pokeHit);
    }
}
