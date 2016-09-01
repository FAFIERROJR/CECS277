/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Entity.java
   Description: Basic parent class for trainers and pokemon alike
*/

public abstract class Entity{
    private String name;
    private int hp;
    private int maxHp;

    /* Entity()
       Basic constructor
       Sets name and hp to provided values
    */
    public Entity(String name, int hp){
        this.name = name;
        this.hp = hp;
        maxHp = hp;
    }
    

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    /* loseHp()
       handles hit point loss due to hit
    */
    public int loseHp(int hit){
        hp = hp - hit;
        if(hp < 0){
            hp = 0;
        }
        return hp;
    }

    /* gainHp()
       handles hit point goint due to heal
    */
    public int gainHp(int heal){
        hp = hp + heal;
        if(hp > maxHp){
            hp = maxHp;
        }
        return hp;
    }
    
    /* incMaxHp()
     * increases maximum hit points
     */
    public void incMaxHp(){
        maxHp += 50;
    }
}
