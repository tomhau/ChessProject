package application;

import domain.Board;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import domain.Square;

public class Controller {

    private Board board; // (1) New

    @FXML
    private Canvas backg, foreg, top;

    @FXML
    private void init()
    {
        board = new Board();
        drawBoard();
        drawPieces();  // New
    }

    private void drawBoard()  // (3) New
    {
        for (Square s : this.board.getAllSquares())
        {
            drawSquare(s);
        }
    }


    private void drawPieces(){
        for (Square s : board.getAllSquares())
        {
            if (s.getPiece()!=null)
            {
                drawImage(s,s.getPiece().getImageUrl());
            }
        }
    }


    /**
     * Draws a single square on the background
     * @param s the square to be drawn
     */
    private void drawSquare(Square s)
    {
        GraphicsContext gc = backg.getGraphicsContext2D();
        gc.setFill(s.getColor());
        gc.fillRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }


    /**
     * Draws a single image on a single square
     * @param s  the square where the image i placed
     * @param url the name of the image
     */
    private void drawImage(Square s, String url)
    {
        GraphicsContext gc = foreg.getGraphicsContext2D();
        Image image = new Image(url);
        gc.drawImage(image, s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    // New
    private void clearMarkedSquare(Square s)
    {
        GraphicsContext gc = top.getGraphicsContext2D();
        gc.clearRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }
    // New
    private void drawMarker(Square s)
    {
        GraphicsContext gc = top.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    // NEW
    @FXML
    private void handlePressed(MouseEvent event) {
        System.out.println("(debug), x = "+ event.getX()+", y = "+event.getY());
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        System.out.println("(debug), index_x = " + actualSquare.getPosX()+", index_y = "+actualSquare.getPosY() + " is the upper left position of the pressed square");
        drawMarker(actualSquare);
    }
    // New
    @FXML
    private void handleReleased(MouseEvent event) {
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        System.out.println("(debug), index_x = " + actualSquare.getPosX()+", index_y = "+actualSquare.getPosY() + " is the upper left position of the released square");

        clearMarkedSquare(actualSquare);

    }



}
