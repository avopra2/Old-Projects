import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameGreenPiece extends SorryGamePiece
{
    /**
     * Act - do whatever the GreenPiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SorryGameGreenPiece(){
        super("Green");
    }
    
    public boolean atStart() {
        return super.atStart(-1, -2, -3, -4);
    }
    
    public void fromStartOne() {
        super.fromStartOne(34);
    }
    
    public void fromStartTwo() {
        super.fromStartTwo(35);
    }
    
    public void toStart() {
        super.toStart(-1, -2, -3, -4);
    }
    
    public boolean inSafetyZone() {
        return super.inSafetyZone(-49, -48, -47, -46, -45);
    }
    
    public void toSafetyZone() {
        super.toSafetyZone(33, -49);
    }
    
    public boolean atHome() {
        return super.atHome(-44, -43, -42, -41);
    }
}

