import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameBoard extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */   
    public SorryGameBoard()
    {
        // Create a new Sorry Board world with 895x895 cells with a cell size of 1x1 pixels.
        super(895, 895, 1); 
        setBackground("SorryBoard.jpg");
        
        SorryGamePiece g1 = new SorryGameGreenPiece();
        addObject(g1, 605, 785);
        SorryGamePiece g2 = new SorryGameGreenPiece();
        addObject(g2, 605, 730);
        SorryGamePiece g3 = new SorryGameGreenPiece();
        addObject(g3, 660, 785);
        SorryGamePiece g4 = new SorryGameGreenPiece();
        addObject(g4, 660, 730);
        
        SorryGamePiece r1 = new SorryGameRedPiece();
        addObject(r1, 115, 605);
        SorryGamePiece r2 = new SorryGameRedPiece();
        addObject(r2, 170, 605);
        SorryGamePiece r3 = new SorryGameRedPiece();
        addObject(r3, 115, 660);
        SorryGamePiece r4 = new SorryGameRedPiece();
        addObject(r4, 170, 660);
        
        SorryGamePiece b1 = new SorryGameBluePiece();
        addObject(b1, 235, 115);
        SorryGamePiece b2 = new SorryGameBluePiece();
        addObject(b2, 290, 115);
        SorryGamePiece b3 = new SorryGameBluePiece();
        addObject(b3, 235, 170);
        SorryGamePiece b4 = new SorryGameBluePiece();
        addObject(b4, 290, 170);
        
        SorryGamePiece y1 = new SorryGameYellowPiece();
        addObject(y1, 785, 235); 
        SorryGamePiece y2 = new SorryGameYellowPiece();
        addObject(y2, 730, 235);
        SorryGamePiece y3 = new SorryGameYellowPiece();
        addObject(y3, 785, 290);
        SorryGamePiece y4 = new SorryGameYellowPiece();
        addObject(y4, 730, 290);
    }
}

