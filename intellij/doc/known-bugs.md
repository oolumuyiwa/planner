# General Issues
* on user onboarding, it default opens to task view, while opening to course view makes more sense for the first app launch since having a course is a prerequisite for task creation
* should allow user to leave date and time blank and just assume that a blank entry corresponds with no deadline or time associated 

# Known Bugs
* on task creation:
    * deadline month is off from what the user inputs (example: user inputs May/5 and the app lists April/4)
    * requires user to tap on the deadline input box twice to bring up flyout
        * if only pressed once, the user can format the date in the same manner as the flyout will, but will cause a crash on incorrect formatting
        * same problem remains for time parameter being filled out, requires two presses for proper formatting
      
* on course creation:
    * formatting of the meeting days is not sequential (wednesday comes last)
    * same app crashing/double press issue with the time parameters
    * no input of meeting times sets a default of the current day of the week and time rather than a null parameter
    
* system related:
    * persistent data creation only occurs on home button press, so a possible app crash will remove recently input information