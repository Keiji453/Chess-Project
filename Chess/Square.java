import java.util.*;
import java.io.*;

public class Square{
  private Piece piece;
  final private int x;
  final private int y;
  private boolean DoubleM;
  private boolean enPassant;
  private boolean castle;

//Constructors
  public Square(){
    this.piece = null;
    this.x = 0;
    this.y = 0;
  }

  public Square(Piece newPiece, int newX, int newY){
    this.piece = newPiece;
    this.x = newX;
    this.y = newY; 
  }

//Setters

    public void setCastle(boolean in) {
        this.castle = in;
    } 

    public void setDM (boolean in) {
        this.DoubleM = in;
    }

    public void setEP (boolean in) {
        this.enPassant = in;
    }
    // sets a new piece and updates it's x and y position
  public void setPiece(Piece newPiece){
    this.piece = newPiece;
    if (this.piece != null) {
        this.piece.setPieceX(this.x);
        this.piece.setPieceY(this.y);
    }
  }
  public void setEmpty(){
    this.piece = null;
  }

//Getters
    public boolean getCastle () {
        return this.castle;
    }

    public boolean getDM () {
        return this.DoubleM;
    }

    public boolean getEP () {
        return this.enPassant;
    }

  public int getSquareX(){
    return x;
  }

  public int getSquareY(){
    return y;
  }

  public Piece getPiece(){
    return this.piece;
  }

  public String printString() {
      return "temp";
  }
//Helper
//Checks if the square has a piece or not
  public boolean hasPiece(){
    return !(this.piece == null);
  }

//toString Method
    public String toString() {
        if (this.piece == null) {
            return " --";
        } else { 
            return " " + this.piece.getName();
        }
    }
}