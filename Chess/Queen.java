import java.util.*;
import java.io.*;
 
 public class Queen extends Piece {
     public Queen (String name , boolean isWhite, int x ,int y) {
         super(name, isWhite, x , y); 
     }

    //Abstract Override for Piece
    //Calculates valid moves for empty squares and taking
    //Returns an ArrayList of the valid squares
    // all code blocks scan for empty square and stop if it either hits a piece that is of the same colour
    // or opposite colour
    public ArrayList<Square> calculateMoves(Square[][] array){
        int x = this.getPieceX();
        int y = this.getPieceY();
        boolean color = this.getWhite();
        int l = array.length;

        ArrayList<Square> legalMoves = new ArrayList<Square>();
        //Right Up Check -X +Y
        
        int i = 1;
        while (((y + i < array[x].length) && (x - i >=0) ) && (array[x - i][y + i].getPiece() == null || array[x - i][y + i].getPiece().getWhite() != color)) {
                legalMoves.add(array[x - i][y + i]);

                if (array[x - i][y + i].getPiece() != null) {
                    i = 8;
                } else {
                    i++;
                }

        }
        
        // Left up check -x - y
        i = 1;
        while (((y - i >= 0) && (x -i >=0) ) && (array[x - i][y - i].getPiece() == null || array[x - i][y - i].getPiece().getWhite() != color))  {
                legalMoves.add(array[x - i][y - i]);

                if (array[x - i][y - i].getPiece() != null) {
                    i = 8;
                } else {
                    i++;
                }

        }

        //Right down Check +X +Y
        i = 1;
        while (((y + i < array[x].length) && (x + i < array.length) ) && (array[x + i][y + i].getPiece() == null || array[x + i][y + i].getPiece().getWhite() != color)) {
                legalMoves.add(array[x + i][y + i]);

                if (array[x + i][y + i].getPiece() != null) {
                    i = 8;
                } else {
                    i++;
                }

        }
        // Left down check +x - y
        i = 1;
        while (((y - i >= 0) && (x + i < array.length) ) && (array[x + i][y - i].getPiece() == null || array[x + i][y - i].getPiece().getWhite() != color))  {
                legalMoves.add(array[x + i][y - i]);

                if (array[x + i][y - i].getPiece() != null) {
                    i = 8;
                } else {
                    i++;
                }

        }
        i = 1;
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