# Task Input

Inputting Tasks should be as **easy and fast** as possible, because we don't want to make this into another hurdle. That could stop users from inputting Tasks which would render TaskaDoo useless.\
This is why we plan to implement 2 ways of doing that. Through text and voice commands. Integrating AI will allow automatic planning and categorization.

## General

1. Both voice and text input
2. App automatically checks, if new Task collides with another one.
   - Could be done by script even before implementing AI


## Text

1. From Main(Tasks) Tab
2. `Add Task` Window pop-up overlayed on top of the Tasks Tab
    1. `Insert Text Panel`
    2. Options for adding attributes
    3. Option for AI to add attributes
    4. `Okay` and `Cancel` 
    5. If collides with another Task:
   > Are you sure? You have `example Task` planned this time already

    **Someone check my english pls**

## Voice

1. No need for opening TaskaDoo
2. Voice command requires unblocked smartphone
3. Example script:
    > **U:** Hey, TaskaDoo *or smth like that*\
    > **T:** Hi, do you want to  create a new Quest?\
    > **U:** Yes, add a Doctor appointment on 23rd\
    > **T:** 23rd of january, right? Should I add specific time?\
    > **U:** No, no. I meant next month. Time would be 4PM\
    > **T:** Okay, so Doctor Appointment on 23rd of February, 4PM. Category: Health and I'm guessing... Priority: high? I'll also color it green for you, since all your health-related Quests are green too.\
    > **U:** Oh yeah, thanks!\
    > **T:** No problem, mate.

4. Example script if a Task collides wth preexisting one:
    > **U:** Hey, TaskaDoo\
    > **T:** What's up? A new Quest?\
    > **U:** Yup, can you create one for a date with Jennifer on 23rd of February? 30 minutes after 3PM\
    > **T:** I can but you have a Doctor Appointment on 4PM that day. Will you make it on time?\
    > **U:** Oh f*ck! Can you create a Quest for cancelling a date with Jennifer in 2 hours?\
    > **T:** Done! Category: Relationships. How high is the priority?\
    > **U:** Very high! And make it red too...\
    > **T:** Alright

## AI 
1. Ability to automatically add attributes
2. Used especially in **voice Task Input**

