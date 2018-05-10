CS 342 Homework 4

Group 30 

Members:
- Christian Haro, NetID: charo3
- Diana Vera, NetID: dvera6
- Konrad Kurzynowski, NetID: kkurzy4

Work Distribution:
- Christian: ExamBuilder, Exam, Question, MCQuestion
- Diana: ExamGrader, Answer, SAQuestion, SAAnswer, NumQuestion, NumAnswer
- Konrad: ExamTaker, MCAnswer, MCSAQuestion, MCSAAnswer, MCMAQuestion, MCMAAnswer, ScannerFactory 

CHECKLIST BEFORE SUBMITTING 
(just mark an X in a box if it's done, and leave any notes or comments if need be. Also feel free to add anything)


****** 0. Stuff that he said requires more effort ******:

The following modifications may take a little more effort:
[ ] Suggestion: If Question and Answer contain Strings for the label to be written in the data file,
such as â€œSAQuestionâ€� , then some of the code to write to files can be moved up into the
Question and Answer classes. ( Constructors will need to set the field appropriately. )
[ ] There was a question as to whether an MCAnswer saved in a file should always have a
â€œcreditIfSelectedâ€� value stored with it or if that is only saved in Exam files. If such a value is
saved in Answer files, then the next question is what value to save, since that field is really only
supposed to pertain to the choices available of a multiple-choice question.
[ ] The numQuestion and numAnswer classes will no longer be optional. This may involve
significant additions, not necessarily part of the simple refactoring/cleanup step.

****** 1. ExamBuilder ******:

[X] Present menu of choices to user
[X] Read user's choice and perform requested action
[X] Infinite loop until "Quit" command is entered
[X] Choices include all these at a minimum: 
  [X] Load a saved Exam from a file.
  [X] Add questions interactively.
  [X] Remove questions interactively.
  [X] Reorder questions, and/or answers.
  [] Print the Exam, to the screen or to a file suitable for hard-copy printing.
  [X] Save the Exam, using the file format given in HW3 or a minor variation thereof.
  [X] Quit
  
[ ] Optional Enhancement: Read in multiple Exams, and merge the questions into one Exam.
[ ] Optional Enhancement: Read in file(s), but interactively decide which question(s) to add to the
exam.

****** 2. ExamTaker ******:

[X ] Get student information.
[X ] Load an arbitrary Exam file, following the file format specified in HW3 ( as modified above )
or a close variation thereof as agreed to by your group.
[X ] Get answers from the student:
  [X ] Allow students to skip answers, and come back to them later. ( You may need to resolve
what happens if a student wants to leave one or more questions unanswered. )
  [X ] Allow students to change their answers.
[ ] [ Optional ] Show confirmation of student choices ( ungraded ) before saving and exiting.
[X ] Save student answers to a file, containing also the name of the corresponding exam file as
described above and in class.

[ ] Optional Enhancement: What support can be provided for a student to repeat an exam?
[ ] Optional Enhancement: Can the student be given the option of sorting the questions in real
time, say with the unanswered questions at the beginning, while still storing the answers in the
same order as in the original exam file?

****** 3. ExamGrader ******:

[ x] Load up an Exam file and an Answer file, confirming that they are a matched set.
  [x ] If only an Answer file is provided, perhaps as an optional command-line argument, then
automatically load up the corresponding Exam file.
[x ] Evaluate the answers, and report the results to the screen.
[ x] Store the results to a CSV ( comma separated values ) file:
  [ x] Student identity, total score, list of comma-separated scores for each question.
  
[ ] Optional Enhancement: Read in one Exam file and a number of Answer files, creating a table
of results. The CSV file should have one line ( row ) for each Answer file processed.
[ ] Optional Enhancement: Support Excel format files as well as CSV.

****** 4. Required output ******: 

[ ] Prints name and netID of all group members
[ ] Otherwise functions as above ^

****** 5. Miscellaneous stuff ******:

[ ] All classes have a constructor that takes Scanner as an argument 
[ ] saveStudentAnswers() and restoreStudentAnswers() end with 's'
[ ] Include name of exam file inside the student answer file, on a second line right after the
student identity information. This should be compared against the Exam file in use when grading
[ ] Include time/date of when a file was last saved at the beginning of each file written. In the Exam file that should go on a line right after the exam title, and in the Answer file it should
go right after the line containing the Exam file name.
[ ] NumQuestion and NumAnswer are functional 
[ ] README/documentation has detailed description of all the work done by each member
[ ] code has adequate comments/etc 

These programs (ExamTaker / ExamBuilder / ExamGrader) test the classes:
Exam, MCMAQuestion, MCSAQuestion, SAQuestion, MCQuestion, NumQuestion, 
Question, MCMAAnswer, MCSAAnswer, SAAnswer, MCAnswer, NumAnswer, Answer, and ScannerFactory for correct functionality.

To use the programs simply type "make" in the console to run the compiler, 
then type "java <program_name>" to run the program.

Must be ran on bert (other servers don't have javac).

