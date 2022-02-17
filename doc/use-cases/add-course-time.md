# Add Course Time
## Scope
    Planner application



## Level 
    User goal



## Primary Actor
    Student



## Stakeholders And Interests

### Student
Wants easy means to edit course without having to delete and create another course, as some planner apps tend to lack that functionality.



## Preconditions

Student is in the process of creating or updating a course.



## Postconditions

1. Course class time is instantiated or modified.

2. Course components are accessible afterwards.

3. Course has all necessary components implemented.



## Main Success Scenario



1. The user opens the app after installing.

2. The user moves to the Course activity page by swiping to/pressing the Course tab.

3. The user presses the add button on the Course activity page.

4. Upon the display of the add course page, the user enters class time

5. The user saves the class time by pressing a button on add course page.

6. The system checks that all other required information to have a valid course has been given.

7. The system updates the course schedule and makes the class time a recurring weekly event till specified end date of course.





## Extensions

### 6a) Invalid Information

1. The date is in invalid format and/or in the past.

2. The system signals error and asks for valid date format and time.

### 6b) Inadequate Information

1. The exam time/date or class time or course name is not given.

2. The system signals error and asks for valid information.



### *a) System crashes

1. Student restarts system.

2. System reconstructs prior state.

### *b) User exiting activity

1. Student presses 'cancel' button

2. System presents a confirmation log

3. If exit is confirmed, return to previous activity page (e.g course or task activity page). Otherwise, return to Add Course activity page.



## Special Requirements:

1. Android OS of version 5.0 or higher.

2. Touch screen User Interface

3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features. 

 