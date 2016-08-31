public class Zapdos extends Pokemon implements Electric{
    public Zapdos(){
        super("Zapdos", 1);
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
                hit = thunderShock();
                System.out.format("%s used Thunder Shock", getName());
                break;
            case 2:
                hit = thunderbolt();
                System.out.format("%s used Thunder Bolt", getName());
                break;
            case 3:
                hit = thunderPunch();
                System.out.format("%s used Thunder Punch", getName());
                break;
        }
        return hit;
    }

    /* The functions below are the special attacks unique to each Pokemon
       Each attack does random damage which is multiplied
       by the pokemon's level
    */
    public int thunderShock(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunder Shock", getName());
        return hit;
    }

    public int thunderbolt(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunderbolt", getName());
        return hit;
    }

    public int thunderPunch(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunder Punch", getName());
        return hit;
    }
}
