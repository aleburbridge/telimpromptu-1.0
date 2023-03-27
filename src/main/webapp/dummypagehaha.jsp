<%@ page import="com.example.telimprompturevised.GameInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="scroll-container">
    <button id="pause-button" onclick="togglePause()">Pause</button>
    <div id="scroll-text">
        Caster 1: Good evening, you’re watching Telimpromptu News, I’m your host {caster_1name}. Our leading story tonight {Story}. Here’s what we know so far: {portion 1}.
        Caster 2: That’s right {caster_1_name}, not only that but we are also being told {portion 1}. We go now to Field Reporter {field_reporter_name}. {field_reporter_name}, thank you for joining us.

        Field Reporter: Thank you { _caster_2_name}.
        Caster 2: {Field_reporter_name}, what’s going on at the scene of the incident?
        Field Reporter: Well, { _caster_2_name}, {prompt_1}
        Caster 2: Anything else, {Field_report_name}?
        Field Reporter: Yes, we have a quote from a witness who saw the incident firsthand. Quote, {field_reporter_special_prompt}.
        Caster 2: {Field_reporter_name}, do you have a message for the families at home?
        Field Reporter: Yes, {prompt_3}
        Caster 2: That’s field reporter {Field_reporter_name}.{Field_reporter_name}, Thank you.
        Field Reporter: Thank you.

        Caster 1: Joining us now is our guest expert, {Expert_name} who has a PhD and 20 years experience in {expert_field}. {Expert_name}, thank you for joining us.
        Guest Expert: Thank you for having me on, { _caster_1_name}.
        Caster 1: {Expert_name}, it’s my understanding that {question_1}. Is that correct?
        Guest Expert: Absolutely, { _caster_2_name}. (Improvise)
        Caster 1: Astounding, so what you’re saying is {question_2}?
        Guest Expert: { _caster_2_name}, what I can tell you is this–(Improvise). And here I might add a relevant detail to the case., {guest_expert_special prompt}, as I will now demonstrate. (Demonstrates)
        Caster 1: Remarkable.
        Guest Expert: Remarkable to some, but you’re a {expert_title} like me, you see this kind of thing most every day.
        Caster 2: {Expert_name}, final question: {question_3}
        Guest Expert: I’m sorry { _caster_2_name}, I cannot answer that question. When I became a {expert_title} I swore a particular and solemn oath. That oath is this. (Places hand on heart) {prompt 3}
        Caster 2: Well, {Expert_name}, that was really something. Thank you for your time
        Guest Expert: Thank you.

        Cohost: That was {expert_name}, expert {expert_title}. Turning back to the scene of the incident where I’m being told reporters have managed to get a few words with a witness who saw the event.
        Witness: {Prompt 1} {Prompt 2}

        Host: This just in, it seems like we’ve managed to get a few words from Detective {detective_name} who is live on the scene. Detective, what can you share with us?
        Host: Well, {host}, the situation is worse than we thought, my team has just discovered {prompt 1}.
        Host: That is just terrible.
        Detective: It gets worse, {cohost}, in all my years as a detective never before have I seen {prompt 2}.
        Host: Well detective, do you have any clues as to why this happened?
        Detective: Indeed I do. A note was discovered at the scene of the incident, it reads: {prompt 3}.
        Host: Detective, thank you for your time. Well, {Cohost}, you can’t come up with this stuff

        Cohost: That’s true {host}, but perhaps this story shouldn’t be all that surprising given that {prompt 3}
        Host: Thank you for shedding some light on the facts, {cohost}. Well folks, that’s all the time we have for tonight. Goodbye.

        the event.
        Witness: {Prompt 1} {Prompt 2}

        Host: This just in, it seems like we’ve managed to get a few words from Detective {detective_name} who is live on the scene. Detective, what can you share with us?
        Host: Well, {host}, the situation is worse than we thought, my team has just discovered {prompt 1}.
        Host: That is just terrible.
        Detective: It gets worse, {cohost}, in all my years as a detective never before have I seen {prompt 2}.
        Host: Well detective, do you have any clues as to why this happened?
        Detective: Indeed I do. A note was discovered at the scene of the incident, it reads: {prompt 3}.
        Host: Detective, thank you for your time. Well, {Cohost}, you can’t come up with this stuff

        Cohost: That’s true {host}, but perhaps this story shouldn’t be all that surprising given that {prompt 3}
        Host: Thank you for shedding some light on the facts, {cohost}. Well folks, that’s all the time we have for tonight. Goodbye.




    </div>
</div>
<script>
    let scrollAmount = 0;
    let isPaused = false;
    const scrollStep = 3;
    const delay = 50;

    function startScrolling() {
        const contentHeight = document.body.scrollHeight;
        const viewportHeight = window.innerHeight;
        if (!isPaused && scrollAmount < contentHeight - viewportHeight) {
            window.scrollBy(0, scrollStep);
            scrollAmount += scrollStep;
            setTimeout(startScrolling, delay);
        }
    }

    function togglePause() {
        if (isPaused) {
            // if paused, resume scrolling
            intervalId = setInterval(scrollText, 50);
            document.getElementById("pause-button").innerHTML = "Pause";
        } else {
            // if not paused, stop scrolling
            clearInterval(intervalId);
            document.getElementById("pause-button").innerHTML = "Resume";
        }
        // toggle the paused state
        isPaused = !isPaused;
    }

    startScrolling();
</script>
</body>
</html>
