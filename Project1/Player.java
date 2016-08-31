public class Player extends Trainer{
    private int potions;
    private int pokeballs;
    private int money;

    public Player(String name, int hp){
        super(name, hp);
    }

    public void usePotion(){
        getCurrentPokemon().gainHp(50);
    }
    
    public int getNumPotionsLeft(){
        return potions;
    }

    public void buyPotion(){
        potions++;
    }

    public void usePokeball(){
        pokeballs--;
    }

    public int getNumPokeballsLeft(){
        return pokeballs;
    }

    public void buyPokeball(){
        pokeballs++;
    }

    public void spendMoney(int price){
        money -= price;
    }
}
