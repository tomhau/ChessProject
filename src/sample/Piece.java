package sample;
import javafx.scene.paint.Color;

/**
 *
 * @author tha
 */
public abstract class Piece {
    private final String imageUrl;
    private final Color color;
    
  
    public Piece(String imageUrl, Color color) {
        this.imageUrl = imageUrl;
        this.color = color;
    }

    // NEW 
    public Color getColor() {
        return color;
    }
    // NEW
    public String getImageUrl() {
        return imageUrl;
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
    
    @Override
    public String toString(){
        return isWhite()?"WHITE":"BLACK";
    }
        
}
