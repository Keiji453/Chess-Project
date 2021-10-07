import java.util.*;
import java.io.*;

public abstract class Piece{
  private boolean white;
  private int pieceX;
  private int pieceY;
  private String name;
  private ArrayList<Square> possibleMoves;
  private boolean moved;
//Constructor for if a piece is white or dead
  public Piece(){
    this.possibleMoves = new ArrayList<Square>();
    this.white = false;
    this.name = null;
    this.moved = false;
  }

//Constructor for creation of a piece object
  public Piece(String newName, boolean isWhite, int newX, int newY){
    this.name = newName;
    this.white = isWhite;
    this.pieceX = newX;
    this.pieceY = newY;
  }
//Setters 

  public void setMoved(boolean in) {
    this.moved = in;
  }

  public void setMoves(ArrayList<Square> newList) {
    this.possibleMoves = newList;
  }

  public void setWhite(boolean isWhite){
    this.white = isWhite;
  }

  public void setPieceX(int newX){
    this.pieceX = newX;
  }

  public void setPieceY(int newY){
    this.pieceY = newY;
  }

  public void setPieceXY(int newX, int newY){
    this.pieceX = newX;
    this.pieceY = newY;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public void removeMove(Square sq){
      if (this.possibleMoves.contains(sq)) {
          this.possibleMoves.remove(sq);
      }
  }

//Getters
    public boolean hasMoved() {
        return this.moved;
    } 

  public ArrayList<Square> getMoves() {
      return this.possibleMoves;
  }

  
  public boolean getWhite(){
    return this.white;
  }

  public String getName() {
      return this.name;
    }

  public int getPieceX(){
    return this.pieceX;
  }

  public int getPieceY(){
    return this.pieceY;
  }

    
    // to be used in tandum with castle method
    // needs hasMoved() method.
    //Queenside
    public boolean castleL (Square[][] array) {
        int x = pieceX;
        int y = pieceY;
        
        Square sq = array[x][y];
        boolean colour =sq.getPiece().getWhite();
        //Queenside
        // checks in relative position to the king if there is a rook in the left side corner and 
        // if it has moved, as well as checks the kings square and the two to the left if they 
        // are in check
        if (array[x][y - 4].getPiece() != null && (array[x][y - 4].getPiece().hasMoved() == false && array[x][y-4].getPiece().getName().substring(1).equals("R"))) {
            if ((!array[x][y-1].hasPiece() && !array[x][y-2].hasPiece()) && !array[x][y-3].hasPiece()) {
                if (!Board.checkDetector(colour,array[x][y], array)) {
                    if (!Board.checkDetector(colour,array[x][y - 1], array)) {
                        if (!Board.checkDetector(colour,array[x][y - 2], array)) {
                            return true;
                        }

                    }
                }
                /*
                if ((!Board.checkDetector(colour,array[x][y], array) && !Board.checkDetector(colour,array[x][y-1], array)) && !Board.checkDetector(colour,array[x][y-2], array)) {
                    return true;
                }
                */
            }
        }
        return false;
    }
    

    //Kingside
    // checks in relative position to the king if there is a rook in the right side corner and 
    // if it has moved, as well as checks the kings square and the two to the right if they 
    // are in check

    public boolean castleR (Square[][] array) {
        int x = pieceX;
        int y = pieceY;

        Square sq = array[x][y];
        boolean colour =sq.getPiece().getWhite();

        if (array[x][y + 3].getPiece() != null && (array[x][y + 3].getPiece().hasMoved() == false && array[x][y+3].getPiece().getName().substring(1).equals("R"))) {
            if ((!array[x][y+1].hasPiece() && !array[x][y+2].hasPiece())) {
                if (!Board.checkDetector(colour,array[x][y],array)) {
                    if (!Board.checkDetector(colour,array[x][y + 1],array)) {
                        if (!Board.checkDetector(colour,array[x][y + 2],array)) {
                            return true;
                        }
                    }

                }
                /*
                if ((!Board.checkDetector(colour,array[x][y], array) && !Board.checkDetector(colour,array[x][y+1], array)) && !Board.checkDetector(colour,array[x][y+2],array) ) {
                    return true;
                }
                */
            }
        }
        return false;
    }
    
  
  //Abstract Class for Legal Moves
  public abstract ArrayList<Square> calculateMoves(Square[][] array);

  

}
