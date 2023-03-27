import com.example.telimprompturevised.GameInfo;
import com.example.telimprompturevised.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {
    private GameInfo gameInfo;

    @BeforeEach
    private void gameInfoUnderTest() {
        gameInfo = GameInfo.getInstance();
        gameInfo.destroyInstance();
        gameInfo = GameInfo.getInstance();
    }

    @Test
    void assignPlayerToHost_gameHasOnePlayers_setsPlayerToHost() {
        Player player = new Player("Bob", "fakeid");

        gameInfo.addPlayer(player);
        gameInfo.setHost(player);

        assertTrue(gameInfo.checkIfPlayerIsHost(player.getUserId()));
    }

    @Test
    void assignPlayerToHost_gameHasPlayers_setsPlayerToHost() {
        Player player = new Player("Bob", "fakeid");
        Player playerTwo = new Player("Alice", "anotherfakeid");

        gameInfo.addPlayer(player);
        gameInfo.addPlayer(playerTwo);

        gameInfo.setHost(player);
        assertFalse(gameInfo.checkIfPlayerIsHost(playerTwo.getUserId()));
    }
}
