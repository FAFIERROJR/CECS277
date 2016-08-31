import java.lang.Math;

public class Opponent extends Trainer{
    private int type;

    public Opponent(String name, int hp, int type){
        super(name, hp);
        this.type = type;
    }

    public int getOpptype(){
        return type;
    }

    public void attackSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": You're going to lose");
            case 1:
                System.out.println(getName() + ": I'm not going easy on you!" );
            case 2:
                System.out.println(getName() + "You can't stop Team Rocket!");
            case 3:
                System.out.println(getName() + "I think I'm winning");
            case 4:
                System.out.println(getName() + ": My " + getCurrentPokemon() + " is strong!");
            default 5:
                System.out.println(getName() + ": My turn!");
            break;
    }

    public void winSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": Grass type pokemon are best");
            case 1:
                System.out.println(getName() + ": Better luck next time!" );
            case 2:
                System.out.println(getName() + "That'll teach you");
            case 3:
                System.out.println(getName() + "That was easy");
            case 4:
                System.out.println(getName() + "You're pokemon are weak");
            default 5:
                System.out.println(getName() + ": My turn!");
            break;
    }

    public void lossSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": Well, you can't win them all");
            case 1:
                System.out.println(getName() + ": Good job!" );
            case 2:
                System.out.println(getName() + "You may have won this time. Buy you can't beat us all");
            case 3:
                System.out.println(getName() + "Don't know where I wrong there...");
            case 4:
                System.out.println(getName() + "I'm too easy on my pokemon");
            default 5:
                System.out.println(getName() + ": My turn!");
            break;
    }

    public int chooseStyle(){
        return (int)Math.round(Math.random() + 1);
    }

    public int chooseMove(int style){
        return (int)Math.round(Math.random()* 2 + 1);
    }

}
