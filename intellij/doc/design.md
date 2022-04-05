# Domain Model For Planner App
```plantuml
@startuml
title Domain Model


'classes
class Course{
name
icon
code
semester
}
class meetingTime{
time
weekday(s)
}

class Task{
name
type
}
class Deadline{
time
date
}
class Student{
name
}
class TasksPane{
Tasks
}
class CoursesPane{
Courses
}
class Calendar{
}


'associations
 Student "1" - "1..*" Course : \tTakes\t\t
 Course "1" -down- "*" Task : \tContains\t\t
 Course "1" - "1..*" meetingTime : \tContains\t\t
 Student "1" - "1..*" Task : \tIs-Assigned\t\t
 Task "1" -down- "0..1" Deadline : \tContains\t\t
 Calendar "1" -left- "1..*" Deadline : \tUses\t\t
 Calendar "1" - "1..*" meetingTime : \tIs-Used-By\t\t
 Task "1..*" -left- "1" TasksPane : \tLists\t\t
 Course "1..*" -right- "1" CoursesPane : \tIs-Listed-In\t\t
@enduml
```

# Sequence Diagrams For Planner App
## "Add Task" operation

```plantuml
@startuml
actor Student as student
participant "Graphical Interface" as graphicalInterface
participant ": Controller" as controller
participant "Task Library" as taskLibrary
graphicalInterface -> student: Ask for new task
student -> graphicalInterface: New task
graphicalInterface -> student : Ask for data
student -> graphicalInterface: Give valid data
graphicalInterface -> controller: Create new task (name, course)
controller -> taskLibrary: Add new task in specified course
@enduml
```

## "Add Course" operation

```plantuml
@startuml
actor Student as student
participant "Graphical Interface" as graphicalInterface
participant ": Controller" as controller
participant "Task Library" as taskLibrary
graphicalInterface -> student: Ask for new course
student -> graphicalInterface: New course
graphicalInterface -> student : Ask for data
student -> graphicalInterface: Give valid data
graphicalInterface -> controller: Create new course
controller -> taskLibrary: Add new course as task category
@enduml
```

# Class Diagram for Planner App

```plantuml
@startuml
class Task{
- name : String
- type : String
 
- deadline : LocalDateTime
- notes : String
- id : int 
--

}
class Course{

- name: String
- code: int
- meetingTimes: ArrayList<Pair<LocalDateTime, LocalDateTime>>
--
+endSale()
+setMeetingTime(day: String, time : String, recurrences : int) : String
}
class Semester{
- semname : String
- semyear : int
}

class Controller{
+addCourse()
+addTask()
+listCourses()
+listTasks()
+editCourse(course : Course)
+editTask(task : Task)
}
Course -> "(1..*)\ntasks\n{List}" Task : \t\t\t\t
Course *- "(1)\nsemester\n" Semester : \t\t\t\t

Controller -> "(1..*)\ncourses\n{List}" Course : \t\t\t\t
Controller -> "(1..*)\ncourses\n{List}" Task : \t\t\t\t
@enduml
```