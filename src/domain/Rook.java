package domain;
import domain.Piece;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 *
 * @author tha
 */
public class Rook extends Piece {

    public Rook(String imageUrl, Color color)
    {
        super(imageUrl, color);
    }

    @Override
    public ArrayList<Square> getPotentialMoves(Square s){
        ArrayList<Square> res = new ArrayList<Square>();
        int indexX = s.getXIndex();
        int indexY = s.getYIndex();

        for (int x = 0; x < 8; x++){
            if (x==indexX){

            }else{
                res.add(new Square(Board.SIZEOFSQUARE,Color.RED,x*Board.SIZEOFSQUARE,indexY*Board.SIZEOFSQUARE));
                //
            }
        }
        for (int y = 0; y < 8; y++){
            if (y==indexY){

            }else{
                res.add(new Square(Board.SIZEOFSQUARE,Color.RED,indexX*Board.SIZEOFSQUARE,y*Board.SIZEOFSQUARE));
                //
            }
        }


        return res;
    }

    @Override
    public String toString(){
        return super.toString() + " Rook";
    }
}
