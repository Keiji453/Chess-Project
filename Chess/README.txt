Hello!
Welcome to Chess.
This program was made on 22/03/2021 and completed on 18/04/2021.

This program was made by Justin Lee and Joaquin Kataoka 
for their final project in the course ICS4U1.

We put a lot into this, so we hope you enjoy.

--------------------------------------------------------------------
HOW TO PLAY:
The game is chess, and incorporates the normal chess rules.

BOARD
- A square grid of 64 squares/8 by 8.

PLAYERS
- Denoted by color, black("B_") or white("W_")
- Black Pieces start at the top, White Pieces start at the bottom

CAPTURE
- Capturing is a move in chess where a friendly pieces moves on to 
  a square occupied by an enemy piece. The enemy piece is considered
  captured, and removed from play.

PIECES
  PAWNS
  - Denoted by the P after the color("_P").
    MOVEMENT
    - Move towards the middle of board.
    - Black pawns move down.
    - White pawns move upward.
    - The first move of a pawn can be one or two spaces forward.
      Any move after can only be one move.
    CAPTURE
    - A pawn has a special method of capture, 
      it can only capture an enemy piece that is one square diagonal forward to the piece.
      EN PASSANT
      - When an a pawn performs a double jump on its initial move, an adjacent enemy pawn
        can advance to the square behind the inital pawn. The inital pawn is considered
        captured and is removed from play.
    PROMOTION
    - When a pawn reaches its respective opposite side of the board, it can undergo promotion.
    - The pawn must promote into a Queen, Rook, Bishop, or Knight.
    - The promoted piece will remove the pawn from the game and takes its place.

  BISHOP
  - Denoted by the B after the color("_B").
    MOVEMENT
    - Can move diagonally in a straight line to a square, 
      but not through pieces, or squares occupied by allies.
    CAPTURE
    - A bishop can capture an enemy piece by moving to its occupied square.
  
  KNIGHT
  - Denoted by the N after the color("_N").
    MOVEMENT
    - A knight has the most unique method of movement, 
      it can go through pieces, and moves by going two spaces forward,
      then one space left or right, in an L shape.
    CAPTURE
    - A knight can capture an enemy piece by moving to its occupied square.

  ROOK
  - Denoted by the R after the color("_R").
    MOVEMENT
    - Can move in a straight line to a square,
      but not through pieces, or squares occupied by allies.
    CAPTURE
    - A rook can capture an enemy piece by moving to its occupied square. 

  QUEEN
  - Denoted by the Q after the color("_Q").
    MOVEMENT
    - Can move in a straight line or diagonally in a straight line to a square,
      but not through pieces, or squares occupied by allies.
    CAPTURE
    - A rook can capture an enemy piece by moving to its occupied square. 

  KING
  - Denoted by the K after the color("_K").
    MOVEMENT
    - Can move in one move straight or diagonally in direction.
    CAPTURE
    - A king can capture an enemy piece by moving to its occupied square.
    CHECK
    - The king of both sides cannot be captured, but only 'checked'
    - A check occurs when an enemy pieces threatens to capture, 
      ie. a king is one space diagonal from an enemy pawn.
    - When a king is in check, the king must be moved out of check immediately. 
    - A player cannot put themselves in check.
    - It can avoid check three separate ways.
        EVADE
        - If there are squares around the king that would not result in a check, 
          moving to the square with the king would remove it from check.
        BLOCK
        - If there is an allied piece that could move to block the line of sight
          of an enemy piece that currently checks the king, it can remove check
          from the king. If it is the only move possible, it must be made.
        CAPTURE
        - If the enemy piece checking the king can be taken by either the king or
          an allied piece that would not result in check, that would be a method
          of removing check.
    CASTLING
    - A king and rook has a special method of movement called castling.
    - There are five requirements for castling.
    - The king and selected rook must not have performed a move;
    - The squares either kingside or queenside between the rooks, must be empty.
    - The king cannot be in check. 
    - The squares that are empty cannot have an enemy piece threaten them,
      otherwise, the king would pass through check.
    - The king cannot result cannot be in check after castling.
    - If all requirements are met, the king can castle kingside or queenside.
      KINGSIDE CASTLE
      - The king moves two spaces toward the rook on the kingside.
      - The rook moves to square on the opposite of the king.

      KINGSIDE CASTLE
      - The king moves two spaces toward the rook on the queenside.
      - The rook moves to square on the opposite of the king.

GAME END CONDITIONS
- A game can result in two states, checkmate, or stalemate.
  CHECKMATE
  - Checkmate occurs when a player's king is checked, 
    and there are no moves that could remove the king from check, and/or
    without putting it into check afterwards.
  - The checking player is considered the winner.

  STALEMATE
  - Stalemate occurs when a player has no valid moves on the board,
    but their king is not in check.
  - The game is considered drawn, no one is considered the winner.
--------------------------------------------------------------------
HOW TO USE:
- When running the program, the players will be presented with a prompt to 'Go'.
- After typing go, they will presented with the three options.

  SCOREBOARD
  - Entering scoreboard will present you with six options.
    SORT WINS
    SORT LOSS
    GET WINS
    GET LOSS
    SEARCH
    PRINTBOARD
  GAME
  - Entering game will present a print of a board.
  - The program will prompt the first player/white for four different inputs.
  - Their selected piece's X, Y, and the piece's destination.
  - If the move is sucessful, the the turn will passed to black, and they
    perform the same actions.
  - If not successful, either because of check or invalid entries, the current
    player will be reprompt for a valid move.
  - If a pawn reaches promotion, the pawn's player will prompted 
    for the new piece.
  - To castle, select the king, and choose the square in which the king
    would result in after castling occurs.
  -To en passant, select the pawn, and choose the square behind the 
    pawn being captured.

  EXIT
  - Entering this will exit the program. No further commands can be made.
--------------------------------------------------------------------
COOL FEATURES:

MECHANICS
- This version of the program includes promotion, castling, and en passant.
- We initially believed these features would not be abled to be implemented
  due complexity and limited time we had.
- We were really excited to make a chess game that functioned somewhat closely
  to lichess or chess.com.
- It doesn't have all the bells and whistles, but they make it the complete game.

SCOREBOARD
- Keeps track of previous players.
- Keeps track of wins and losses.
- Tracks the last known time each player has played.
- Can sort scoreboard by wins and losses.
- Allows the user to search for a specific users name, wins, and losses.
--------------------------------------------------------------------
POSSIBLE/PLAUSIBLE BUGS
- Because of the number of possible positions and number of pieces,
  some bugs may never be found, some known bugs may have benn fixed.
- The castling may or may not interfere with the movement of the kings.
- There maybe false
- May crash if scoreboard.csv does not exist.
- Onces a user is created in the scoreboard they cannot be taken off unless deleted from the file.
- Player might be able to en Passant a pawn the has double moved more than a turn ago if the 
  pawn didn't move after double moving.