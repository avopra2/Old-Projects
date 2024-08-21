import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameRedPiece extends SorryGamePiece
{
    /**
     * Act - do whatever the RedPiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SorryGameRedPiece()
    {
        super("Red");
    }
    
    public boolean atStart() {
        return super.atStart(-11, -12, -13, -14);
    }
    
    public void fromStartOne() {
        super.fromStartOne(49);
    }
    
    public void fromStartTwo() {
        super.fromStartTwo(50);
    }
    
    public void toStart() {
        super.toStart(-11, -12, -13, -14);
    }
    
    public boolean inSafetyZone() {
        return super.inSafetyZone(-59, -58, -57, -56, -55);
    }
    
    public void toSafetyZone() {
        super.toSafetyZone(48, -59);
    }
    
    public boolean atHome() {
        return super.atHome(-54, -53, -52, -51);
    }
}

