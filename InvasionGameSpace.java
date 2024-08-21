import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private int score = 0;
    private int people = 50000;
    private Bullet bullet;
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(200);
        
        showScore();
        showPeople();
        
        Earth earth = new Earth();
        addObject(earth, 450, 565);
        
        Ship ship = new Ship();
        addObject(ship, 450, 535);
    }
    
    private void createStars(int number) {
        GreenfootImage background = getBackground();
        for (int i=0; i < number; i++) {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = 150 - Greenfoot.getRandomNumber(120);
            background.setColorAt(x, y, new Color(color,color,color));
        }
    }
    
    private void showScore() {
        showText("Score: " + score, 820, 580);
    }
    
    private void showPeople() {
        showText("Unevacuated: " + people, 100, 580);
    }
    
    private void countPeople() {
        people--;
        showPeople();
        if (people == 0) {
            showText("Great job, you've saved Earth!", 450, 225);
            showText("Final Score: " + score, 450, 350);
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
    }
    
    public int getSpeed() {
        return (50000-people)/10000+1;
    }
    
    public int getScore() {
        return score;
    }
    
    public void updateScore(int change) {
        score += change;
        showScore();
    }
    
    public void setBullet(Bullet b) {
        bullet = b;
    }
    
    public void removeBullet() {
        removeObject(bullet);
    }
    
    public void act() {
        countPeople();
        
        if (Math.random() < 0.0005) {
            addObject(new Hardfish(), 30, 5);
        }
        
        else if (Math.random() < 0.0015) {
            addObject(new Mediumfish(), 30, 5);
        }
        
        else if (Math.random() < 0.005) {
            addObject(new Easyfish(), 30, 5);
        }
    }
}