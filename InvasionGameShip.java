import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private int gunReloadTime;
    private int reloadDelayCount;
    
    public Ship() {
        gunReloadTime = 20;
        reloadDelayCount = 0;
    }
    
    public void act() 
    {
        turnTowards(getX(), 0);
        
        checkKeyPress();
        
        reloadDelayCount++;
        if (reloadDelayCount >= gunReloadTime) {
            getWorld().showText(null, 450, 300);
        }
        
        checkCollision();
    }
    
    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("left")) {
            turnTowards(getX(), 0);
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            turnTowards(getX(), 0);
            setLocation(getX()+5, getY());
        }
        if (Greenfoot.isKeyDown("space")) {
            fire();
        }
    }
    
    private void fire() {
        if (reloadDelayCount >= gunReloadTime) {
            Space space = (Space)getWorld();
            Bullet b = new Bullet();
            space.addObject(b, getX(), getY());
            space.setBullet(b);
            b.act();
            reloadDelayCount = 0;
        }
        
        else {
            getWorld().showText("Reloading ...", 450, 300);
        }
    }
    
    private void checkCollision() {
        if (isTouching(Easyfish.class)) {
            Space space = (Space)getWorld();
            space.showText("You lose!", 450, 300);
            space.showText("Final Score: " + space.getScore(), 450, 225);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }
        
        if (isTouching(Mediumfish.class)) {
            Space space = (Space)getWorld();
            space.showText("You lose!", 450, 300);
            space.showText("Final Score: " + space.getScore(), 450, 225);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }
        
        if (isTouching(Hardfish.class)) {
            Space space = (Space)getWorld();
            space.showText("You lose!", 450, 300);
            space.showText("Final Score: " + space.getScore(), 450, 225);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }
    }
}
