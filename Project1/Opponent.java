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
        System.out.println(getName() ": My pokemon is stronger " + getCurrentPokemon());
    }

    public void winSpeech(){
        System.out.println(getName() ": Just as I thought");
    }

    public void lossSpeech(){
        System.out.println(getName() ": How did you..");
    }

    public int chooseStyle(){
        return (int)Math.round(Math.random() + 1);
    }

    public int chooseMove(int style){
        return (int)Math.round(Math.random()* 2 + 1);
    }

}
