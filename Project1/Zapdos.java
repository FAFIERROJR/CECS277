/**
 * Zapdos class
 * simulates a Zapdos Pokemon
 *
 * @author  Francisco Fierro
 *
 */
public class Zapdos extends Pokemon implements Electric{
    /**
     * Zapdos()
     * simple constructor for Zapdos
     *
     */
    public Zapdos(){
        super("Zapdos", 1);
    }
    
    /**
     * getType()
     * returns Pokemon type
     *
     * @return  the Pokemon's type
     */
    @Override
    public int getType(){
        return type;
    }

    /**
     * displaySpecialMenu()
     * diplays special attack menu
     *
     */
    @Override
    public void displaySpecialMenu(){
        System.out.println(typeMenu);
    }

    /**
     * specialFight()
     * handles the determination and execution of
     * an attack move; prints Pokemon-like attack dialog
     *
     * @param move  represents attack chosen
     * @return      the hit value
     *
     */
    @Override
    public int specialFight(int move){
        /** switch case to handle chosen basic attack */
        int hit = 0;
       switch(move){
            case 1:
                hit = thunderShock();
                break;
            case 2:
                hit = thunderbolt();
                break;
            case 3:
                hit = thunderPunch();
                break;
        }
        return hit;
    }

    /**
     * thunderShock()
     * performs Thunder Shock, displays, and returns hit value
     *
     *
     * @return     this attack's hit value
     *
     */
    public int thunderShock(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunder Shock", getName());
        return hit;
    }

    /**
     * thunderbolt()
     * performs Thunderbolt, displays, and returns hit value
     *
     * @return     this attack's hit value
     *
     */
    public int thunderbolt(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunderbolt", getName());
        return hit;
    }

    /**
     * thunderPunch();
     * performs Thunder Punch, displays, and returns hit value
     *
     * @return     this attack's hit value
     *
     */
    public int thunderPunch(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Thunder Punch", getName());
        return hit;
    }
}
