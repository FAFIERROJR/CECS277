/**
 * Opponent class
 * defines opponent Pokemon trainer
 *
 * @author Francisco Fierro
 *
 */
import java.lang.Math;

public class Opponent extends Trainer{

    private String atkSpeech;
	
	private String lossSpeech;
	
	private String winSpeech;

    /**
     * Opponent()
     * Basic constructor for Opponent
     *
     * @param name  Name of opponent
     * @param type  unique to particular opponent
     *
     */
    public Opponent(String n, int h, String a, String l, String w){
        super(n, h);
        atkSpeech = a;
        lossSpeech = l;
        winSpeech = w;
    }

    /**
     * attackSpeech()
     * returns speech at start of battle
     *
     */
    public String attackSpeech(){
        return atkSpeech;
    }

    /**
     * winSpeech()
     * returns speech given at Opponent win
     *
     */
    public String winSpeech(){
        return winSpeech;
    }


    /**
     * lossSpeech()
     * returns speech if Opponent loses
     *
     */
    public String lossSpeech(){
        return lossSpeech;
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
