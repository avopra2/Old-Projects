import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hardfish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hardfish extends Actor
{
    private int hardx;
    private int harddir;
    private int hardy;
    private int damageHard;
    
    public Hardfish() {
        hardx = 1;
        harddir = 1;
        hardy = 5;
        damageHard = 0;
    }
    
    public void act() 
    {
        Space space = (Space)getWorld();
        hardx = space.getSpeed();
        setLocation(getX() + hardx*harddir, hardy);
        
        if (getX() >= 880) {
            harddir = harddir * -1;
            turn(180);
            hardy = hardy + 120;
        }
        
        if (getX() <= 20) {
            harddir = harddir * -1;
            turn(180);
            hardy = getY() + 120;
        }
        
        checkBullet();
        
    }
    
    private void checkBullet() {
        if (isTouching(Bullet.class)) {
            Space space = (Space)getWorld();
            damageHard++;
            space.removeBullet();
            if (damageHard == 2) {
                space.removeObject(this);
            }
            space.updateScore(12);
        }
    }
}
