import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int life = 1;
    private int damage = 1;
    
    public Bullet() {
    }
    
    public void act() 
    {
        if (life <= 0) {
            getWorld().removeObject(this);
        }
        else {
            turnTowards(getX(), 0);
            move(9); 
        }
        
        if (getY() <= 3) {
           Space space = (Space)getWorld();
           space.updateScore(-2);
           space.removeObject(this); 
        }
    }    
}