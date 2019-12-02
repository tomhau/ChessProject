package domain;
import javafx.scene.paint.Color;

/**
 *
 * @author tha
 */
public class Knight extends Piece
{

    
    public Knight(String imageUrl, Color color) {
        super(imageUrl, color);
    }
    
    @Override
    public String toString(){
        return super.toString() + " Knight";
    }


}
