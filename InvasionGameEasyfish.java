import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Easyfish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Easyfish extends Actor
{
    private int easyx;
    private int easydir;
    private int easyy;
    private int damageEasy;
    
    public Easyfish() {
        easyx = 1;
        easydir = 1;
        easyy = 5;
        damageEasy = 0;
    }
    
    public void act() 
    {
        Space space = (Space)getWorld();
        easyx = space.getSpeed();
        setLocation(getX() + easyx*easydir, easyy);
        
        if (getX() >= 880) {
            easydir = easydir * -1;
            turn(180);
            easyy = easyy + 60;
        }
        
        if (getX() <= 20) {
            easydir = easydir * -1;
            turn(180);
            easyy = easyy + 60;
        }
        
        checkBullet();
    }
    
    private void checkBullet() {
        if (isTouching(Bullet.class)) {
            Space space = (Space)getWorld();
            damageEasy++;
            space.removeBullet();
            if (damageEasy == 1) {
                space.removeObject(this);
            }
            space.updateScore(8);
        }
    }
}