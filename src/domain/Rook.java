package domain;
import domain.Piece;
import javafx.scene.paint.Color;

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
    public String toString(){
        return super.toString() + " Rook";
    }
}
