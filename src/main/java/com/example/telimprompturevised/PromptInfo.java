package com.example.telimprompturevised;

import java.util.ArrayList;
import java.util.List;

public class PromptInfo {
    private List<Prompt> prompts = new ArrayList<Prompt>();
    private List<Prompt> firstPrompts = new ArrayList<Prompt>();
    private List<Prompt> secondPrompts = new ArrayList<Prompt>();
    private List<Prompt> thirdPrompts = new ArrayList<Prompt>();
    private String story = "(Story)";

    public PromptInfo() {

    // Host prompts
    prompts.add(new Prompt(
            "Host", 1, 1,
            "Write 1+ sentences for the opening remarks of the story.\n" +
            "'Good evening, you’re watching Telimpromptu News. Our leading story tonight, (Story). Here’s what we know so far: (Your Text Here)'"
    ));
    prompts.add(new Prompt(
            "Host", 2, 3,
                "Write 3 questions for the host to ask the guest expert. The guest expert will say yes to the first two questions and refuse to answer the third."
    ));
    prompts.add(new Prompt(
            "Host", 3, 1,
            "Write 1+ sentences for the closing remarks of the story. Context: 'Well, there you have it folks. A story like this you only see once in a lifetime. (Your text here)"
    ));

    // CoHost prompts
    prompts.add(new Prompt(
            "CoHost", 1, 1,
            "Write 1+ sentences for the CoHost's opening remarks on the story (Following the Host's Opening remarks). Context: 'That's right, not only that but we are being told (Your text here)'"
    ));
    prompts.add(new Prompt(
            "CoHost", 2, 1,
            "Write a question for the CoHost to ask the field reporter at the end of the segment that the field reporter will say no to."
    ));
    prompts.add(new Prompt(
            "CoHost", 3, 1,
            "Write a fake statistic for the CoHost to present. Context: 'Perhaps this story shouldn't be all that surprising given that (Your text here)'"
    ));

    // Detective prompts
    prompts.add(new Prompt(
            "Detective", 1, 1,
            "Write a discovery for the detective to present. Context: 'Well, the situation is worse than we thought. My team has just discovered that (Your text here)."
    ));
    prompts.add(new Prompt(
            "Detective", 2, 1,
            "Write a discovery for the detective to present. Context: 'It gets worse, in all my years as a detective never before have I seen (your text here)"
    ));
    prompts.add(new Prompt(
            "Detective", 3, 1,
            "The detective will present a note that was discovered at the scene. Write what the note says."
    ));
/*
    // Field Reporter prompts
    prompts.add(new Prompt(
            "Field Reporter", 1, 1,
            "Write 1+ sentences on what the field reporter sees at the scene of the incident"
    ));
    prompts.add(new Prompt(
            "Field Reporter", 2, 1,
            "Write a quote for the field reporter to present on something said by a witness who saw the incident firsthand"
    ));
    prompts.add(new Prompt(
            "Field Reporter", 3, 1,
            "Write a message for the field reporter to give to the families at home."
    ));


 */
    // Guest Expert prompts
    prompts.add(new Prompt(
            "Guest Expert", 1, 2,
            "Write the guest expert's title and professional field."
    ));
    prompts.add(new Prompt(
            "Guest Expert", 2, 1,
            "Write a detail for the guest expert to present that they will have to demonstrate themself."
    ));
    prompts.add(new Prompt(
            "Guest Expert", 3, 1,
            "Write the oath that the guest expert had to swear upon entering his field."
    ));

    // Witness
    prompts.add(new Prompt(
            "Witness", 1, 1,
            "Write a silly voice for the witness to talk in, it should be a voice that the person reading can do. Ex. 'British', 'Mickey Mouse' The prompt will show up as: '(in a your_text_here voice)'"
    ));
    prompts.add(new Prompt(
            "Witness", 2, 1,
            "Write the first half of a firsthand account of the scene in as many words as you like."
    ));
    prompts.add(new Prompt(
            "Witness", 3, 1,
            "Write the second half of a firsthand account of the scene in as many words as you like."
    ));

    addPromptsToListsBySequence();
    }

    public List<Prompt> getPrompts() {
        return prompts;
    }

    private void addPromptsToListsBySequence() {
        for (Prompt prompt : prompts) {
            if (prompt.getSequenceNum() == 1) {
                if (firstPrompts.size() < 6 ) {
                    firstPrompts.add(prompt);
                }
            } else if (prompt.getSequenceNum() == 2) {
                if (secondPrompts.size() < 6 ) {
                    secondPrompts.add(prompt);
                }
            } else if (prompt.getSequenceNum() == 3) {
                if (thirdPrompts.size() < 6) {
                    thirdPrompts.add(prompt);
                }
            }
        }
    }

    public List<Prompt> getFirstPrompts() {
        return firstPrompts;
    }

    public List<Prompt> getSecondPrompts() {
        return secondPrompts;
    }

    public List<Prompt> getThirdPrompts() {
        return thirdPrompts;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
