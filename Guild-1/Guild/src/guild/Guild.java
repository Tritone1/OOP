package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a guild that manages adventurers and quests.
 * The guild maintains a list of adventurers and quests, allowing quests to be assigned to adventurers.
 * 
 * @author Kanan
 */


 
public class Guild {
    public List<Adventurer> adventurers; 
    public List<Quest> quests; 

    /**
     * Constructs a new Guild with empty lists of adventurers and quests.
     *
     * @param adventurers the list of adventurers in the guild
     * @param quests the list of quests in the guild
     */
    public Guild() {
        this.adventurers = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    /**
     * Adds a new adventurer to the guild.
     *
     * @param adventurer the adventurer to add to the guild
     */
    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    /**
     * Adds a new quest to the guild's quest board.
     *
     * @param quest the quest to add to the guild
     */
    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    /**
     * Assigns random adventurers to quests and starts the quests.
     * Each quest is assigned to a random adventurer from the guild's list of adventurers.
     */
    public void assignQuest() {
        Random random = new Random();
        for (Quest quest : quests) {
            Adventurer adventurer = adventurers.get(random.nextInt(adventurers.size()));
            System.out.println(adventurer + " has been assigned to the quest: " + quest);

            quest.startQuest(adventurer);
            if (quest.isCompleted()) {
                System.out.println(adventurer + " has completed the quest: " + quest);
            } else {
                System.out.println(adventurer + " has failed the quest: " + quest);
            }
            
        }
    }
}