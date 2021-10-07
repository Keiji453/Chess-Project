import java.util.*;
import java.io.*;
import java.time.*;

public class player {
    // variables used to hold the players data
    private int wins;
    private int loss;
    private String name;
    private String lastPlayed;
    
    // new Player
    public player(String n, int w, int l) {
        LocalDate date = LocalDate.now();
        name = n;
        wins = w;
        loss = l;
        lastPlayed = date.toString(); // gets the current data
    }

    // returning player
    public player(String n, int w, int l, String date) {
        name = n;
        wins = w;
        loss = l;
        lastPlayed = date;
    }
    //getters
    public int getWins() {
        return this.wins;
    }
    public int getLoss() {
        return this.loss;
    }

    public String getName() {
        return this.name;
    }

    public String getLastPlayed() {
        return this.lastPlayed;
    }

    // setters...ish
    public void addWin() {
        this.wins++;
    }

    public void addLoss() {
        this.loss++;
    }

    public void setNewTime() {
        LocalDate date = LocalDate.now();
        lastPlayed = date.toString();
    }

    public String toString() {
        return (name + "," + wins + "," + loss + "," + lastPlayed);
    }
}