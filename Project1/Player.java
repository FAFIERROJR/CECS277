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

    public void attackSpeech(){
        System.out.println("YOU: Get him " + getCurrentPokemon());
    }

    public void winSpeech(){
        System.out.println("YOU: I won!");
    }

    public void lossSpeech(){
        System.out.println("YOU: Oh no! I lost!");
    }

    public int chooseStyle(){
        System.out.println("\t1. Basic");
        System.out.println("\t2. Special");

        int style = CheckInput.checkInt();
        return style;
    }

    public int chooseMove(int style){
        int move;
        switch(style){
            case 1:          
                getCurrentPokemon().displayBasicMenu();
                break;
            case 2:
                getCurrentPokemon().displaySpecialMenu();
                break;
        }
        move = CheckInput.checkInt();
        return move;
    }
}
