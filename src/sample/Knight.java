package sample;
import javafx.scene.paint.Color;

/**
 *
 * @author tha
 */
public class Knight extends Piece 
{
    private int x;
    
    
    public Knight(String imageUrl, Color color) {
        super(imageUrl, color);
    }
    
    @Override
    public String toString(){
        return super.toString() + " Knight";
    }
}
