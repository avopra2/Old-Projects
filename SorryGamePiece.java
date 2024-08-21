
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGamePiece extends Actor
{
    private String color;

    public SorryGamePiece(String c){
        color = c;
        setImage(color + ".png");
    }
    
    private SorryGameDeck d;

    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        d = new SorryGameDeck();
        d.shuffleDeck();
        
        while(true) {
            for (int i = 0; i < 4; i++) { // 0 = Green, 1 = Red, 2 = Blue, 3 = Yellow
                if (d.isEmpty()) {
                    d = new SorryGameDeck();
                    d.shuffleDeck();
                }
                
                // indicate it is player's turn
                if (i == 0) {
                    color = "Green";
                }
                if (i == 1) {
                    color = "Red";
                }
                if (i == 2) {
                    color = "Blue";
                }
                if (i == 3) {
                    color = "Yellow";
                }
                
                int card = d.takeCard();
                
                if (card != 0) {
                    getWorld().showText("" + card + ": Select a piece to move, " + color, 700, 400);
                }
                else {
                    getWorld().showText("Sorry!: Select a piece to move, " + color, 700, 400);
                }
            }
        }
    }

    public void move(int card) {
        int current = SorryGameCoordinate.getCoordinate(this);
        
        // if (this.atHome()) {
        // break;
        // }
        
        // if (this.inSafetyZone()) {
        // Coordinate.movement(this, current+card);
        // break;
        // }
        
        if (card == 3 || card == 5 || card == 8 || card == 12) {
            // Base case
            SorryGameCoordinate.movement(this, (current+card) % 60);
        }
        else if (card == 0) {
            // Sorry! or move 4
            getWorld().showText("Press 1 for Sorry!, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                // if (Greenfoot.mouseClicked(Piece sp) {
                // int scurrent = Coordinate.getCoordinate(sp);
                // Coordinate.movement(this, scurrent);
                // sp.toStart();
                // }
            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+4) % 60);
            }
        }
        else if (card == 1) {
            // Out of home or move 1
            getWorld().showText("Press 1 to move out of home, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                // fromStartOne();
            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+card) % 60);
            }
        }
        else if (card == 2) {
            // Out of home or move 2
            getWorld().showText("Press 1 to move out of home, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                // fromStartTwo();
            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+card) % 60);
            }
        }
        else if (card == 4) {
            // Move backwards 4
            SorryGameCoordinate.movement(this, (current-card) % 60);
        }
        else if (card == 7) {
            // Move 7 or split between 2
            getWorld().showText("Press 1 for split, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                getWorld().showText("Press length of move for first piece (1-6)", 700, 400);
                int m = Integer.parseInt(Greenfoot.getKey());
                SorryGameCoordinate.movement(this, (current+m) % 60);
                getWorld().showText("Select second piece", 700, 400);
                // Selects second piece sp
                // if (Greenfoot.mouseClicked(Piece sp) {
                // int scurrent = Coordinate.getCoordinate(sp);
                // Coordinate.movement(sp, (scurrent + card - m) % 60);
                // }
            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+card) % 60);
            }
        }
        else if (card == 10) {
            // Move 10 or backwards 1
            getWorld().showText("Press 1 for backwards 1, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                SorryGameCoordinate.movement(this, (current-1) % 60);
            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+card) % 60);
            }
        }
        else if (card == 11) {
            // Move 11 or change places
            getWorld().showText("Press 1 for switch, 2 for normal move", 700, 400);
            
            if (Greenfoot.getKey() == "1") {
                getWorld().showText("Select second piece", 700, 400);
                // Selects second piece sp, this time an opponent's
                // if (Greenfoot.mouseClicked(Piece sp) {
                // int scurrent = Coordinate.getCoordinate(sp);
                // Coordinate.movement(this, scurrent);
                // Coordinate.movement(sp, current);
                // }

            }
            if (Greenfoot.getKey() == "2") {
                SorryGameCoordinate.movement(this, (current+card) % 60);
            }
        }
        
        // if (intersects(Piece p)) {
        //    p.toStart();
        // }
    }
    
    public boolean atStart(int a, int b, int c, int d) {
        int pos = SorryGameCoordinate.getCoordinate(this);
        return (pos == a || pos == b || pos == c || pos == d);
    }
    
    public void fromStartOne(int t1) {
        SorryGameCoordinate.movement(this, t1);
    }
    
    public void fromStartTwo(int t2) {
        SorryGameCoordinate.movement(this, t2);
    }
    
    public void toStart(int a, int b, int c, int d) {
        int start = (int) (Math.random()*4);
        if (start == 0) {
            SorryGameCoordinate.movement(this, a);
        }
        if (start == 1) {
            SorryGameCoordinate.movement(this, b);
        }
        if (start == 2) {
            SorryGameCoordinate.movement(this, c);
        }
        if (start == 3) {
            SorryGameCoordinate.movement(this, d);
        }
    }
    
    public boolean inSafetyZone(int z1, int z2, int z3, int z4, int z5) {
        int pos = SorryGameCoordinate.getCoordinate(this);
        return (pos == z1 || pos == z2 || pos == z3 || pos == z4 || pos == z5);
    }
    
    public void toSafetyZone(int f, int t) {
        int pos = SorryGameCoordinate.getCoordinate(this);
        if (pos == f) {
            SorryGameCoordinate.movement(this, t);
        }
    }
    
    public boolean atHome(int h1, int h2, int h3, int h4) {
        int pos = SorryGameCoordinate.getCoordinate(this);
        return (pos == h1 || pos == h2 || pos == h3 || pos == h4);
    }
}


