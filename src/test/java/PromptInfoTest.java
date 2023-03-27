import com.example.telimprompturevised.Prompt;
import com.example.telimprompturevised.PromptInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PromptInfoTest {
    private PromptInfo promptInfo;

    @BeforeEach
    private void promptInfoUnderTest() {
        promptInfo = new PromptInfo();
    }

    @Test
    void addPromptToListBySequence_listAlreadyPopulated_DoesNotChangeList() {
        assertTrue(promptInfo.getFirstPrompts().size() == 6);
        List<Prompt> seen = new ArrayList<Prompt>();
        for (Prompt prompt : promptInfo.getFirstPrompts()) {
            if (seen.contains(prompt)) {
                assertFalse(true);
            }
        }
    }
}
