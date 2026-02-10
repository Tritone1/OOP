package guild;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Main class for the Guild game.
 * 
 * @param guild the guild object
 * @param monsterRegistry the registry of monsters
 * @param args command line arguments
 */



public class Game {
    public static void main(String[] args) {
        Guild guild = new Guild();
        Map<String, Monster> monsterRegistry = new HashMap<>();
        loadAdventurers("src/guild/adventurers.txt", guild);
        loadMonsters("src/guild/monsters.txt", monsterRegistry);
        loadQuests("src/guild/quests.txt", guild, monsterRegistry);
        guild.assignQuest();
    }
    /**
     * Loads adventurers from a file and adds them to the guild.
     *
     * @param file the file containing adventurer data
     * @param guild the guild to add adventurers to
     */
    public static void loadAdventurers(String file, Guild guild) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int health = Integer.parseInt(parts[1]);
                int basePower = Integer.parseInt(parts[2]);

                Adventurer adventurer = new Adventurer(name, basePower, health);
                guild.addAdventurer(adventurer);
            }
        } catch (IOException e) {
            System.err.println("Error reading adventurers file: " + e.getMessage());
        }
    }

    /**
     * Loads monsters from a file and stores them in the monster registry.
     *
     * @param file the file containing monster data
     * @param monsterRegistry the registry to store monsters
     */
    public static void loadMonsters(String file, Map<String, Monster> monsterRegistry) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int health = Integer.parseInt(parts[1]);
                int attack = Integer.parseInt(parts[2]);

                Monster monster = new Monster(name, attack, health, 0); // Assuming armor is 0
                monsterRegistry.put(name, monster);
            }
        } catch (IOException e) {
            System.err.println("Error reading monsters file: " + e.getMessage());
        }
    }

    /**
     * Loads quests from a file and adds them to the guild.
     *
     * @param file the file containing quest data
     * @param guild the guild to add quests to
     * @param monsterRegistry the registry to retrieve monsters from
     */
    public static void loadQuests(String file, Guild guild, Map<String, Monster> monsterRegistry) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int difficulty = Integer.parseInt(parts[1]);
                String[] monsterNames = parts[2].split("-");

                List<Monster> monsters = new ArrayList<>();
                for (String monsterName : monsterNames) {
                    Monster monster = monsterRegistry.get(monsterName);
                    if (monster != null) {
                        // Create a new instance of the monster for the quest
                        monsters.add(new Monster(monster.getName(), monster.getAttackPower(), monster.getHealth(), monster.getArmor()));
                    } else {
                        System.err.println("Unknown monster: " + monsterName);
                    }
                }

                Quest quest = new Quest(name, difficulty, monsters);
                guild.addQuest(quest);
            }
        } catch (IOException e) {
            System.err.println("Error reading quests file: " + e.getMessage());
        }
    }
}