
package assignment6;

/**
 *
 * @author Kanan
 */


/**
 * Game class
 * @param gameName the name of the game
 * @param genre the genre of the game
 * @param year the year the game was released
 * @param rating the rating of the game
 * @param priceperhour the price per hour of the game
 * @param damaged the condition of the game
 * @param available the availability of the game
 * @param totalrent the total number of times the game has been rented
 * 
 */
public class Game {
    
private String gameName;
private String genre;
private int year;
private int rating;
private int totalrent;

private double priceperhour;

private boolean damaged;
private boolean available;

public Game(String gameName, String genre, int year, int rating, double priceperhour, boolean damaged, boolean available) {
    this.gameName = gameName;
    this.genre = genre;
    this.year = year;
    this.rating = rating;
    this.priceperhour = priceperhour;
    this.damaged = false;
    this.available = true;
    this.totalrent = 0;


}

public String getgameName() {
    return gameName;
}


public String getGenre() {
    return genre;
}


public int getYear() {
    return year;
}

public int getRating() {
    return rating;
}



public int getTotalrent() {
    return totalrent;
}



public double getPriceperhour() {
    return priceperhour;
}

public boolean isDamaged() {
    return damaged;
}

public void setDamaged(boolean damaged) {
    this.damaged = damaged;
}



public boolean isAvailable() {
    return available;
}

public void setAvailable(boolean available) {
    this.available = available;
}


/**
 * Rent method to rent the game if it is available and not damaged
 * 
 * 
 * @return true if the game is rented, false if the game is not rented
 */

public boolean rent() {
    if (available && !damaged) {
     totalrent++;
     if(totalrent>20){
        damaged = true;
        available = false;
     }else{
        available = false;
     }

        return true;
    }
    return false;
}

/**
 * Return method to return the game and calculate the cost of the game
 * 
 * @param hours the number of hours the game was rented 
 * @param lateHours the number of late hours
 * 
 * @return the total cost of the game including rental cost and late fee
 */


public double returnGame(int hours, int lateHours){
    available = true;
    double cost=priceperhour*hours;
    double lateFee=priceperhour*2*lateHours;
    return cost+lateFee;

}

}
