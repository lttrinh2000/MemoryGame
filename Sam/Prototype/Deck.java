import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private int x; 
    Random randomGenerator;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck()
    {
        x = 1;
        /*
        String difficulty = something.getMode();
        if (difficulty.equals("Easy"))
            {x = 1;}
        else if (difficulty.equals("Medium"))
            {x = 2;}
        else
            {x = 3;}
        */

        for (int i = 1; i <= 2; i++)
        {
            for(int j = 1; j <= x; j++)
            {
                cards.add(new Card(Card.Type.fillSquare, j));
                cards.add(new Card(Card.Type.centerSquare, j));
                cards.add(new Card(Card.Type.polkaSquare, j));
                cards.add(new Card(Card.Type.fillTriangle, j));
                cards.add(new Card(Card.Type.dotTriangle, j));
                cards.add(new Card(Card.Type.centerCircle, j));
                cards.add(new Card(Card.Type.linesCircle, j));
            }
        }
        randomGenerator = new Random();
    }
    
    public void shuffle()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            int swap_with = randomGenerator.nextInt(cards.size());
            Card swapped = cards.get(i);
            cards.set(i,cards.get(swap_with));
            cards.set(swap_with, swapped);
        }
    }
}