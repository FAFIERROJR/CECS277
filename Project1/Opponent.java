/**
 * Opponent class
 * defines opponent Pokemon trainer
 *
 * @author Francisco Fierro
 *
 */
import java.lang.Math;

public class Opponent extends Trainer{
    /** int type determines particular opponent */
    private int type;

    /**
     * Opponent()
     * Basic constructor for Opponent
     *
     * @param name  Name of opponent
     * @param type  unique to particular opponent
     *
     */
    public Opponent(String name, int hp, int type){
        super(name, hp);
        this.type = type;
    }

    /**
     * getOpptype()
     *
     * @return  opponent's type
     */
    public int getOpptype(){
        return type;
    }


    /**
     * attackSpeech()
     * prints speech at start of battle
     *
     */
    public void attackSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": You're going to lose");
                break;
            case 1:
                System.out.println(getName() + ": I'm not going easy on you!" );
                break;
            case 2:
                System.out.println(getName() + ": You can't stop Team Rocket!");
                break;
            case 3:
                System.out.println(getName() + ": Do you have any LVL 99 Magikarps?");
                break;
            case 4:
                System.out.println(getName() + ": My " + getCurrentPokemon().getName() + " is strong!");
                break;
            default:
                System.out.println(getName() + ": Do you think you can take me on?!");
                break;
        }
    }

    /**
     * winSpeech()
     * prints speech given at Opponent win
     *
     */
    public void winSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": Grass type pokemon are best");
                break;
            case 1:
                System.out.println(getName() + ": Better luck next time!" );
                break;
            case 2:
                System.out.println(getName() + ": That'll teach you");
                break;
            case 3:
                System.out.println(getName() + ": That was easy");
                break;
            case 4:
                System.out.println(getName() + ": You're pokemon are weak");
                break;
            default:
                System.out.println(getName() + ": My turn!");
                break;
        }
    }


    /**
     * lossSpeech()
     * prints speech if Opponent loses
     *
     */
    public void lossSpeech(){
        switch(type){
            case 0:
                System.out.println(getName() + ": Well, you can't win them all");
                break;
            case 1:
                System.out.println(getName() + ": Good job!" );
                break;
            case 2:
                System.out.println(getName() + ": You may have won this time. Buy you can't beat us all");
                break;
            case 3:
                System.out.println(getName() + ": Don't know where I wrong there...");
                break;
            case 4:
                System.out.println(getName() + ": I'm too easy on my pokemon");
                break;
            default:
                System.out.println(getName() + ": Yes, yes you could...");
                break;
        }
    }


    /**
     * chooseStyle()
     * randomly chooses between 1-0 and returns it
     * which represents choosing between basic and special
     * attack styles
     *
     * @return  returns integer representing chosen style
     *
     */
    public int chooseStyle(){
        return (int)Math.round(Math.random() + 1);
    }

    /**
     * chooseMove()
     * randomly chooses between 1-3
     * which represents choosing a particular attack
     * style need not be taken into account as menus
     * need not be printed
     *
     * @param style     the randomly chosen style
     * @return          the randomly chosen move 
     *
     */
    public int chooseMove(int style){
        return (int)Math.round(Math.random()* 2 + 1);
    }

}
