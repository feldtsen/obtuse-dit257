# Konrad
Our goal is to create an application where people can donate unused groceries/food within their local community. This application could be used within a small village, neighborhood or housing cooperative. By allowing each community to set up their own “sharing room”, they can ensure they know and trust each other, which will inspire them to share more freely. The intention of this application is to help small communities manage their sharing and build additional trust among neighbours, in turn strengthening the community. 

The application could also be expanded to support sharing tools, various household supplies, or other utilities within the community. An additional possibility is to allow communities to share food or utilities with other, adjacent communities that they trust.

## UN Sustainable Development Goals
### Goal 1: No Poverty - *Donate what you don't use*
> **1.A** Ensure significant mobilization of resources from a variety of sources, including through enhanced development cooperation, in order to provide adequate and predictable means for developing countries, in particular least developed countries, to implement programmes and policies to end poverty in all its dimensions

### Goal 2: Zero Hunger - *Waste less food*
> **2.1** By 2030, end hunger and ensure access by all people, in particular the poor and people in vulnerable situations, including infants, to safe, nutritious and sufficient food all year round

### Goal 12: Responsible Consumption and Production - *Recycle*
> **12.3** By 2030, halve per capita global food waste at the retail and consumer levels and reduce food losses along production and supply chains, including post-harvest losses

# Contributors
* Joachim Pedersen as *feldtsen*
* Anton Hildingsson as *palmdrop*
* Mattias Oom as *Mattoom*
* Ashor Khizeran as *Ashor*
* Charles Sundström as *Ollesun*
* Malin Jansson as *malingo88*
* Ludvig Östergaard as *LudvigGU*

# Resources
Trello: https://trello.com/invite/b/FFDYCcny/8518947e43eaa2c797088ab654d10e63/konrad-board

Slack: https://join.slack.com/t/obtuse-dit257/shared_invite/zt-ihafm4b5-sVm8RzePdEKytYYLpyQ01w

Lucidchart: https://app.lucidchart.com/invitations/accept/088a14a7-988d-4f10-ac37-11b4d66aa07e

# Repository structure
This section contains short description of each file and folder in the root directory.

## KPIs
This folder contains a list of our KPIs and our weekly/daily evaluations of these KPIs. The file KPIEvaluation.md is intended to be a short overview of our developments in terms of KPIs.

## individual-reflections
This folder contains our individual reflections, week by week.

## project
This folder contains the actual source code itself. Our project is a maven-project. More description can be found under project documentation.

## resources
This folder contains images such as logos and symbols used in the applications .

## sprint protocol
This folder contains protocols and documentation for each sprint. 

## team-reflection
This folder contains all our weekly team-reflections.

## .gitignore
The gitignore file for our project.

## KonradUML.png
The latest domain model for our project.

## README.md
You are here.

## backlog.md
Epics/themes and [TODO: user stories?] and how our project relates to the UN Sustainable Development Goals.

## definition-of-done.md
Our definition of done. This document is used to evaluate if a user story is done or not. This is done each week, before we start the next sprint.

## socia-contract.md
Our social contract. This details how we should work as a team and how we should treat each other.

# Dependencies
* Apache Maven 3.6.3 
* java-11 (java-11-openjdk) 
[TODO: list maven dependencies?]
* javafx-15
* junit-4.11
* gson-2.8.5

# Project setup
## Intellij 
1. Clone this repository
2. Open the *project* folder in intellij idea
3. traverse the project view and mark the *java* package as Sources root, *resources* as Resources root and *tests* as Test sources root (right click -> Mark Directory as)
4. pick java version 11 (File -> Project Structure -> Project Settings -> Project)
5. Press *Add configuration* and chose *Template*, then *Application*. Under *Main class* write *application.App* and under *Working directory* input the path to the project folder. In the *Use classpath of module* dropdown, pick *project*. Do not forget to actually create the configuration (the top left plus sign).
6. Build and run the application

## Eclipse 
1. Clone this repository
2. Move the *project* folder into one of your eclipse workspaces (or create a new one).
3. Open the *project* folder in eclipse.
4. Build and run the application.

# Project structure
- src
    - main
        - java (source)
            - controller
            - model
            - view
            - App.java
            - ResourceLoader.java
        - resources
        - tests (tests folder)
* pom.xml

## java (source)
### controller (package)
### model (package)
### view (package)
### App
### ResourceLoader


