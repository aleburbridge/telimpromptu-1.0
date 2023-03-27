# [Team name] Reflection

## Instructions

1. *Create a new folder within this current folder, and name the new folder
   after your team name*
2. *If you prefer keeping this reflection private to your team, you may change
   the permissions on your folder so that only your teammates + unit instructors
   can view the contents*
3. *Create a copy of this reflection template, and put it in your newly created
   folder *

*Please answer at least one question from each section below. Answers here will
likely be inspiration for the “lessons learned” section of your project
presentation at the end of the unit.*

## Design

* How closely did you follow your design document after the review was complete?
Did your implementation need to change based on what you learned once you were
underway? 

I mostly strayed away from the GameInfo and Player classes that I outlined in the class diagram. As the project grew in scope, I realized that my Player and Prompt classes were individually holding too much information that should be handled by the GameInfo class. Also, I ended up using a Role interface instead of an Abstract class for the inheritance of my Role objects, but still utilized the AbstractClass shared methods feature by implementing a RoleCommon class from which the other roles can pull methods 

## Project

* How did you handle the ambiguity of defining your own project and user
  stories? What strategies did you use to decide on concrete work to do to
  satisfy your requirements?

I first came up with a general idea of the project and then I decided on the technologies I would use to achieve it (Tomcat, JSP, etc). Working within the constraints of those technologies helped to narrow the deisgn of the project. 

* How did you deal with getting stuck on a problem? What strategies did you
  employ to get yourself unblocked?

I would refer back to the current sprint and past sprint material. 

* Did any of your commitments you made in your team charter help navigate a
  difficult decision, situation, or collaboration challenge? How?

No

## Scrum

* What did you find to be the most valuable part of daily stand-ups? Is there
  anything you would want to do differently at stand-up to make it more useful
  to you?

Daily stand-up functioned as a daily review on and goal-setting process for me. It helped me to stay on track and have clearly defined goals for each day. 

* Did you over or underestimate the work you could complete during your sprints?
  What have you learned that will help you better estimate work next time?

I overestimated the work with the front-end and underestimated the work with the backend. I learned to allow a large time window when dealing with new technologies and unfamiliar concepts. 

## Looking ahead

* If you were to start this unit over again, what would you do differently? How
  do you see yourself applying that to your work in later units, the capstone,
  or your internship?

I would spend more time in the planning phase to prevent an entire project rewrite. I see this lesson applying to all projects I do in the future. 