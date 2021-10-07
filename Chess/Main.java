import java.util.*;
import java.io.*;
//Game Class
public class Main {
 /** 
     * <h1>Chess!</h1> *
     * This program should hopefully end up being a completed game of chess
     * along with a working local scoreboard system.
     * This is my own and my partner's work.
     *
     * @author Joaquin Kataoka
     * @author Justin Lee
     * @version 3.0
**/

    
  // initializing chess variables
  private static File score;
  // hashmap used for storing the player data
  private static HashMap<String,player> playerData;
  private static Board board;
  private static Scanner scan;
  // simaler to the hashmap but only used for sorting
  private static ArrayList<player> pData;

  //Scordboard Method
  //Reads the built in csv
  public static void scoreboard() {
    playerData = new HashMap<>();
    pData = new ArrayList<>();
    score = new File("scoreboard.csv");
    // trys to instantiate a file reader
    try (Scanner fileScan = new Scanner(score)) { 
      if (!fileScan.hasNext()) {
        System.out.println("Empty Scoreboard");
      } 
      while (fileScan.hasNext()) {
        // splits and inserts data from file into playerdata hashmaps and
        // into player data type
        String temp = fileScan.nextLine();
        String[] array = temp.split(",");
        playerData.put(array[0], new player(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]));
        pData.add(new player(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]));
      }
      
    // catch if file not found
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Error File not found,");
      System.out.println("Please create a new scoreboard.csv file,");
    } finally {
      
    }

  }

  //Method Prompt to add score to id of winner of session.
  public static void promptW(String win) {
    String name;
    System.out.print(win + " Please enter your name(Case sensitive): ");
    name = scan.nextLine();
    // checks to see if there is already a previous player entry of the same name
    if (playerData.containsKey(name)) {
        // adds a win if name was found
      playerData.get(name).addWin();
      playerData.get(name).setNewTime();
    } else {
        // else creates a new player with one loss
      playerData.put(name,new player(name, 1, 0));
    }   
  }
  
  //Method Prompt to add score to id of winner of session.
  public static void promptL(String loss) {
    String name;
    System.out.print(loss + " Please enter your name(Case sensitive): ");
    name = scan.nextLine();
    // does the same thing as promptW but for a loss
    if (playerData.containsKey(name)) {
      playerData.get(name).addLoss();
    } else {
      playerData.put(name,new player(name, 0, 1));
    }   
  }
  //Main game method
  //Creates all relevant game variables
  //Swaps the players turns and checks state of games until game is over
  public static void gameLoop() {
    // creates a new game
    board = new Board();
    board.printBoard();
    boolean p1 = true;
    boolean gameOver = false; 

    while(!gameOver){
      boolean p1Wins = board.getP1Win();
      boolean p2Wins = board.getP2Win();
      boolean stalemate = board.getStalemate();
      // aslong as either player is not in checkmate or in stalemate continue the game.
      // prompts white wins and allows user to add their score to the scoreboard
      if(p1Wins){
            System.out.println("WHITE WINS!");
            gameOver = true;
            promptW("White");
            promptL("Black");
            //return;
          }
          // promts black wins and allows user to add their score to the scoreboard
        if(p2Wins){
            System.out.println("BLACK WINS!");
            gameOver = true;
            promptW("Black");
            promptL("White");
            //return;
        }
        // staleamte and both users lose
        if(stalemate){
            System.out.println("TIE!");
            gameOver = true;
            promptL("White");
            promptL("Black");
            //return;
          }
      if(!gameOver){
        if(p1){
          p1 = false;
          board.calcMoves();
          board.moveMain(true);
          
        } else {
          p1 = true;
          board.calcMoves();
          board.moveMain(false);
          if(p1Wins){
            System.out.println("WHITE WINS!");
            gameOver = true;
            return;
          }
          if(p2Wins){
            System.out.println("BLACK WINS!");
            gameOver = true;
            return;
          }
          if(stalemate){
            System.out.println("TIE!");
            gameOver = true;
            return;
          }
        }      
      } 
    }   
  }

  //Write Method
  public static void write() {
      // takes the user data from the scoreboard HashMap and writes all of it to the 
      // scoreboard.csv
    try (PrintWriter writer =  new PrintWriter(score)) {
      for (Map.Entry<String,player> pair: playerData.entrySet()) {
        writer.println(pair.getValue().toString());
      }
    } catch (FileNotFoundException e) {

    }
  }
    // selection sort for the number of player wins
  public static void sortWins() {
    for (int i = 0; i < pData.size()-1; i++) {
      int min = i;
      for (int k = i+1; k < pData.size();k++) {
        if (pData.get(k).getWins() < pData.get(min).getWins()) {
          min = k;
        }
      }
      player temp = pData.get(i);
      pData.set(i,pData.get(min));
      pData.set(min, temp);
    }
  }
  // selection sort for the number player losses
  public static void sortLoss() {
    for (int i = 0; i < pData.size()-1; i++) {
      int min = i;
      for (int k = i+1; k < pData.size();k++) {
        if (pData.get(k).getLoss() < pData.get(min).getLoss()) {
          min = k;
        }
      }
      player temp = pData.get(i);
      pData.set(i,pData.get(min));
      pData.set(min, temp);
    }
  }
    // interative binary search for a specific number of player wins
  public static int WinSearch(int x) {
    int l = 0;
    int r = pData.size()-1;
    while (l <= r) {
      int m = l + (r-1)/2;

      if (pData.get(m).getWins() == x) {
        return m;
      }
      if (pData.get(m).getWins() < x) {
        l = m +1;
      } else {
        r = m -1;
      }
    }
    return -1;
  }
  // interative binary search for a specific number of player losses
  public static int LossSearch(int x) {
    int l = 0;
    int r = pData.size()-1;
    while (l <= r) {
      int m = l + (r-1)/2;

      if (pData.get(m).getLoss() == x) {
        return m;
      }
      if (pData.get(m).getLoss() < x) {
        l = m +1;
      } else {
        r = m -1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    // instantiates the scanner and the board
    scan = new Scanner(System.in);
    board = new Board();
    String answer;
    // prepares the scoreboard
    scoreboard();
    System.out.println("_____________________________________________________________________________________");
    System.out.println(" _       __     __                             __                __                  ");
    System.out.println("| |     / /__  / /________  ____ ___  ___     / /_____     _____/ /_  ___  __________");
    System.out.println("| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / ___/ __ \\/ _ \\/ ___/ ___/");
    System.out.println("| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /__/ / / /  __(__  |__  ) ");
    System.out.println("|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/   \\___/_/ /_/\\___/____/____(_)");
    System.out.println("_____________________________________________________________________________________"+"\n");
    System.out.print("Please type 'Go' to start: ");
    answer = scan.nextLine();

    // menu while loop
    while (!answer.equalsIgnoreCase("Exit")) {
      // prints user options
      System.out.println("\nOPTIONS: \nScoreboard\nGame\nExit\nPlease enter an option to start");
      System.out.print("Option: ");
      answer = scan.nextLine();

      if (answer.equalsIgnoreCase("scoreboard")) {
        System.out.println("\nNOTE: SCOREBOARD WILL UPDATE ON RESTART");
        System.out.println("\nSCOREBOARD OPTIONS: \nSort Wins\nSort Loss\nGet Wins\nGet Loss\nSearch\nPrintBoard");
        answer  = scan.nextLine();

        if (answer.equalsIgnoreCase("Sort Wins")) {
          // sorts array inorder of wins from lowest to highest
          sortWins();
          System.out.println();
          for (int i = pData.size()-1; i >=0; i--) {
            System.out.println(pData.get(i).toString());
          }
          System.out.println();

        } else if (answer.equalsIgnoreCase("Sort Loss")) {
          // sorts array inoder of losses from lowest to highest
          sortLoss();
          System.out.println();
          for (int i = pData.size()-1; i >=0; i--) {   
            System.out.println(pData.get(i).toString());
          }
          System.out.println();
        // sorts and then searches for a specific number of wins
        } else if (answer.equalsIgnoreCase("Get Wins")) {
          System.out.print("Please enter the amount of wins: ");
          sortWins();
          try {
            int temp = scan.nextInt();
            try {
              System.out.println();
              System.out.println(pData.get(WinSearch(temp)).toString());
              System.out.println();
            } catch (Exception e) {
              System.out.println();
              System.out.println("WIN COUNT NOT FOUND");
              System.out.println();
            }
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid input");
            scan.next();
          }
        // sorts and then searches for a specific number of losses
        } else if (answer.equalsIgnoreCase("get Loss")) {
          System.out.print("Please enter the amount of Losses: ");
          sortLoss();
          try {
            int temp = scan.nextInt();
            try {
              System.out.println();
              System.out.println(pData.get(LossSearch(temp)).toString());
              System.out.println();
            } catch (Exception e) {
              System.out.println("\nLOSS COUNT NOT FOUND");
              System.out.println();
            }
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid input");
            scan.next();
          }
        // searches for a specific user and returns their data
        } else if (answer.equalsIgnoreCase("Search")) {
          System.out.print("Please enter name of player: ");
          answer = scan.nextLine();
          if (playerData.containsKey(answer)) {
            System.out.println();
            System.out.println(playerData.get(answer).toString());
            System.out.println();
          } else {
            System.out.println("\nPLAYER NOT FOUND\n");
          }
        // prints the entire scoreboard of players
        } else if (answer.equalsIgnoreCase("Printboard")) {
          System.out.println("\n||||||SCOREBOARD||||||\n");
          System.out.println("Name, Wins, Losses, Last Played");
          for (Map.Entry<String,player> pair: playerData.entrySet()) {
            System.out.println(pair.getValue().toString());
          }
          System.out.println();
        }
      // creates a new game of chess!
      } else if (answer.equalsIgnoreCase("game")) {
        gameLoop();
        // exits
      } else if (answer.equalsIgnoreCase("Exit")) {
        System.out.println("See you next time!");
      }
    }
    // writes/updates all of the player data into the scoreboard csv.
    write();
  } 
}

