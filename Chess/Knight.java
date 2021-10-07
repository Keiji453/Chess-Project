import java.util.*;
import java.io.*;


public class Knight extends Piece{

  public Knight(String name, boolean isWhite, int newX, int newY) {
    super (name,isWhite, newX, newY); 
    }

  //Abstract Override for Piece
  //Calculates valid moves for empty squares and taking
  //Returns an ArrayList of the valid squares
  public ArrayList<Square> calculateMoves(Square[][] array){
    int x = this.getPieceX();
    int y = this.getPieceY();
    boolean color = this.getWhite();

    ArrayList<Square> legalMoves = new ArrayList<Square>();

    for(int i = 2; i >= -2; i -= 2){
      for(int j = 1; j >= -1; j--){
        if(i != 0 && j != 0){
          if(x+j <= 7 && x+j >= 0 && y+i <= 7 && y+i >= 0){
            if(!array[x + j][y + i].hasPiece()){//here
              legalMoves.add(array[x + j][y + i]);
            }
            if(array[x + j][y + i].hasPiece()){
              if(array[x + j][y + i].getPiece().getWhite() != color){
                legalMoves.add(array[x + j][y + i]);
              }
            }
          }
          if(x+i <= 7 && x+i >= 0 && y+j <= 7 && y+j >= 0){
            if(!array[x + i][y + j].hasPiece()){
              legalMoves.add(array[x + i][y + j]);
            }
            if(array[x + i][y + j].hasPiece()){
              if(array[x + i][y + j].getPiece().getWhite() != color){
                legalMoves.add(array[x + i][y + j]);
              }
            }
          }
        }    
      }
    }
    
    setMoves(legalMoves);
    return legalMoves;
  }
}