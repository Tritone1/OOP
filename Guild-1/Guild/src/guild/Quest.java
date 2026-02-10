package guild;

import java.util.List;

/**
 * Represents a quest with monsters to defeat.
 * 
 * @author Kanan
 */

public class Quest {
    private String name;
    private int difficulty;
    private List<Monster> monsters;
    private boolean isCompleted;

    /**
     * Constructs a new Quest with the specified attributes.
     *
     * @param name the name of the quest
     * @param difficulty the difficulty level of the quest
     * @param monsters the list of monsters in the quest
     */



    public Quest(String name, int difficulty, List<Monster> monsters) {
        this.name = name;
        this.difficulty = difficulty;
        this.monsters = monsters;
        this.isCompleted = false;
    }

    /**
     * Starts the quest for the given adventurer.
     * The adventurer fights the monsters in the quest until either the adventurer or all monsters are defeated.
     *
     * @param adventurer the adventurer starting the quest
     */

    public void startQuest(Adventurer adventurer) {
        for (Monster monster : monsters) {
            while (!monster.isDefeated() && !adventurer.isDefeated()) {
                adventurer.attackMonster(monster);
                if (!monster.isDefeated()) {
                    adventurer.takeDamage(monster.getAttackPower());
                }
            }
            if (adventurer.isDefeated()) {
                System.out.println(adventurer + " failed the quest!");
                return;
            } else {
                adventurer.gainExperience(monster.getAttackPower());
            }
        }
        isCompleted = true;
        System.out.println(adventurer + " completed the quest!");
    }



    /**
     * Checks if the quest is completed.
     *
     * @return true if the quest is completed, false otherwise
     */
    public boolean isCompleted() {
        return isCompleted;
    }


    /**
     * Gets the name of the quest.
     *
     * @return the name of the quest
     */

    public String getName() {
        return name;
    }

    /**
     * Gets the difficulty level of the quest.
     *
     * @return the difficulty level of the quest
     */


    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the list of monsters in the quest.
     *
     * @return the list of monsters in the quest
     */

    public List<Monster> getMonsters() {
        return monsters;
    }
    


    /**
     * Gets the name of the quest.
     *
     * @return the name of the quest
     */

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", monsters=" + monsters +
                ", isCompleted=" + isCompleted +
                '}';
    }
}