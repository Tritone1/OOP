/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment6;

/**
 *
 * @author Kanan
 */
public class Main {

    /**
     * Main class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Store store = new Store();

        Game game1 = new Game("GTA", "Action", 2004, 5, 2.5, false, true);
        Game game2 = new Game("FIFA", "Sport", 2006, 4, 1.5, false, true);
        Game game3 = new Game("Mortal Kombat", "Fighting", 2008, 3, 3.5, false, true);
        Game game4 = new Game("Need for Speed", "Racing", 2010, 2, 4.5, false, true);
        Game game5 = new Game("Call of Duty", "Shooter", 2012, 1, 5.5, false, true);
        
        store.addGame(game1);
        store.addGame(game2);
        store.addGame(game3);
        store.addGame(game4);
        store.addGame(game5);

        double rentalcost = store.rentGame("GTA", 5, 2);
        System.out.println("Rental cost: " + rentalcost);

        System.out.println("Total earnings: " + store.getTotal());

        double rentalcost2 = store.rentGame( "FIFA", 5, 2);
        System.out.println("Rental cost: " + rentalcost2);

        System.out.println("Total earnings: " + store.getTotal());
        System.out.println(game1.rent());
        
        System.out.println(game1.getgameName() + " is available: " + game1.isAvailable());




        

       


    }

}
 