/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6;
import java.util.ArrayList;
import java.util.List;


public class Store {
    

private List<Game> games;
private double total;

/**
 * Store class
 * @param games the list of games
 * @param total the total earnings
 * 
 */

public Store() {
    this.games = new ArrayList<>();
    this.total = 0;
}

/**
 * Add a game to the store
 * @param game the game to add
 */

public void addGame(Game game){
    games.add(game);
}

/**
 * Remove a game from the store
 * @param game the game to remove
 */

public void removeGame(Game game){
    if(game.isDamaged()){
        games.remove(game);
    }
}


/**
 * Search for a game by name
 * @param gameName the name of the game
 * @return the game with the given name
 */


public Game  searchGame(String gameName){
    for(Game game: games){ 
        if(game.getgameName().equals(gameName)&& game.isAvailable()){
            return game;
        }
    }
    return null;
}

/**
 * Search for games by genre
 * @param genre the genre of the games
 * @return the games with the given genre
 */

public List<Game> searchGenre(String genre){
    List<Game> genreGames = new ArrayList<>();
    for(Game game: games){
        if(game.getGenre().equals(genre)&& game.isAvailable()){
            genreGames.add(game);
        }
    }
    return genreGames;
}

/**
 * Search for the game with the highest rating
 * @return the game with the highest rating
 */

public Game searchRating(){
Game mostPopular=null;
    for(Game game: games){
        if(game.isAvailable() && (mostPopular==null || game.getRating()>mostPopular.getRating())){
            mostPopular=game;
        }
    }
    return mostPopular;
}

/**
 * Search for games by year
 * @param year the year of the games
 * @return the games with the given year
 */

public List<Game> searchYear(int year){
    List<Game> yearGames = new ArrayList<>();
    for(Game game: games){
        if(game.getYear()<=year && game.isAvailable()){
            yearGames.add(game);

        }
    }
    return yearGames;
}


/**
 * Rent a game
 * @param gameName the name of the game
 * @param hours the number of hours to rent the game
 * @param latehours the number of late hours
 * @return the cost of renting the game
 */

public double rentGame( String gameName, int hours, int latehours){
 Game game = searchGame(gameName);
    if(game!=null && game.rent()){
     double cost=game.returnGame(hours, latehours);
        total+=cost;
        return cost;
    }
    return 0;
}




/**
 * Get the total earnings
 * @return the total earnings
 */

public double getTotal() {
    return total;
}

}
