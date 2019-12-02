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

    private Board board;

    /**
     * Remembers square-coordinates and piece-attributes picture, color
     */
    private Square tempSquare;

    /**
     *
     */
    private boolean moveInProgress;

    @FXML
    private Canvas backg, foreg, top;

    @FXML
    private void initialize()
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

    /**
     * Clears the top layer at this square
     * @param s the square to be cleared
     */
    private void clearMarkedSquare(Square s, boolean isTop)
    {
        GraphicsContext gc = null;
        if (isTop){
            gc = top.getGraphicsContext2D();
        }
        else{
            gc = foreg.getGraphicsContext2D();
        }

        gc.clearRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    /**
     * Draws a blue rectangle at this square
     * @param s
     */
    private void drawMarker(Square s)
    {
        GraphicsContext gc = top.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.strokeRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    /**
     * Decides if there is a piece on this square
     * @param s The square
     * @return does the square have a piece attached
     */
    private boolean hasPiece(Square s){
        boolean hasPiece = false;
        if (s.getPiece()!=null){
             hasPiece=true;
        }
        return hasPiece;
    }
    /**
     * Triggered at the start of a move
     * @param event
     */
    @FXML
    private void handlePressed(MouseEvent event) {
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        drawMarker(actualSquare);
        // step 1 check that we have a piece
        this.moveInProgress = hasPiece(actualSquare);
        tempSquare = actualSquare;
        // step 2
        if (this.moveInProgress)
        {
            clearMarkedSquare(actualSquare, false);
        }
        System.out.println("(debug) moveInProgress = " +this.moveInProgress);
        System.out.println("(debug) index in x-direction : " + actualSquare.getXIndex());
        System.out.println("(debug) index in y-direction : " + actualSquare.getYIndex());
    }
    /**
     * Triggered at the end of a move
     * @param event
     */
    @FXML
    private void handleReleased(MouseEvent event) {
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        System.out.println("actualSquare"+ actualSquare.getPosX());
        clearMarkedSquare(tempSquare,true);//
        // step 3
        if (this.moveInProgress)
        {
            actualSquare.setPiece(tempSquare.getPiece());
            drawImage(actualSquare, tempSquare.getPiece().getImageUrl());
        }
        this.moveInProgress=false;
    }



}
