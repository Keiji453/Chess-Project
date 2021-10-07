import java.util.*;
import java.io.*;

public class Board{
  private Square[][] boardArray;
  private boolean gameOver;
  private boolean stalemate;
  private boolean p1Wins;
  private boolean p2Wins;
  //Constructor
  public Board(){
    setBoard();
    this.gameOver = false;
    this.p1Wins = false;
    this.p2Wins = false;
    this.stalemate = false;
  }
  
  //Setter method that creates the board, pieces and squares.
  public void setBoard(){
    boardArray = new Square[8][8];
    //Initializes White Piece

    Pawn wp1 = new Pawn("WP", true, 6, 0);
    boardArray[6][0] = new Square(wp1, 6, 0);

    Pawn wp2 = new Pawn("WP", true, 6, 1);
    boardArray[6][1] = new Square(wp2, 5, 1);

    Pawn wp3 = new Pawn("WP", true, 6, 2);
    boardArray[6][2] = new Square(wp3, 6, 2);

    Pawn wp4 = new Pawn("WP", true, 6, 3);
    boardArray[6][3] = new Square(wp4, 6, 3);

    Pawn wp5 = new Pawn("WP", true, 6, 4);
    boardArray[6][4] = new Square(wp5, 6, 4);

    Pawn wp6 = new Pawn("WP", true, 6, 5);
    boardArray[6][5] = new Square(wp6, 6, 5);

    Pawn wp7 = new Pawn("WP", true, 6, 6);
    boardArray[6][6] = new Square(wp7, 6, 6);

    Pawn wp8 = new Pawn("WP", true, 6, 7);
    boardArray[6][7] = new Square(wp8, 6, 7);

    King wk1 = new King("WK", true, 7, 4);
    boardArray[7][4] = new Square(wk1, 7, 4);

    Queen wq1 = new Queen("WQ", true, 7, 3);
    boardArray[7][3] = new Square(wq1, 7, 3);

    Knight wn1 = new Knight("WN", true, 7, 1);
    boardArray[7][1] = new Square(wn1, 7, 1);

    Knight wn2 = new Knight("WN", true, 7, 6);
    boardArray[7][6] = new Square(wn2, 7, 6);

    Bishop wb1 = new Bishop("WB", true, 7, 2);
    boardArray[7][2] = new Square(wb1, 7, 2);

    Bishop wb2 = new Bishop("WB", true, 7, 5);
    boardArray[7][5] = new Square(wb2, 7, 5);

    Rook wr1 = new Rook("WR", true, 7, 0);
    boardArray[7][0] = new Square(wr1, 7, 0);

    Rook wr2 = new Rook("WR", true, 7, 7);
    boardArray[7][7] = new Square(wr2, 7, 7);

    //Initializes Black Pieces
    Pawn bp1 = new Pawn("BP", false, 1, 0);
    boardArray[1][0] = new Square(bp1, 1, 0);

    Pawn bp2 = new Pawn("BP", false, 1, 1);
    boardArray[1][1] = new Square(bp2, 1, 1);

    Pawn bp3 = new Pawn("BP", false, 1, 2);
    boardArray[1][2] = new Square(bp3, 1, 2);

    Pawn bp4 = new Pawn("BP", false, 1, 3);
    boardArray[1][3] = new Square(bp4, 1, 3);

    Pawn bp5 = new Pawn("BP", false, 1, 4);
    boardArray[1][4] = new Square(bp5, 1, 4);

    Pawn bp6 = new Pawn("BP", false, 1, 5);
    boardArray[1][5] = new Square(bp6, 1, 5);

    Pawn bp7 = new Pawn("BP", false, 1, 6);
    boardArray[1][6] = new Square(bp7, 1, 6);

    Pawn bp8 = new Pawn("BP", false, 1, 7);
    boardArray[1][7] = new Square(bp8, 1, 7);

    King bk1 = new King("BK", false, 0, 4);
    boardArray[0][4] = new Square(bk1, 0, 4);
    
    Queen bq1 = new Queen("BQ", false, 0, 3);
    boardArray[0][3] = new Square(bq1, 0, 3);
    
    Knight bn1 = new Knight("BN", false, 0, 1);
    boardArray[0][1] = new Square(bn1, 0, 1);

    Knight bn2 = new Knight("BN", false, 0, 6);
    boardArray[0][6] = new Square(bn2, 0, 6);
  
    Bishop bb1 = new Bishop("BB", false, 0, 2);
    boardArray[0][2] = new Square(bb1, 0, 2);

    Bishop bb2 = new Bishop("BB", false, 0, 5);
    boardArray[0][5] = new Square(bb2, 0, 5);
    
    Rook br1 = new Rook("BR", false, 0, 0);
    boardArray[0][0] = new Square(br1, 0, 0);

    Rook br2 = new Rook("BR", false, 0, 7);
    boardArray[0][7] = new Square(br2, 0, 7);

    //Stalemate Setup
    /*
    King bk1 = new King("BK", false, 0, 4);
    boardArray[0][4] = new Square(bk1, 0, 4);

    King wk1 = new King("WK", true, 7, 4);
    boardArray[7][4] = new Square(wk1, 7, 4);


    Rook wr1 = new Rook("WR", true, 7, 1);
    boardArray[7][1] = new Square(wr1, 7, 1);

    Rook wr2 = new Rook("WR", true, 7, 7);
    boardArray[7][7] = new Square(wr2, 7, 7);
    */
    //Intitalizes empty squares with squares filled with null pieces
    //Row
    for(int i = 0; i < 8; i++){
      //Col
      for(int j = 0; j < 8; j++){
        if(boardArray[i][j] == null){
          boardArray[i][j] = new Square(null,i,j);
        }
      }
    }
    int t1 =0;
    int t2 =0;
    int t3 =0;
    int t4 =0;

    for (Square[] row: boardArray) {
        for (Square c: row) {
            if (c.hasPiece()) {
                if (c.getPiece().getName().equals("BK")) {
                    t1 = c.getSquareX();
                    t2 = c.getSquareY();
                }
                if (c.getPiece().getName().equals("WK")) {
                    t3 = c.getSquareX();
                    t4 = c.getSquareY();
                }
                if (!c.getPiece().getName().substring(1).equals("K")) { 
                  c.getPiece().calculateMoves(boardArray);
                }
            }
          
        }
    }  
  }
  public ArrayList<Square> calc(int y, int x, Square[][] array){
    return boardArray[y][x].getPiece().calculateMoves(array);
  }
  // handfull of getters
  public boolean getGame(){
    return this.gameOver;
  }

  public boolean getP1Win(){
    return this.p1Wins;
  }

  public boolean getP2Win(){
    return this.p2Wins;
  }

  public boolean getStalemate(){
    return this.stalemate;
  }

  // calculates all possible moves for all pieces
  public void calcMoves () {
      for (Square[] row: this.boardArray) {
          for (Square c: row) {
              if (c.hasPiece()) {
                  c.getPiece().calculateMoves(this.boardArray);
              }
          }
      }
  }

    // simply prints the board
  public void printBoard(){
    int count2 = 0;
    System.out.println("X" + "  -----------------------" + "\n");
    for (Square[] row: boardArray) {
        System.out.print(count2 + " ");
        for (Square c: row) {
            System.out.print(c.toString());
        }
        count2++;
        System.out.println("\n");
    } 
    System.out.println("   0  1  2  3  4  5  6  7  Y");
    System.out.println( "   -----------------------" + "\n");
  }


  public void moveMain(boolean isWhite){
      // eliminates all illegal moves for current player
    eliminate(isWhite);
    // resets en Passant 
    if (isWhite) {
      for (Square c: boardArray[5]) {
        c.setEP(false);
      }
    } else {
      for (Square c: boardArray[2]) {
        c.setEP(false);
      }
    }
    // checks if the current player is not in check
    if (!checkmateDetector(isWhite)) {
        move(isWhite);
        printBoard();
        // checks if current player is in checkmate
    } else if(checkmateDetector(isWhite)) {
        System.out.println("CHECKMATE");
        this.gameOver = true;
        // checks if current player is in stalemate
    } else if(stalemateDetector(isWhite)){
      stalemate = true;
      System.out.println("STALEMATE");
      this.gameOver = true;
    }
  }
  //Move Driver Code
  public void move(boolean isWhite){
    Scanner scan = new Scanner(System.in);
    int startX;
    int startY;
    int desX;
    int desY;
    boolean color = isWhite;

    Square startSquare;
    Piece startPiece;
    Square desSquare;
    Piece desPiece;

    if(color){
      System.out.println();
      System.out.println("White to move.");
      System.out.println("--------------");
    } else {
      System.out.println();
      System.out.println("Black to move.");
      System.out.println("--------------");
    }
  
    if (stalemateDetector(color)) {
        gameOver = true;
        stalemate = true;
        System.out.println("STALEMATE");
    }

    //Prompt for Selected Piece
    try{
      System.out.print("Select Piece X:");
      startX = scan.nextInt();
      System.out.print("Select Piece Y:");
      startY = scan.nextInt();
    } catch(Exception e) { // catch invalid imput (type mismatch)
      System.out.println("Error Occurred.");
      scan.next();
      move(color);
      return;
    }
    
    // checks if input is within the bounds of the board
    if(!(startX >= 0 && startX <= 7)){
      System.out.println("X Number not within board bounds.");
      move(color);
      return;
    }
   
    if(!(startY >= 0 && startY <= 7)){
      System.out.println("Y Number not within board bounds.");
      move(color);
      return;
    }

    // gets the starting piece and square
    startPiece = this.boardArray[startX][startY].getPiece();
    startSquare = this.boardArray[startX][startY];
    //Failsafe for empty square selected.

    // does a check if current player is in stalemate or checkmate
    if(checkmateDetector(color)){
      return;
    }
    if (stalemateDetector(color)) {
        return;
    }
    // no piece
    if(!startSquare.hasPiece()){
      System.out.println("Error, no piece selected.");
      move(color);
      return;
    }
     //Failsafe for wrong color selected.
    if(startPiece.getWhite() != color){
      System.out.println("Error, wrong color selected.");
      move(color);
      return;
    }
    
    System.out.println("\n"+"------------------");
    System.out.println("Piece Selected: " + startPiece.getName());
    System.out.println("------------------");

    //Prompt for Destination Square
    try {
      System.out.print("Select Destination X: ");
      desX = scan.nextInt();

      System.out.print("Select Destination Y: ");
      desY = scan.nextInt();
      System.out.println();
    } catch (Exception e) {
      System.out.println("Error Occurred.");
      scan.next();
      move(color);
      return;
    }

    if(!(desX >= 0 && desX <= 7)){
      System.out.println("X Number not within board bounds.");
      move(color);
      return;
    }
   
    if(!(desY >= 0 && desY <= 7)){
      System.out.println("Y Number not within board bounds.");
      move(color);
      return;
    }
    
    desPiece = this.boardArray[desX][desY].getPiece();
    desSquare =  this.boardArray[desX][desY];
    if(!startPiece.getMoves().contains(desSquare)){
      System.out.println("Not a valid square.");
      move(color);
      return;
    }
    if(!startSquare.hasPiece() || startPiece.getWhite() != color){
      System.out.println("Not a valid move.");
      move(color);
    } else {
        // checks if the move is valid (ie doen't put the king into check)
      if(testMove(startX, startY, desX, desY, color)){
        System.out.println("Invalid move, King in Check.");
        // removes invalid move
        this.boardArray[startX][startY].getPiece().removeMove(this.boardArray[desX][desY]);
        move(color);
      } else {
          // checks if the move is contained in the starting pieces legalmoves list
        if(startSquare.getPiece().getMoves().contains(desSquare)){
            // hopefully prevents castling from messing with the kings movements
          if ((desSquare.getCastle() && startPiece.getName().substring(1).equals("K") && ((color && !whiteKingCheck()) || (!color && !blackKingCheck()))) && ((startY + 3 < boardArray[startX].length && startY -4 >=0) && ((boardArray[startX][startY - 4].getPiece() != null && boardArray[startX][startY-4].getPiece().getName().substring(1).equals("R")) || (boardArray[startX][startY + 3].getPiece() != null && boardArray[startX][startY+3].getPiece().getName().substring(1).equals("R"))))  ) {
              castleHelper(startX, startY,desX,desY); //used to swap the kings and the rooks position
          } else if (desSquare.getEP() && startPiece.getName().substring(1).equals("P")) {
              // checks if the pawn is viable for en passant
              epHelper(color, startX, startY, desX, desY); // helps the pawn en Passant
          // checks if the destination square doesn't have a  piece
          } else if(!desSquare.hasPiece()){
            startPiece.setMoved(true);
            desSquare.setPiece(startPiece);
            startSquare.setEmpty();
            // checks if current piece is ready for promotion
            promotionHelp(desSquare);
          // checks if the destination square has a piece
          } else if(desSquare.hasPiece()){
            if(desSquare.getPiece().getWhite() != startPiece.getWhite()){
              startPiece.setMoved(true);
              desSquare.setPiece(startPiece);
              startSquare.setEmpty();
              promotionHelp(desSquare); // checks if the piece is ready for promotion
            } 
          }

        }

      }
    }
  }
    // is working
    // eliminates all illegal moves for the current player
    public void eliminate(boolean colour) {
        int x;
        int y;
        int dx;
        int dy;
        int i;

        // for each row...
        for (Square[] row: boardArray) {
            // for each item in a row
            for (Square c: row) {
                //System.out.println(c);
                // get current square x & y
                x = c.getSquareX();
                y = c.getSquareY();
                // if it has a piece and is of the same colour
                if (c.hasPiece() && c.getPiece().getWhite() == colour) {
                    i = 0;
                    // goes through the first item in the moves array and removes it
                    // if it doesn't need to be removed it moves to the next.
                    while (i < c.getPiece().getMoves().size()) {
                        // gets destination x and y
                        dx = c.getPiece().getMoves().get(i).getSquareX();
                        dy = c.getPiece().getMoves().get(i).getSquareY();
                        // tests each possible move and removes it if not possible.
                        if (testMove(x, y, dx, dy, colour)) {
                            c.getPiece().removeMove(c.getPiece().getMoves().get(i));
                        } else {
                            i++;
                        }
                        
                    }
                }
            }
        }
    }
  // checks if the current king is in check and how many legal moves there are
  // if the there are none and the kings is in check the current player looses.
  public boolean checkmateDetector(boolean isWhite){
    int moveCount = 0;
    boolean color = isWhite; 
    for (Square[] row: this.boardArray) {
      for (Square c: row) {
        if(c.hasPiece()){
          if(c.getPiece().getWhite() == color){
            moveCount += c.getPiece().getMoves().size();
          }
        }
      }
    }
    if(moveCount == 0 && whiteKingCheck() && color){
      this.gameOver = true;
      this.p2Wins = true;
      return true;
      

    }
    if(moveCount == 0 && blackKingCheck() && !color){
      this.gameOver = true;
      this.p1Wins = true;
      return true;
      

    }
    return false;
  }
    // checks if the current king is not in check and how many legal moves are possible
    // if there are none and the kings is not in check both players loose and there is a stalemate
    public boolean stalemateDetector(boolean isWhite){
    int moveCount = 0;
    boolean color = isWhite; 
    for (Square[] row: this.boardArray) {
      for (Square c: row) {
        if(c.hasPiece()){
          if(c.getPiece().getWhite() == color){
            moveCount += c.getPiece().getMoves().size();
          }
        }
      }
    }
    if(moveCount == 0 && !whiteKingCheck() && color){
      gameOver = true;
      return true;
      

    }
    if(moveCount == 0 && !blackKingCheck() && !color){
      gameOver = true;
      return true;
      

    }

    return false;
  }
  // checks if the white kings is currently in check
  public boolean whiteKingCheck(){
    int x = 0;
    int y = 0;

    for (Square[] row: this.boardArray) {
          for (Square wk: row) {
              if (wk.hasPiece()) {
                if(wk.getPiece().getName().equals("WK")){
                  x = wk.getSquareX();
                  y = wk.getSquareY();
                }
              }
          }
      }
      for (Square[] row: this.boardArray) {
          for (Square c: row) {
              if ((c.hasPiece()) && !c.getPiece().getWhite()) {
                  if (c.getPiece().calculateMoves(this.boardArray).contains(this.boardArray[x][y])) {
                      return true;
                  }
              }
          }
      }

      return false;
  }
  // checks if the black king is in check.
  public boolean blackKingCheck(){
    int x = 0;
    int y = 0;

    for (Square[] row: this.boardArray) {
          for (Square wk: row) {
              if (wk.hasPiece() && wk.getPiece().getName().equals("BK")) {
                  x = wk.getSquareX();
                  y = wk.getSquareY();
              }
          }
      }

      for (Square[] row: this.boardArray) {
          for (Square c: row) {
              if ((c.hasPiece()) && c.getPiece().getWhite()) {
                  if (c.getPiece().calculateMoves(this.boardArray).contains(this.boardArray[x][y])) {
                      return true;
                  }
              }
          }
      }
      return false;
  }
  // checks the specified square if it is in check or not.
  // mainly used for castling check
  public static boolean checkDetector(boolean colour,Square sq, Square[][] array){
      for (Square[] row: array) {
          for (Square c: row) {
              if (c.hasPiece()) {
                if((c.getPiece().getWhite() != colour)){
                  if (c.getPiece().getMoves().contains(sq)) {
                      return true;
                  }
                }
              }
          }
      }
      return false;
  }
    // a simple method used to helps the pawn en Passant.
    // it moves the attacking pawn to the proper space and then "kills" the 
    // other pawn.
  public void epHelper(boolean colour,int x, int y, int dx, int dy) {
      if (colour) {
          this.boardArray[dx][dy].setPiece(this.boardArray[x][y].getPiece());
          this.boardArray[x][y].setPiece(null);
          this.boardArray[dx+1][dy].setPiece(null);
      } else {
          this.boardArray[dx][dy].setPiece(this.boardArray[x][y].getPiece());
          this.boardArray[x][y].setPiece(null);
          this.boardArray[dx-1][dy].setPiece(null);
      }
  }

    // simply swaps the king and the chosen rooks position
  public void castleHelper(int x, int y, int dx, int dy) {
      this.boardArray[x][y].getPiece().setMoved(true);

      if (y - 2 == dy) {
          this.boardArray[x][y-4].getPiece().setMoved(true);
          this.boardArray[dx][dy].setPiece(this.boardArray[x][y].getPiece());
          this.boardArray[x][y].setPiece(null);
          this.boardArray[x][y-1].setPiece(boardArray[x][y-4].getPiece());
          this.boardArray[x][y-4].setPiece(null);
      }
      if (y + 2 == dy) {
          this.boardArray[x][y+3].getPiece().setMoved(true);
          this.boardArray[dx][dy].setPiece(this.boardArray[x][y].getPiece());
          this.boardArray[x][y].setPiece(null);
          this.boardArray[x][y+1].setPiece(boardArray[x][y+3].getPiece());
          this.boardArray[x][y+3].setPiece(null);
      }
  }

  // test the input move and reverts it.
  // will delete given move if the current king is still in check or is put into check.
  public boolean testMove(int x, int y, int destX, int destY, boolean isWhite){
    boolean check = false;
    int startX = x;
    int startY = y;
    int desX = destX;
    int desY = destY;
    Piece gp = null;
    Piece desPiece;
    boolean color = isWhite;
    if(boardArray[desX][desY].hasPiece()){
      desPiece = boardArray[desX][desY].getPiece();
    } else {
      desPiece = null;
    }
    Piece startPiece = boardArray[startX][startY].getPiece();
    Square startSquare = boardArray[startX][startY];
    Square desSquare = boardArray[desX][desY];
   
    if (desSquare.getEP() && startPiece.getName().substring(1).equals("P")) {
        if (color) {
            gp = this.boardArray[desX + 1][desY].getPiece();
        }else {
            gp = this.boardArray[desX - 1][desY].getPiece();
        }
        this.epHelper(color,startX,startY,desX,desY);
    } else {
        desSquare.setPiece(startPiece);
        startSquare.setEmpty();
    }

    if(color){
      if(whiteKingCheck()){
        check = true;
      }
    } 
    if(!color){
      if(blackKingCheck()){
        check = true;
      }
    }

    startSquare.setPiece(startPiece);
    desSquare.setPiece(desPiece);
    if (desSquare.getEP() && startPiece.getName().substring(1).equals("P")) {
        if (color) {
            this.boardArray[desX + 1][desY].setPiece(gp);
        }else {
            this.boardArray[desX - 1][desY].setPiece(gp);
        }
    }

    return check;
  }
    // prompts the user to promote their pawn to either a queen bishop rook or knight
    public void promotionHelp (Square sq) {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        boolean colour = sq.getPiece().getWhite();
        int x = sq.getSquareX();
        int y = sq.getSquareY();
        String n;
        // checks if the piece can promote and prompts for user answer
        if (colour) {
            if ((sq.getPiece().getName().substring(1).equals("P")) && (x == 0)) {
                System.out.print("What would you like to promote to?(Queen, bishop etc): ");
                answer = scan.nextLine();
            } 
        } else {
            if ((sq.getPiece().getName().substring(1).equals("P")) && (x == 7)) {
                System.out.print("What would you like to promote to?(Queen, bishop etc): ");
                answer = scan.nextLine();
            } 
        }
        // changes the piece on the current square depending on the users answer.
        if ((sq.getPiece().getName().substring(1).equals("P")) && (x == 0) || (sq.getPiece().getName().substring(1).equals("P")) && (x == 7)) {
            if (answer.equalsIgnoreCase("Queen")) {
            if (colour) {
                n = "WQ";
            } else {
                n = "BQ";
            }
        this.boardArray[x][y].setPiece(new Queen(n,colour,x,y));
        } else if (answer.equalsIgnoreCase("Bishop")) {
            if (colour) {
                n = "WB";
            } else {
                n = "BB";
            }
        this.boardArray[x][y].setPiece(new Bishop(n,colour,x,y));
            
        } else if (answer.equalsIgnoreCase("Knight")) {
            if (colour) {
                n = "WN";
            } else {
                n = "BN";
            }
        this.boardArray[x][y].setPiece(new Knight(n,colour,x,y));

        } else if (answer.equalsIgnoreCase("Rook")) {
            if (colour) {
                n = "WR";
            } else {
                n = "BR";
            }
        this.boardArray[x][y].setPiece(new Rook(n,colour,x,y));

        } else {
            System.out.println("Err invalid move try again");
            promotionHelp(sq);
        }
        }
    }

  public Square getSquare(int x, int y) {
      return boardArray[x][y];
  }
}
