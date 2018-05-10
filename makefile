JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ExamBuilder.java \
	ExamTaker.java \
	ExamGrader.java \
	Exam.java \
	MCSAQuestion.java \
	MCMAQuestion.java \
	MCQuestion.java \
	SAQuestion.java \
	NumQuestion.java \
	Question.java \
	ScannerFactory.java \
	MCSAAnswer.java \
	MCMAAnswer.java \
	MCAnswer.java \
	SAAnswer.java \
	NumAnswer.java \
	Answer.java  

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
