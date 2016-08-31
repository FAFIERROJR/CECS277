public class Opponent extends Trainer{
    private int type;

    public Opponent(String name, int hp, int type){
        super(name, hp);
        this.type = type;
    }

    public int getOpptype(){
        return type;
    }

}
