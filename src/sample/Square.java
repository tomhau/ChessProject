package sample;


/**
 * Created by tha on 04-12-2018.
 * @author tha
 */

import javafx.scene.paint.Color;


public class Square {
    /**
     * The size of the square
     * In pixels
     */
    private int size;

    private Color color;

    private int posX;

    private int posY;

    // private Piece piece;

    public Square(int size, Color color, int posX, int posY) {
        this.size = size;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }



    public int getPosY() {
        return posY;
    }



    /*
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    */
}

