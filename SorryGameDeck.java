import greenfoot.*; 
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo

import java.util.Stack; 
import java.util.Collections;

/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SorryGameDeck
{
    private static Stack<Integer> deck = new Stack<Integer>();
    
    public SorryGameDeck() {
        for (int i=12; i>=0; i--) { 
            if (i != 9 && i != 6) { // 0 = "Sorry!" 
                for (int j=0; j<4; j++) { 
                    deck.add(i); 
                } 
            } 
        } 
        deck.add(1); 
    } 

    public void shuffleDeck() {
        Collections.shuffle(deck); 
    } 

    public int takeCard() {
        return deck.pop(); 
    } 

    public boolean isEmpty() {
        return(deck.size() == 0); 
    }
}


