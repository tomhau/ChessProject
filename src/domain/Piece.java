package domain;
import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 *
 * @author tha
 */
public class Piece {
    private String imageUrl;
    private Color color;
    
  
    public Piece(String imageUrl, Color color) {
        this.imageUrl = imageUrl;
        this.color = color;
    }


    public Color getColor() {
        return this.color;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    /**
     * TODO Simplify
     * @return 
     */
    public boolean isWhite(){
        if (this.color.equals(Color.WHITE)){
            return true;
        }
        return false;
    }

    /**
     * To move a piece on the board computes the possible moves
     * @param s the actual square position
     */
    public ArrayList<Square> getPotentialMoves(Square s){
        return null;
    }
    
    @Override
    public String toString(){
        return isWhite()?"WHITE":"BLACK";
    }
        
}
