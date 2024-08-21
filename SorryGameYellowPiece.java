import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameYellowPiece extends SorryGamePiece
{
    /**
     * Act - do whatever the YellowPiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SorryGameYellowPiece(){
        super("Yellow");
    } 
    
    public boolean atStart() {
        return super.atStart(-31, -32, -33, -34);
    }
    
    public void fromStartOne() {
        super.fromStartOne(19);
    }
    
    public void fromStartTwo() {
        super.fromStartTwo(20);
    }
    
    public void toStart() {
        super.toStart(-31, -32, -33, -34);
    }
    
    public boolean inSafetyZone() {
        return super.inSafetyZone(-79, -78, -77, -76, -75);
    }
    
    public void toSafetyZone() {
        super.toSafetyZone(18, -79);
    }
    
    public boolean atHome() {
        return super.atHome(-74, -73, -72, -71);
    }
}

