import com.example.telimprompturevised.GameInfo;
import com.example.telimprompturevised.Player;
import com.example.telimprompturevised.Prompt;
import com.example.telimprompturevised.Roles.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameInfoTest {
    private GameInfo gameInfo;

    @BeforeEach
    private void gameInfoUnderTest() {
        gameInfo = GameInfo.getInstance();
        gameInfo.destroyInstance();
        gameInfo = GameInfo.getInstance();
    }


    @Test
    void createNewGameInfoObject_existingGameInfoSetToNull_returnsSameInstance(){
        gameInfo.addPlayer(new Player("Bob", "fakeUserId"));
        gameInfo = null;

        // Will point back to previous instance of gameInfo
        // Need to destroy previous instance to reset game state
        GameInfo newGameInfo = GameInfo.getInstance();

        assertEquals(newGameInfo.getPlayers().size(), 1);
    }

    @Test
    void createNewGameInfoObject_gameInfoInstanceDeleted_returnsNewInstance(){
        gameInfo.addPlayer(new Player("Bob", "fakeUserId"));

        GameInfo newGameInfo = GameInfo.getInstance();
        newGameInfo.destroyInstance();

        newGameInfo = GameInfo.getInstance();
        assertEquals(newGameInfo.getPlayers().size(), 0);
        assertEquals(newGameInfo.getNumJoined(), 0);
    }

    @Test
    void assignRoles_with6Players_assignsEachPlayerARole() {
        gameInfo.addPlayer(new Player("PlayerOne", "abc"));
        gameInfo.addPlayer(new Player("PlayerTwo", "def"));
        gameInfo.addPlayer(new Player("PlayerThree", "ghi"));
        gameInfo.addPlayer(new Player("PlayerFour", "jkl"));
        gameInfo.addPlayer(new Player("PlayerFive", "mno"));
        gameInfo.addPlayer(new Player("PlayerSix", "pqr"));

        gameInfo.assignRoles();
        HashSet<Role> assignedRoles = new HashSet<>();

        for (Player player : gameInfo.getPlayers()) {
            assertNotNull(player.getRole());
            assignedRoles.add(player.getRole());
        }
        assertEquals(assignedRoles.size(), 6);
    }

    @Test
    void assignRoles_rolesAlreadyAssigned_keepsAssignedRoles() {
        gameInfo.addPlayer(new Player("PlayerOne", "abc"));
        gameInfo.addPlayer(new Player("PlayerTwo", "def"));
        gameInfo.addPlayer(new Player("PlayerThree", "ghi"));
        gameInfo.addPlayer(new Player("PlayerFour", "jkl"));
        gameInfo.addPlayer(new Player("PlayerFive", "mno"));
        gameInfo.addPlayer(new Player("PlayerSix", "pqr"));

        gameInfo.assignRoles();
        List<Role> assignedRoles = new ArrayList<Role>();
        for (Player player : gameInfo.getPlayers()) {
            assignedRoles.add(player.getRole());
        }
        gameInfo.assignRoles();

        int i = 0;
        for (Player player : gameInfo.getPlayers()) {
            assertEquals(player.getRole(), assignedRoles.get(i));
            i++;
        }
    }

    /*
    @Test
    void assignPrompts_noPromptsAssigned_playerFirstPromptIsNotNull() {
        Player player = new Player("PlayerOne", "abc");
        gameInfo.addPlayer(player);
        gameInfo.assignRoles();
        gameInfo.assignPromptsToPlayers();

        assertFalse(player.getFirstPrompt() == null);
    }

     */

    @Test
    void assignPrompts_EveryoneGetsAPrompt() {
        gameInfo.addPlayer(new Player("PlayerOne", "abc"));
        gameInfo.addPlayer(new Player("PlayerTwo", "def"));
        gameInfo.addPlayer(new Player("PlayerThree", "ghi"));
        gameInfo.addPlayer(new Player("PlayerFour", "jkl"));
        gameInfo.addPlayer(new Player("PlayerFive", "mno"));
        gameInfo.addPlayer(new Player("PlayerSix", "pqr"));

        gameInfo.assignRoles();
        gameInfo.assignAllPrompts();
    }

    @Test
    void incrementSequence_DoesIt() {
        gameInfo.incrementSequence();

        assertTrue(gameInfo.getSequence() == 1);
    }

    @Test
    void assignPrompts_everyPromptIsUnique() {
        gameInfo.addPlayer(new Player("PlayerOne", "abc"));
        gameInfo.addPlayer(new Player("PlayerTwo", "def"));
        gameInfo.addPlayer(new Player("PlayerThree", "ghi"));
        gameInfo.addPlayer(new Player("PlayerFour", "jkl"));
        gameInfo.addPlayer(new Player("PlayerFive", "mno"));
        gameInfo.addPlayer(new Player("PlayerSix", "pqr"));

        gameInfo.assignRoles();
        gameInfo.assignAllPrompts();

        List<Prompt> seen = new ArrayList<Prompt>();
        for (int i=1; i<=3; i++) {
            for (Player player : gameInfo.getPlayers()) {
                if (seen.contains(player.getPromptBySequenceNum(i))) {
                    assertEquals(1,2, "i is " + i);
                }
                seen.add(player.getPromptBySequenceNum(i));
            }
        }

    }
}
