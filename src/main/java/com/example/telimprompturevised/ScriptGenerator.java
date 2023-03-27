package com.example.telimprompturevised;

public class ScriptGenerator {
    String fullText;

    public ScriptGenerator() {
        // this.fullText = generateText();
    }

    //Player fieldReporter,
    public String generateText(Player host, Player coHost, Player detective, Player guestExpert, Player witness, String expertTitle, String expertField, String question_1, String question_2, String question_3, String story) {
        String hostFirstName = "<span style='color:yellow'> " + host.getUserName() + "</span>";
        String hostFullName = "<span style='color:yellow'> " + host.getFullName() + "</span>";
        String coHostFirstName = "<span style='color:cyan'> " + coHost.getUserName() + "</span>";
        String coHostFullName = "<span style='color:cyan'> " + coHost.getFullName() + "</span>";
        String detectiveFirstName = "<span style='color:orange'> " + detective.getUserName() + "</span>";
        String detectiveFullName = "<br> <span style='color:orange'> " + detective.getFullName() + "</span>";
        //String fieldReporterFirstName = "<br> <span style='color:green'> " + fieldReporter.getUserName() + "</span>";
        //String fieldReporterFullName = "<br> <span style='color:green'> " + fieldReporter.getFullName() + "</span>";
        String guestExpertFirstName = "<br> <span style='color:red'> " + guestExpert.getUserName() + "</span>";
        String guestExpertFullName = "<br> <span style='color:red'> " + guestExpert.getFullName() + "</span>";
        String witnessFirstName = "<br> <span style='color:purple'> " + witness.getUserName() + "</span>";
        String witnessFullName = "<br> <span style='color:purple'> " + witness.getFullName() + "</span>";

        String completedText = hostFirstName + ": Good evening, you’re watching Telimpromptu News. I’m your host, " + hostFullName + "\n\n\n" +

                coHostFirstName + ": I'm " + coHostFullName + "\n\n\n" +

                hostFirstName + ": Our leading story tonight: " + story + ". Here’s what we know so far: " + host.getFirstPartScript() + ".\n\n\n\n" +

                coHostFirstName + ": That's right, " + hostFirstName + ". We are also being told " + coHost.getFirstPartScript() + "\n\n\n" +

                /*
                 + "We go now to Field Reporter " + fieldReporterFullName + ". " + fieldReporterFirstName + ", thank you for joining us.\n\n" +

                fieldReporterFirstName + ": Thank you, " + coHostFirstName + ".\n" +

                coHostFirstName + ": What’s going on at the scene of the incident?\n" +

                fieldReporterFirstName + ": " + "Well, " + fieldReporter.getFirstPartScript() + "\n\n" +

                coHostFirstName + ": Anything else?\n" +

                fieldReporterFirstName + ": Yes, we have a quote from a witness who saw the incident firsthand. Quote, '" + fieldReporter.getSecondPartScript() + "'.\n\n" +

                coHostFirstName + ": One last thing, " + fieldReporterFirstName + ". Do you have a message for the families at home?\n" +

                fieldReporterFirstName + ": Yes, " + fieldReporter.getThirdPartScript() + ".\n\n" +

                coHostFirstName + ":  That’s field reporter " + fieldReporterFullName + "." + fieldReporterFirstName + ", Thank you.\n" +

                fieldReporterFirstName + ": Thank you.\n" +
                 */


                hostFirstName + ": Joining us now is our guest expert, " + guestExpertFullName + ", who has a PhD in " + expertField + "." + guestExpertFirstName + ", thank you for joining us.\n\n\n" +

                guestExpertFirstName + ": Thank you for having me on.\n\n\n" +

                hostFirstName + ": " + guestExpertFirstName + "First question, " + question_1 + "?\n\n\n" +

                guestExpertFirstName + ": Absolutely, " + hostFirstName + ". \n\n\n\n(Improvise)\n\n\n\n\n\n" +

               hostFirstName + ": " + question_2 + "?\n" +

                guestExpertFirstName + ": Yes.\nAnd here I should add a relevant detail to the case: " + guestExpert.getSecondPartScript() + ", as I will now demonstrate.\n\n\n\n(Demonstrates)\n\n\n\n\n\n\n\n\n\n" +

                hostFirstName + ": Remarkable.\n\n\n\n" +

                guestExpertFirstName + ": Perhaps to some, but when you’re a " + expertTitle + " like me, you see this kind of thing most every day.\n\n\n" +

               hostFirstName + ": Final question: " + question_3 + "?\n\n\n" +

                guestExpertFirstName + ": I’m sorry " + hostFirstName + ", I cannot answer that question. When I became a " + expertTitle + ", I swore a particular and solemn oath. That oath is this.\n\n(Places hand on heart)\n\n\n\n" + guestExpert.getThirdPartScript() + "\n\n\n\n\n" +

                hostFirstName + ": Well, that was really something. Thank you for your time\n\n\n\n" +

                guestExpertFirstName + ": Thank you.\n\n\n\n\n\n" +

                coHostFirstName + ": Turning back now to the scene of the incident where I’m being told reporters have managed to get a few words with a witness who saw the event.\n\n\n\n\n" +

                witnessFirstName + "(In a " + witness.getFirstPartScript() + " voice)\n\n\n\n" + witness.getSecondPartScript() + "\n\n\n\n" + witness.getThirdPartScript() + ".\n\n\n\n\n" +

                hostFirstName + ": Enlightening. \nThis just in, I'm getting word that we've managed to get an exclusive interview with Detective " + detectiveFirstName + " who is live on the scene. Detective, what can you share with us?\n\n\n\n" +

                detectiveFirstName + ": Well, the situation is worse than we thought, my team has just discovered " + detective.getFirstPartScript() + ".\n\n\n\n\n" +

                hostFirstName + ": Horrific.\n\n\n\n" +

                detectiveFirstName + ": It gets worse. In all my years as a detective never before have I seen " + detective.getSecondPartScript() + "\n\n\n\n\n" +

                hostFirstName + ": Well detective, do you have any clues as to why this happened?\n\n\n" +

                detectiveFirstName + ": Indeed I do. A note was discovered at the scene of the incident, it reads: " + detective.getThirdPartScript() + "\n\n\n" +

                hostFirstName + ": Detective, thank you for your time. Well, " + host.getThirdPartScript() + "." + coHostFirstName + ", it's an unbelievable story isn't it?\n\n\n" +

                coHostFirstName + ": Yes it is, but perhaps today's events shouldn’t be all that surprising given that " + coHost.getThirdPartScript() + "\n\n\n" +

                hostFirstName + ": Thank you for shedding some light on the facts, " + coHostFirstName + ". Well folks, that’s all the time we have for tonight. Goodbye. \n"

                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

        return completedText.replace("\n", "<br>");
    }
}
