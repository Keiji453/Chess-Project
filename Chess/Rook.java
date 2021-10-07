 
import java.util.*;
import java.io.*;
 
 public class Rook extends Piece {
     private boolean hasMoved;

     public Rook (String name , boolean isWhite, int x ,int y) {
         super(name, isWhite, x , y); 
         this.hasMoved = false;
     }
     
    //Abstract Override for Piece
    //Calculates valid moves for empty squares and taking
    //Returns an ArrayList of the valid squares
    // scans in straight lines until it finds another piece.
    public ArrayList<Square> calculateMoves(Square[][] array){
        int x = this.getPieceX();
        int y = this.getPieceY();
        boolean color = this.getWhite();

        ArrayList<Square> legalMoves = new ArrayList<Square>();
        // horizontal right check
        int i = 1;
        while ((y + i < array[x].length) && (array[x][y + i].getPiece() == null || array[x][y + i].getPiece().getWhite() != color)) {
                legalMoves.add(array[x][y + i]);

                if (array[x][y + i].getPiece() != null) {
                i = 8;
            } else {
                i++;
            }
        }
        // horizontal left check.
        i = 1;
        while ((y - i >= 0) && (array[x][y - i].getPiece() == null || array[x][y - i].getPiece().getWhite() != color))  {
                legalMoves.add(array[x][y - i]);

                if (array[x][y - i].getPiece() != null) {
                i = 8;
            } else {
                i++;
            }
        }

        // vertical top check
        i = 1;
        while ((x - i >= 0) && (array[x - i][y].getPiece() == null || array[x - i][y].getPiece().getWhite() != color)) {
            legalMoves.add(array[x - i][y]);

            if (array[x - i][y].getPiece() != null) {
                i = 8;
            } else {
                i++;
            }
        }

        // vertical bot check
        i = 1;
        while ((x + i < array.length) && (array[x + i ][y].getPiece() == null || array[x + i ][y].getPiece().getWhite() != color)) {
            legalMoves.add(array[x + i][y]);

            if (array[x + i][y].getPiece() != null) {
                i = 8;
            } else {
                i++;
            }
        }
        setMoves(legalMoves);
        return legalMoves;
    }
 }