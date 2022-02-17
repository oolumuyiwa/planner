#Edit course 
##Scope
    Planner application 
##Level
    User goal
##Primary Actor 
    Student 
##Stakeholders And Interests
###Student: 
Wants easy means to edit course without having to delete and create another course, as some planner apps tend to lack that functionality.  

##Preconditions
Student has a preexisting course on record.

##Postconditions

1. Course components are modified.

2. Course components are accessible afterwards.

3. Course has all necessary components implemented.



##Main Success Scenario



1. The user opens the app after installing

2. The user moves to the Course activity page by swiping to/pressing the Course tab.

3. The user specifies a preexisting course.

4. The user modifies specific components of the course and saves the course.

5. The system checks that all other required information to have a valid course has been given.

6. The user saves the course and the system updates the task.



##Extensions

###4a) Edit Course Class Time

1. Upon the display of the add course page, the user enters class time

2. The system validates the given class times.

###4b) Edit Course Exam Time

1. Upon the display of the add course page, the user enters the exam time and date and specifies whether it's a midterm or a final.

2. The user chooses what dates/times to receive reminders on the course exam.

3. The system validates the given class times/dates.



###5a) Invalid Information

1. The date is in invalid format and/or in the past.

2. The system signals error and asks for valid date format and time.

###5b) Inadequate Information

1. The exam time/date or class time or course name is not given.

2. The system signals error and asks for valid information.



###*a) System crashes

1. Student restarts system.

2. System reconstructs prior state.

###*b) User exiting activity

1. Student presses 'cancel' button

2. System presents a confirmation log

3. If exit is confirmed, return to previous activity page with the selected course left unchanged. Otherwise, return to Edit Course activity page.







##Special Requirements:

1. Android OS of version 5.0 or higher.

2. Touch screen User Interface

3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features. 