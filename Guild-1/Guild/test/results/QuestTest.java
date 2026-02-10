package results;

import guild.Adventurer;
import guild.Monster;
import guild.Quest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class QuestTest {

    private Quest quest;
    private Adventurer adventurer;
    private List<Monster> monsters;

    @Before
    public void setUp() {
        monsters = new ArrayList<>();
        monsters.add(new Monster("Goblin", 50, 20, 5));
        monsters.add(new Monster("Orc", 100, 30, 10));
        adventurer = new Adventurer("Aragorn", 150, 50);

        quest = new Quest("Defeat Goblins and Orcs", 5, monsters);
    }

    @Test
    public void testConstructor() {
        assertEquals("Defeat Goblins and Orcs", quest.getName());
        assertEquals(5, quest.getDifficulty());
        assertEquals(2, quest.getMonsters().size());
    }

    @Test
    public void testStartQuestSuccess() {
        quest.startQuest(adventurer);
        assertTrue(quest.isCompleted());
        assertFalse(adventurer.isDefeated());
    }

    @Test
    public void testStartQuestFailure() {
        adventurer.takeDamage(140);
        quest.startQuest(adventurer);
        assertFalse(quest.isCompleted());
        assertTrue(adventurer.isDefeated());
    }

    @Test
    public void testIsCompleted() {
        assertFalse(quest.isCompleted());
        quest.startQuest(adventurer);
        assertTrue(quest.isCompleted()); 
    }

    @Test
    public void testMonstersDefeated() {
        quest.startQuest(adventurer);
        for (Monster monster : monsters) {
            assertTrue(monster.isDefeated());
        }
    }
}