
import java.util.*;
import java.io.*;
/**
Needs:
Check
Valid Moves
Castling
*/
public class King extends Piece{
  private boolean castled;
  private boolean isChecked;
  private boolean hasMoved;

  public King(String name, boolean isWhite, int newX, int newY) {
    super (name,isWhite, newX, newY); 
    this.castled = false;
    this.hasMoved = false;
    }
//Setters
  public void setCastle(boolean status){
    this.castled = status;
  }
//Getters
  public boolean getCastle(){
    return this.castled;
  }

  //Abstract Override for Piece
  //Calculates valid moves for empty squares and taking
  //Checks for valid castling and adds to legalMoves
  //Returns an ArrayList of the valid squares
  
  public ArrayList<Square> calculateMoves(Square[][] array){
    int x = this.getPieceX();
    int y = this.getPieceY();
    boolean color = this.getWhite();

    ArrayList<Square> legalMoves = new ArrayList<Square>();

    // adds all the squares around the king to it's legal moves list as long as their is eitehr a piece of 
    // the other side or empty
    for(int i = 1; i > -2; i--){
      for(int j = 1; j > -2; j--){
        if(!(i == 0 && j == 0)){
          try{
            if(!array[x + j][y + i].hasPiece()){
              legalMoves.add(array[x + j][y + i]);
            }
            if(array[x + j][y + i].hasPiece()){
              if(array[x + j][y + i].getPiece().getWhite() != color){
                legalMoves.add(array[x + j][y + i]);
              }
            }
          }catch(ArrayIndexOutOfBoundsException e) {
            continue;
          }
        }
      }
    } 
    // castle
    // runs the check to see if the king is viable for castling either left or right and adds it to 
    // the kings legal moves.
    if (!this.hasMoved()) {
        if (this.castleL(array)) {
            array[x][y-2].setCastle(true);
            legalMoves.add(array[x][y-2]);
        } 
        if (this.castleR(array)) {
            array[x][y+2].setCastle(true);
            legalMoves.add(array[x][y+2]);
        }
        
    }

    setMoves(legalMoves);
    return legalMoves;
  } 
}
