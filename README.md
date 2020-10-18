# Konrad
[include description]

## Contributors
* Joachim Pedersen as *feldtsen*
* Anton Hildingsson as *palmdrop*
* Mattias Oom as *Mattoom*
* Ashor Khizeran as *Ashor*
* Charles Sundström as *Ollesun*
* Malin Jansson as *malingo88*
* Ludvig Östergaard as *LudvigGU*

## Resources
Trello: https://trello.com/invite/b/FFDYCcny/8518947e43eaa2c797088ab654d10e63/konrad-board

Slack: https://join.slack.com/t/obtuse-dit257/shared_invite/zt-ihafm4b5-sVm8RzePdEKytYYLpyQ01w

Lucidchart: https://app.lucidchart.com/invitations/accept/088a14a7-988d-4f10-ac37-11b4d66aa07e

## Repository structure
This section contains short description of each file and folder in the root directory.

### KPIs
This folder contains a list of our KPIs and our weekly/daily evaluations of these KPIs. The file KPIEvaluation.md is intended to be a short overview of our developments in terms of KPIs.

### individual-reflections
This folder contains our individual reflections, week by week.

### project
This folder contains the actual source code itself. Our project is a maven-project. More description can be found under project documentation.

### resources
This folder contains images such as logos and symbols used in the applications .

### sprint protocol
This folder contains protocols and documentation for each sprint. 

### team-reflection
This folder contains all our weekly team-reflections.

### .gitignore
The gitignore file for our project.

### KonradUML.png
The latest domain model for our project.

### README.md
You are here.

### backlog.md
Epics/themes and [TODO: user stories?] and how our project relates to the UN Sustainable Development Goals.

### definition-of-done.md
Our definition of done. This document is used to evaluate if a user story is done or not. This is done each week, before we start the next sprint.

### socia-contract.md
Our social contract. This details how we should work as a team and how we should treat each other.

## Dependencies
* Apache Maven 3.6.3 (or later)
* java-11 (java-11-openjdk) (or later???)

## Project setup
### Intellij 
1. Clone this repository
2. Open the *project* folder in intellij idea
3. traverse the project view and mark the *java* package as Sources root, *resources* as Resources root and *tests* as Test sources root (right click -> Mark Directory as)
4. pick java version 11 (File -> Project Structure -> Project Settings -> Project)
5. Press *Add configuration* and chose *Template*, then *Application*. Under *Main class* write *application.App* and under *Working directory* input the path to the project folder. In the *Use classpath of module* dropdown, pick *project*. Do not forget to actually create the configuration (the top left plus sign).
6. Build and run the application

### Eclipse 
TODO: describe maven setup, java-version required, pom-file, etc...
    * include instructions for both intellij and eclipse! 

## Project structure
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

### java (source)
#### controller (package)
#### model (package)
#### view (package)
#### App
#### ResourceLoader


