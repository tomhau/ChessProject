package sample;

import javafx.scene.paint.Color;

/**
 *
 * @author tha
 */
public class Board {

    /**
     * The number of squares in a row (horizontally or vertically)
     */
    private final int NUMBEROFSQUARES = 8;
    /**
     * The size of a square in pixels
     */
    private final int SIZEOFSQUARE = 75;

    private final Square [][] squares = new Square[NUMBEROFSQUARES][NUMBEROFSQUARES];


    public Board()
    {
        this.placeAllSquares();
    }

    private void placeAllSquares(){
        int count = 0; // helper

        for (int row = 0; row < NUMBEROFSQUARES; row++)
        {
            for(int col = 0; col < NUMBEROFSQUARES; col++) //
            {
                count++;
                System.out.println("count = "+count+", row = "+row+", col = "+col);
                if (count%2 ==0)
                {
                    squares[row][col] = new Square(SIZEOFSQUARE,Color.WHITE ,col*SIZEOFSQUARE, row*SIZEOFSQUARE);
                }else
                {
                    squares[row][col] = new Square(SIZEOFSQUARE, Color.GRAY,col*SIZEOFSQUARE, row*SIZEOFSQUARE);
                }
            }
            count++;
        }
    }
    /**
     * For drawing the board based on squares
     * @return an array of all square objects on this board
     */
    public Square[] getAllSquares() {
        int index = 0;
        Square [] result = new Square[NUMBEROFSQUARES*NUMBEROFSQUARES];

        for (int y = 0; y < NUMBEROFSQUARES; y++)
        {
            for(int x = 0; x < NUMBEROFSQUARES; x++)
            {
                result[index] = this.squares[y][x];
                index++;
            }
        }
        return result;
    }





}
