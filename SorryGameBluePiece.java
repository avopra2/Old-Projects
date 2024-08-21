import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BluePiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameBluePiece extends SorryGamePiece
{
    /**
     * Act - do whatever the BluePiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SorryGameBluePiece(){
        super("Blue");
    }
    
    public boolean atStart() {
        return super.atStart(-21, -22, -23, -24);
    }
    
    public void fromStartOne() {
        super.fromStartOne(4);
    }
    
    public void fromStartTwo() {
        super.fromStartTwo(5);
    }
    
    public void toStart() {
        super.toStart(-21, -22, -23, -24);
    }
    
    public boolean inSafetyZone() {
        return super.inSafetyZone(-69, -68, -67, -66, -65);
    }
    
    public void toSafetyZone() {
        super.toSafetyZone(3, -69);
    }
    
    public boolean atHome() {
        return super.atHome(-64, -63, -62, -61);
    }
}

