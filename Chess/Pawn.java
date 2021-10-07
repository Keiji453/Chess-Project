import java.util.*;
import java.io.*;
/**
Needs:
Enpassant
First double move
**/
public class Pawn extends Piece {
    private boolean hasMoved;
    private int moveCount;
    //private boolean enPassant;
    private final int ix; 
    public Pawn(String name, boolean isWhite, int x, int y){
        super (name, isWhite, x, y);
        this.hasMoved = false;
        //this.moveCount = false;
        this.ix = x;

    }
    //Setters
    public void setMoveCount(){
      this.moveCount++;
    }
    // Override
    // DM - checks if the pawn is viable for a double move and sets the target moves double moves to true
    // ep - en passant checks if there is another pawn beside the current one and if it just double moved
    public ArrayList<Square> calculateMoves(Square[][] array){
      int x = this.getPieceX();
      int y = this.getPieceY();
      boolean color = this.getWhite();

      ArrayList<Square> legalMoves = new ArrayList<Square>();

    //Checks white Conditions For Single and Double
      if(this.getPieceX() != ix){
        this.hasMoved = true;
      }
      if(color){
        if(x - 1 >= 0){
          if(!array[x - 1][y].hasPiece()){
            legalMoves.add(array[x - 1][y]);
            if(!(this.hasMoved) && !(array[x - 2][y].hasPiece())){
              array[x - 2][y].setDM(true);
              legalMoves.add(array[x - 2][y]);
              
            }
          }
        }
      //Attack Move Left
        if(x - 1 >= 0 && y - 1 >= 0){
          if(array[x - 1][y - 1].hasPiece()){
            if(!array[x - 1][y - 1].getPiece().getWhite()){
              legalMoves.add(array[x - 1][y - 1]);
            }
          }
        }
      //Attack Move Right
        if(x - 1 >= 0 && y + 1 <= 7){
          if(array[x - 1][y + 1].hasPiece()){
            if(!array[x - 1][y + 1].getPiece().getWhite()){
              legalMoves.add(array[x - 1][y + 1]);
            }
          }
        }

        // ep right side white
        if ((y + 1 < array[x].length) && (array[x][y + 1].hasPiece() && array[x][y+1].getDM() )) {
            if (array[x][y+1].getPiece().getName().equals("BP")) {
                array[x-1][y+1].setEP(true);
                legalMoves.add(array[x-1][y+1]);
            }
        }

        // ep left side white
        if ((y-1 >=0) && (array[x][y - 1].hasPiece() && array[x][y-1].getDM() )) {
            if (array[x][y-1].getPiece().getName().equals("BP")) {
                array[x-1][y-1].setEP(true);
                legalMoves.add(array[x-1][y-1]);
            }
        }

      }
      
      //Black Pawns
      if(!color){
        if(x + 1 <= 7){
          if(!array[x + 1][y].hasPiece()){
            legalMoves.add(array[x + 1][y]);
            if(!(this.hasMoved) && !(array[x + 2][y].hasPiece())){
              array[x + 2][y].setDM(true);
              legalMoves.add(array[x + 2][y]);
            }
          }
        }
      //Attack Move Left
        if(x + 1 <= 7 && y - 1 >= 0){
          if(array[x + 1][y - 1].hasPiece()){
            if(array[x + 1][y - 1].getPiece().getWhite()){
              legalMoves.add(array[x + 1][y - 1]);
            }
          }
        }
      //Attack Move Right
        if(x + 1 <=  7 && y + 1 <= 7){
          if(array[x + 1][y + 1].hasPiece()){
            if(array[x + 1][y + 1].getPiece().getWhite()){
              legalMoves.add(array[x + 1][y + 1]);
            }
          }
        } 
        // ep right side black
        if ((y + 1 < array[x].length) && (array[x][y + 1].hasPiece() && array[x][y+1].getDM() )) {
            if (array[x][y+1].getPiece().getName().equals("WP")) {
                array[x+1][y+1].setEP(true);
                legalMoves.add(array[x+1][y+1]);
            }
        }

        // ep left side black
        if ((y-1>=0) && (array[x][y - 1].hasPiece() && array[x][y-1].getDM() ) ) {
            if (array[x][y-1].getPiece().getName().equals("WP")) {
                array[x+1][y-1].setEP(true);
                legalMoves.add(array[x+1][y-1]);
            }
        }
      }
      setMoves(legalMoves);
      return legalMoves;
      //Blocking
    }
}


