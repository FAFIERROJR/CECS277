public class Bulbasaur extends Pokemon implements Grass{
    public Bulbasaur(){
        super("Bulbasaur", 1);
    }

     @Override
    public int getType(){
        return type;
    }

    @Override
    public void displaySpecialMenu(){
        System.out.println(typeMenu);
    }

    /* specialFight()
       handles the determination and execution of
       an attack move; prints Pokemon-like attack dialog
    */

    @Override
    public int specialFight(int move){
        //switch case to handle chosen basic attack
        int hit = 0;
       switch(move){
            case 1:
                hit = vineWhip();
                break;
            case 2:
                hit = razorLeaf();
                break;
            case 3:
                hit = solarBeam();
                break;
        }
        return hit;
    }

    /* The functions below are the special attacks unique to each Pokemon
       Each attack does random damage which is multiplied
       by the pokemon's level
    */
    public int vineWhip(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Vine Whip", getName());
        return hit;
    }

    public int razorLeaf(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Razor Leaf", getName());
        return hit;
    }

    public int solarBeam(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Solar Beam", getName());
        return hit;
    }
}
