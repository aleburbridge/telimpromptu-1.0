package com.example.telimprompturevised;

import com.example.telimprompturevised.Roles.Concrete.*;
import com.example.telimprompturevised.Roles.Role;

import java.util.*;

public class GameInfo {

    private static GameInfo instance = null;
    private final List<Player> players = new ArrayList<Player>();
    private final List<Role> roles;
    private List<Prompt> assignedPrompts = new ArrayList<Prompt>();
    private Player host = null;
    private boolean isGameStartedByHost = false;
    private PromptInfo promptInfo;
    private String story = null;
    private int sequence = 0;
    private int responsesReceived = 0;
    private int numberOfPlayersNeededToStartGame = 5;
    private ScriptGenerator scriptGenerator = new ScriptGenerator();
    private String expertTitle = "";
    private String expertField = "";
    private String question_1;
    private String question_2;
    private String question_3;
    private String witnessVoice = "";

    public GameInfo(final List<Role> roles) {
        this.roles = List.copyOf(roles);
        this.promptInfo = new PromptInfo();
    }

    // new FieldReporter(),
    public static GameInfo getInstance() {
        if (instance == null) {
            instance = new GameInfo(List.of(new Host(), new CoHost(), new Detective(), new Witness(), new GuestExpert()));
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getNumberOfPlayersNeededToStartGame() {
        return numberOfPlayersNeededToStartGame - getNumJoined();
    }

    public Player getPlayerByUserId(String userId) {
        for (Player player : players) {
            if (player.getUserId().equals(userId)) {
                return player;
            }
        }
        return null;
    }

    public void setHost(Player player) {
        host = player;
    }

    public boolean checkIfPlayerIsHost(String userId) {
        if (host == null) {
            return false;
        }
        return Objects.equals(host.getUserId(), userId);
    }

    public void assignRoles() {
        if (players.get(0).getRole() == null) {
            Collections.shuffle(players);
            for (int i = 0; i < players.size(); i++) {
                Role role = roles.get(i);
                Player player = players.get(i);

                player.setRole(role);
            }
        } else {
            System.out.println("GameInfo.assignRoles() attempted when roles are already assigned.");
        }
    }

    public void assignPromptsBySequenceNum(int sequenceNum) {
        List<Prompt> currentPrompts = new ArrayList<Prompt>();
        if (sequenceNum == 1) {
            currentPrompts = promptInfo.getFirstPrompts();
        } else if (sequenceNum == 2) {
            currentPrompts = promptInfo.getSecondPrompts();
        } else if (sequenceNum == 3) {
            currentPrompts = promptInfo.getThirdPrompts();
        }

        Collections.shuffle(currentPrompts);

        for (Player player : players) {
            int i = 0;

            while (player.getPromptBySequenceNum(sequenceNum) == null) {
                if (i == 6) {
                    assignedPrompts.clear();
                    for (Player assignedPlayer : players) {
                        assignedPlayer.setPromptBySequenceNum(sequenceNum, null);
                    }
                    assignPromptsBySequenceNum(sequenceNum);
                    break;
                }

                Prompt prompt = currentPrompts.get(i);
                if (!prompt.getRoleTitle().equals(player.getRoleTitle()) && !assignedPrompts.contains(prompt)) {
                    player.setPromptBySequenceNum(sequenceNum, prompt);
                    assignedPrompts.add(prompt);
                }
                i++;
            }
        }
    }

    public void assignAllPrompts() {
        assignPromptsBySequenceNum(1);
        assignPromptsBySequenceNum(2);
        assignPromptsBySequenceNum(3);
    }

    public Player getPlayerByRoleTitle(String roleTitle) {
        for (Player player : players) {
            if (player.getRoleTitle() == roleTitle) {
                return player;
            }
        }
        return null;
    }

    public void setExpertTitleAndField(String expertTitle, String expertField) {
        this.expertTitle = expertTitle;
        this.expertField = expertField;
    }

    public void setHostQuestions(String question_1, String question_2, String question_3) {
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
    }

    public void nextRoundCheck() {
        if (responsesReceived == numberOfPlayersNeededToStartGame) {
            incrementSequence();
            setResponsesReceived(0);
        }
    }

    // fieldReporter
    public String generateText() {
        Player newsHost = getPlayerByRoleTitle("Host");
        Player coHost = getPlayerByRoleTitle("CoHost");
        Player detective = getPlayerByRoleTitle("Detective");
        Player fieldReporter = getPlayerByRoleTitle("Field Reporter");
        Player guestExpert = getPlayerByRoleTitle("Guest Expert");
        Player witness = getPlayerByRoleTitle("Witness");
        return scriptGenerator.generateText(newsHost, coHost, detective, guestExpert, witness, expertTitle, expertField, question_1, question_2, question_3, story);
    }


    // Default getters and setters below this line

    public List<Player> getPlayers() {
        return players;
    }

    public int getNumJoined() {
        return players.size();
    }

    public boolean isGameStartedByHost() {
        return isGameStartedByHost;
    }

    public void setIsGameStartedByHost(boolean gameStartedByHost) {
        isGameStartedByHost = gameStartedByHost;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getSequence() {
        return sequence;
    }

    public void incrementSequence() {
        this.sequence = ++sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getResponsesReceived() {
        return responsesReceived;
    }

    public void setResponsesReceived(int responsesReceived) {
        this.responsesReceived = responsesReceived;
    }

    public void incrementResponsesReceived() {
        this.responsesReceived = ++responsesReceived;
    }

    public String getExpertTitle() {
        return expertTitle;
    }

    public String getExpertField() {
        return expertField;
    }

    public String getWitnessVoice() {
        return witnessVoice;
    }

    public void setWitnessVoice(String witnessVoice) {
        this.witnessVoice = witnessVoice;
    }
}
