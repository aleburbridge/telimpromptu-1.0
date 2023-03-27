# Alexander Bridgeman Design Document

## Telimpromptu Design

## 1. Problem Statement

The teleprompter game works by having players respond to prompts that will be read off of teleprompter-style scrolling text. Players could manually set up the game,but it would be very time consuming. This application handles the setup and flow of the game. 


## 2. Top Questions to Resolve in Review

1.   How can an AWS Lambda function/DynamoDB table be incorporated?
           ideas: Store final game state for later reference, store all user input and reference for current game, store a scoreboard 
2.   How should the waiting room area update? 
           Timeout? Called by a servlet? Users refresh page?
3.   How should the final text be presented? 
           Possible to paste string to a website that generates a teleprompter interface

## 3. Use Cases

U1. As a Telimpromptu player, I want to be able to type at the same time as other players when I enter my answers to the prompts

U2. As a Telimpromptu player, I want to be able to see the name of the player who will be reading what I type
    
U3. As a Telimpromptu player, I want to be able to use a scoring system to compete with other players

## 4. Project Scope



### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?*
Users will be able to connect to a local host of the game and run the game in their browser on separate devices. Users will enter a lobby by inputting their name. Users will have roles assigned to them and be given prompts to answer. Users will be able to vote for best prompt and best performance.

### 4.2. Out of Scope

There will be no user authentication or password service. There will be no option to play the game on separate networks. There will be no option to change your name or leave the lobby once you have joined. 

# 5. Proposed Architecture Overview



[Class Diagrams](class_diagram.puml)

1. The front-end of the application will be handled by JSP 

    -JSP allows for easy presentation of Java variables


2. The local server will be handled by Apache Tomcat 

    -This will allow for the connection of multiple devices


3. Post and get requests will be handled by servlets: ReadyServlet, LoginServlet, StartGameServlet 
4. Game Info will be handled by a singleton com.example.telimprompturevised.GameInfo class
5. Player Info will be handled by a Player class 



# 6. API

## 6.1. Public Models

ResponseModel

## 6.2. *First Endpoint*

[Sequence Diagram](AddResponseSD.puml)

Posting Data To DynamoDB 

Requires: Role title, sequence, text 

Returns: Status code whether or not data was successfully pushed to database 

Failure Cases: Return error code


## 6.3 *Second Endpoint*

Getting Data from DynamoDB

Requires: 

Returns:


# 7. Tables

*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

PlayerInfo table: Holds strings of all player attributes relevant to the final script, such as name, field of expertise, etc.
Response table: Holds Strings of all the player responses. 

# 8. Pages



[Home Page](images/index.png)

[Waiting Room](images/waiting_room.png)

[Game](images/game.png)