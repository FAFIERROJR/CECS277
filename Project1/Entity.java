/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Entity.java
   Description: Basic parent class for trainers and pokemon alike
*/

public class Entity{
    private String name;
    private int hp;

    /* Entity()
       Basic constructor
       Sets name and hp to provided values
    */
    public Entity(String name, int hp){
        this.name = name;
       this.hp = hp;
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
        return hp;
    }

    /* gainHp()
       handles hit point goint due to heal
    */
    public int gainHp(int heal){
        hp = hp + heal;
        return hp;
    }
}
