package results;

import guild.Game;
import guild.Guild;
import guild.Monster;
import guild.Adventurer;
import guild.Quest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTest {

    private Guild guild;
    private Map<String, Monster> monsterRegistry;
    private List<Adventurer> adventurers;

    @Before
    public void setUp() {
        guild = new Guild();

        monsterRegistry = new HashMap<>();
        monsterRegistry.put("Goblin", new Monster("Goblin", 50, 10, 5));
        monsterRegistry.put("Orc", new Monster("Orc", 100, 20, 10));
        monsterRegistry.put("Troll", new Monster("Troll", 150, 30, 15));
        guild.addAdventurer(new Adventurer("Aragorn", 100, 50));
        guild.addAdventurer(new Adventurer("Legolas", 90, 40));
        guild.addAdventurer(new Adventurer("Gimli", 120, 60));
        List<Monster> quest1Monsters = new ArrayList<>();
        quest1Monsters.add(monsterRegistry.get("Goblin"));
        Quest quest1 = new Quest("Defeat Goblins", 3, quest1Monsters);
        List<Monster> quest2Monsters = new ArrayList<>();
        quest2Monsters.add(monsterRegistry.get("Orc"));
        Quest quest2 = new Quest("Rescue the Village", 5, quest2Monsters);
        guild.addQuest(quest1);
        guild.addQuest(quest2);
    }

    @Test
    public void testLoadAdventurers() {
        assertEquals(3, guild.adventurers.size()); 
        assertEquals("Aragorn", guild.adventurers.get(0).getName());
        assertEquals("Legolas", guild.adventurers.get(1).getName());
        assertEquals("Gimli", guild.adventurers.get(2).getName());
    }

    @Test
    public void testLoadMonsters() {
        assertEquals(3, monsterRegistry.size()); 
        assertTrue(monsterRegistry.containsKey("Goblin"));
        assertTrue(monsterRegistry.containsKey("Orc"));
        assertTrue(monsterRegistry.containsKey("Troll"));
    }

    @Test
    public void testLoadQuests() {
        assertEquals(2, guild.quests.size()); 
        assertEquals("Defeat Goblins", guild.quests.get(0).getName());
        assertEquals("Rescue the Village", guild.quests.get(1).getName());
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


    assertTrue("Quest should be marked as completed", quest.isCompleted());
    assertFalse("Adventurer should not be defeated", adventurer.isDefeated());
}
}