

This repository contains code for the creation of a planner application for Android; to be used by students of any academic level to assist in organization of assignments and other responsibilities for all courses they are enrolled in.

## Functionality

### Iteration 1

The prototype developed as a part of the first iteration has the functionality to add tasks, add courses, view all tasks, view all courses, edit tasks, and edit courses.  

With tasks, you can give them the attributes of a:
* name
* type
* deadline
* corresponding course
* and personal notes

For courses, you can give them the attributes of a:
* name
* code
* corresponding semester
* meeting times

You can also show tasks corresponding to their associated course by selecting "all courses."

The main method to run the program is located within the Controller class.

### Iteration 2

For the second iteration, the code has been converted into an Android Studio application, with the task and course functionality implemented. On a cold boot, the application defaults to opening the Task Pane.

For the view of the task pane, you can navigate to the Add Task pane by clicking on the "plus" icon, which then allows you to create a task with the following attributes:
* Name
* Associated course
* Task type
* Deadline (date and time)
* Additional notes

Similarly, you can navigate to the Add Course pane when the Courses pane is active. Then, you can create a task with the following attributes:
* Name
* Course code
* Associated semester
* Meeting times
* Meeting days
* Start/end times
* Room number
* Additional notes

The main method to run the program is located within the MainActivity class.

### Iteration 3
For the final iteration, local persistence has been added to keep course/task information after discarding the application from RAM.

There were also some general bug fixes and other minor changes.

At this point, the application features a good amount of features that would indicate that it is minimally viable, which are:
* creation of a task, featuring parameters of a name, associated course, type of task, as well as optional parameters of a deadline, a due time, and any additional notes
* creation of a course, featuring a name, course code, associated semester, and optional parameters of a meeting time, meeting days of the week, classroom location, and additional notes

Both of these are viewable on a view pane of their own, which is switchable through tapping on the button on the middle of the top bar and new tasks/courses can be created through pressing the top right 'add' button on their corresponding pane.

Along with this, tasks/courses can be removed by clicking the 'trash' icon on the top left.
  
### Possible Future Iterations

For future iterations, other features and changes can be implemented to further develop our application
* a general UI overhaul now that we have experienced using the application for a while, as well as getting over the developmental stage
* implementing push notifications either prior or on the time that tasks are due
* implementing the ability to edit a task, as the current option to making changes in tasks is to delete and recreate them
* general bug fixes


