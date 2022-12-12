## Coding Exercise - Gradebook

## _Objectives_
You are developing a gradebook backend system for use by colleges/universities. Code should be well-structured, organized, and easy to read.

## _Task Overview_
The schools enroll students in courses (see course-roster.json).  

A course has a structure that basically mirrors a table of contents. So a course will have at least one assignment, and each assignment in the course
will have at least one assessment. An assessment is classified by a type -- it can be a quiz, homework, writing, reading etc.

Whenever a student completes an assessment, a scored submission is sent to the Gradebook (sample model student-assessment-score.json).

The gradebook accepts these scored submissions, records them as assessment grades, and calculates/derives some averages.
These derived averages include overall score average in a given course for each student, as well as the overall average for the entire roster of students.

For simplicity’s sake, assume that course roster and course structure are set at the time of first interaction with the 
Gradebook system.

Gradebook system needs to:

1. provide an API exposing student assessment grades, student overall scores, class overall scores
2. accept student assessment submissions
3. record/persist student grades on assessment submission
4. calculate student overall score in a course on assessment submission
5. calculate class overall score in a course on assessment submission

You should:
1. apply object-oriented principles in your design
2. use practices that ensure your code does what is expected

Extra credit:

1. think of a way/ways to handle huge spikes of assessment submissions (procrastinating students waiting till the last moment)
2. how would you handle changes to roster and/or course structure ?  
3. what else would it take to get this production-ready?

## _Programming Environment_
This assignment can be completed using the tools you are most comfortable with.

## _Review_
When this task is completed, you’ll be asked to walk us through the code and explain your design decisions, as well as identify areas that could be improved if you had more time.

