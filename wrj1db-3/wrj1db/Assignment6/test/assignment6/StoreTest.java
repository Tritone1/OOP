package assignment6;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

    private Store store;
    private Game game1;
    private Game game2;
    private Game game3;

    @Before
    public void setUp() {
        store = new Store();
        game1 = new Game("GTA", "Action", 2004, 5, 2.5, false, true);
        game2 = new Game("FIFA", "Sport", 2006, 4, 1.5, false, true);
        game3 = new Game("Mortal Kombat", "Fighting", 2008, 3, 3.5, false, true);
        store.addGame(game1);
        store.addGame(game2);
        store.addGame(game3);
    }

    @Test
    public void testAddGame() {
        Game game4 = new Game("Need for Speed", "Racing", 2010, 2, 4.5, false, true);
        store.addGame(game4);
        assertEquals(game4, store.searchGame("Need for Speed"));
    }

    @Test
    public void testRemoveGame() {
        
        game1.setDamaged(true);
        store.removeGame(game1);
        assertNull(store.searchGame("GTA"));
    }

    @Test
    public void testSearchGame() {
        Game result = store.searchGame("FIFA");
        assertEquals(game2, result);
    }

    @Test
    public void testSearchGenre() {
        List<Game> result = store.searchGenre("Action");
        assertTrue(result.contains(game1));
        assertFalse(result.contains(game2));
    }

    @Test
    public void testSearchRating() {
        Game result = store.searchRating();
        assertEquals(game1, result);
    }

    @Test
    public void testSearchYear() {
        List<Game> result = store.searchYear(2006);
        assertTrue(result.contains(game1));
        assertTrue(result.contains(game2));
        assertFalse(result.contains(game3));
    }

    @Test
    public void testRentGame() {
        double cost = store.rentGame("GTA", 5, 2);
        assertEquals(22.5, cost, 0.01);
        assertTrue(game1.rent());
        assertFalse(game1.isAvailable());
    }


    @Test
    public void testGetTotal() {
        store.rentGame("GTA", 5, 2);
        assertEquals(22.5, store.getTotal(), 0.01);
    }
}