# Fully Dressed Use Cases

### Add Course

| Section | Comment
| --------- | ---------
| Use case name | Adding courses
| Scope | Planner application
| Level | User goal
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | None.
| Postconditions | 1. New course is created <br /> 2. Course components are accessible afterwards <br /> 3. Course has all necessary components implemented
| Main success scenario | 1. The user opens the app after installing. <br /> 2. The user navigates to the course view <br /> 3. The user presses the add button on the course view page. <br /> 4. The user specifies the name of the course. <br /> 5. The user optionally gives a worded description of the task as well as meeting times. <br />  6. The user saves and the system records the course.
| Extensions | None. Course view pane is the primary/only location to add courses to the application.
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Initially occurs quite often, but after complete initialization of all courses should only occur when a new semester begins.
| Miscellaneous | None.

### Add Task Deadline

| Section | Comment
| --------- | ---------
| Use case name | Adding task deadline
| Scope | Within editing tasks or within adding tasks
| Level | Subfunction
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | User has either created a task or is currently creating a task.
| Postconditions | 1. New task with deadline is created or preexisting task has deadline added <br /> 2. Course components are accessible afterwards <br /> 3. Course has all necessary components implemented
| Main success scenario | During creation of a new task, the parameter of deadline is added
| Extensions | During editing of a preexisting task, the parameter of deadline is added
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs less so than task creation, as tasks do not require deadline parameters to be filled
| Miscellaneous | Is generally a subset of task creation and/or task editing.

### Add Course Time

| Section | Comment
| --------- | ---------
| Use case name | Adding course times
| Scope | Within course creation or editing courses
| Level | Subfunction
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | A course is either created or currently being created
| Postconditions | 1. New course with time is created or preexisting course is updated with a time <br /> 2. Course components are accessible afterwards <br /> 3. Course has all necessary components implemented
| Main success scenario | During creation of a new course, the parameter of time is added
| Extensions | During editing of a preexisting course, the parameter of time is added
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs around the same frequency as course creation, as most courses will have a corresponding time given to them, as well as possible multiple time entries due to courses reoccurring at different times
| Miscellaneous | Is generally a subset of course creation and/or course editing.

### Edit Task

| Section | Comment
| --------- | ---------
| Use case name | Editing tasks
| Scope | Planner application
| Level | Subfunction
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | Student already has a preexisting task created
| Postconditions | Task is updated with changed or added information.
| Main success scenario | The user navigates to task view, taps on a listed task, and presses the edit button. The user then updates the information listed, and presses the save button.
| Extensions | Instead of saving the updated information, the user also has the option to discard their changes.
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs with a wide variety of frequencies, either nearly never, as users can instead opt to create and remove tasks rather than editing them, or can occur frequently with multiple changes to a single task.
| Miscellaneous | None.

### Edit Course

| Section | Comment
| --------- | ---------
| Use case name | Editing courses
| Scope | Planner application
| Level | Subfunction
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | Student already has a preexisting course created
| Postconditions | Course is updated with changed or added information.
| Main success scenario | The user navigates to course view, taps on a listed course, and presses the edit button. The user then updates the information listed, and presses the save button.
| Extensions | Instead of saving the updated information, the user also has the option to discard their changes.
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs with a wide variety of frequencies, either nearly never, as users can instead opt to create and remove courses rather than editing them, or can occur frequently with multiple changes to a single task.
| Miscellaneous | Generally, the frequency of any task-related use case will occur with a greater frequency than course-related ones.

### List Tasks

| Section | Comment
| --------- | ---------
| Use case name | Listing tasks
| Scope | Planner application
| Level | User goal
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | None.
| Postconditions | User will be able to see created tasks - or if none are created, a blank screen
| Main success scenario | The user opens the application, since task view is the default view
| Extensions | If in a different view, user navigates to task view using the sidebar.
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs with the greatest frequency, higher than that of app launches generally.
| Miscellaneous | None.
 
### List Courses

| Section | Comment
| --------- | ---------
| Use case name | Listing courses
| Scope | Planner application
| Level | User goal
| Primary Actor | Student using the application
| Stakeholders and interest | Students looking to plan academic work in their schedule
| Preconditions | None. 
| Postconditions | User will be able to see created courses - or if none are created, a blank screen
| Main success scenario | The user navigates to course view using the sidebar.
| Extensions | None.
| Special requirements | 1. Android OS of version 5.0 or higher. <br /> 2. Touch screen User Interface <br /> 3. A recommended minimum screen size of 5 inches to ensure legibility of text and other app features.
| Technology and data variations list | Application used on Android phone
| Frequency of occurrence | Occurs semi-often, as often as the user needs information about their courses.
| Miscellaneous | None.