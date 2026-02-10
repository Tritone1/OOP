package results;

import guild.Adventurer;
import guild.Guild;
import guild.Monster;
import guild.Quest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class GuildTest {

    private Guild guild;

    @Before
    public void setUp() {
        guild = new Guild();
    }

    @Test
    public void testAddAdventurer() {
        Adventurer adventurer = new Adventurer("Legolas", 80, 40);
        guild.addAdventurer(adventurer);
        assertEquals(1, guild.adventurers.size());
        assertEquals("Legolas", guild.adventurers.get(0).getName());
    }

    @Test
    public void testAddQuest() {
        Quest quest = new Quest("Rescue the Village", 5, new ArrayList<>());
        guild.addQuest(quest);
        assertEquals(1, guild.quests.size());
        assertEquals("Rescue the Village", guild.quests.get(0).getName());
    }

    @Test
    public void testAssignQuest() {
        Adventurer adventurer = new Adventurer("Gimli", 100, 50);
        guild.addAdventurer(adventurer);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Orc", 50, 20, 5));
        Quest quest = new Quest("Defeat Orcs", 3, monsters);
        guild.addQuest(quest);
        guild.assignQuest();

        assertTrue(quest.isCompleted());
    }

  
}