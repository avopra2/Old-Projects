import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mediumfish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mediumfish extends Actor
{
    private int medx;
    private int meddir;
    private int medy;
    private int damageMed;
    
    public Mediumfish() {
        medx = 1;
        meddir = 1;
        medy = 5;
        damageMed = 0;
    }
    
    public void act() 
    {
        Space space = (Space)getWorld();
        medx = space.getSpeed();
        setLocation(getX() + medx*meddir, medy);
        
        if (getX() >= 880) {
            meddir = meddir * -1;
            turn(180);
            medy = medy + 90;
        }
        
        if (getX() <= 20) {
            meddir = meddir * -1;
            turn(180);
            medy = medy + 90;
        }
        
        checkBullet();
        
    }
    
    private void checkBullet() {
        if (isTouching(Bullet.class)) {
            Space space = (Space)getWorld();
            damageMed++;
            space.removeBullet();
            if (damageMed == 2) {
                space.removeObject(this);
            }
            space.updateScore(10);
        }
    }
}
