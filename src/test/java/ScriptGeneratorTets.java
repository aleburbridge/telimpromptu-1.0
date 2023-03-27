import com.example.telimprompturevised.GameInfo;
import com.example.telimprompturevised.Player;
import com.example.telimprompturevised.Prompt;
import com.example.telimprompturevised.ScriptGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScriptGeneratorTets {
    private GameInfo gameInfo;
    private ScriptGenerator scriptGenerator;

    @BeforeEach
    private void gameInfoUnderTest() {
        gameInfo = GameInfo.getInstance();
        gameInfo.destroyInstance();
        gameInfo = GameInfo.getInstance();
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
        List<Player> players = gameInfo.getPlayers();

        for (Player player : players) {
            player.setFirstPartScript("First Part");
            player.setSecondPartScript("Second Part");
            player.setThirdPartScript("Third Part");
        }

        scriptGenerator.generateText(players.get(0), players.get(1), players.get(2), players.get(4), players.get(5), "Snailologist", "Snailology", "Why God?", "Why oh Why?", "Why me?", "Lots");

    }
}
