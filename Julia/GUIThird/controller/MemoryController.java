package controller;

import view.*;
import model.*;
import java.awt.event.*;

public class MemoryController
{
    protected Deck deck;
    protected FullGameBoard memoryTable;
    protected LayoutCards cards;

    protected ActionListener playListener;
    protected ActionListener resetListener;
    //protected ActionListener pickCardsListener;

    protected String difficulty;
    private int moves;

    public MemoryController(Deck d, FullGameBoard memoryBoard, LayoutCards cards)
    {
        this.deck = d;
        this.memoryTable = memoryBoard;
        this.cards = cards;

        playListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                play();
            }
        };
        resetListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                reset();
            }
        };
        /*
        pickCardsListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                buttonSelect();
            }
        };*/

        this.memoryTable.startGame(playListener);
        this.memoryTable.resetGame(resetListener);
        //this.cards.pickCards(pickCardsListener);
    }

    private void play()
    {
        difficulty = memoryTable.getDifficulty();
        deck = new Deck(difficulty);
        moves = 0;
        memoryTable.placeCards(deck);
        //memoryTable.updateHighScore(difficulty);
        //memoryTable.updateMoves(moves);
        memoryTable.resetTime();
        memoryTable.updateMainFrame();
    }
    private void reset()
    {
        difficulty = memoryTable.getDifficulty();
        deck = new Deck(difficulty);
        moves = 0;
        memoryTable.placeCards(deck);
        //memoryTable.updateHighScore(difficulty);
        //memoryTable.updateMoves(moves);
        memoryTable.resetTime();
        memoryTable.updateMainFrame();
    }
    /*
    private void buttonSelect()
    {
        if (cards.cardSelected()==false)
        {
            //hides previously selected cards
            cards.getButton().setIcon(null);
            cards.getSecondButton().setIcon(null);         
        }
    }
    */
}