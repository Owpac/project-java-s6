# Java project

# VERSION 1 : Console mode with a test set

#### Specifications:
We try to manage a list of students with their grades and the teachers who evaluate them.
- Each **teacher** and each **student** have as common property the first and last name.
- Each **student** has the following properties:
  - an identification number whose uniqueness must be managed.
  - his name, his first name.
  - Its date of birth (day month month year), a Date class is to be developed.
  - its **evaluations,** their average and median.
- For each **evaluation**, the subject concerned, the value of the mark, the **student** are indicated.
and the **professor** corrector.
- Each **student** can only consult all his own marks as well as their average and median.
- All students are a **promotion** and each **student** knows his or her **promotion**.
- Students in a **promotion** can be ranked by average scores by median scores. Subject rankings are also possible.
- Each **professor** can perform the following operations:
  - search for a student in the **promotion** from his ID number.
  - modify notes of a wanted student.

Among the classes to be developed are: Student, Teacher, Evaluation, Promotion.
These classes are arranged in a **package notesElevesProfesseurs and other packages if necessary.

---

## Question 1 :

**Each teacher and each student have the same properties as the first and last name.

What concept of object programming is appropriate at this point in the CDC?
Write the necessary code corresponding to this concept?

---

## Question 2: Teacher and Student classes

**Each teacher and each student have the same attributes as the first and last name.

Define the Teacher and Student classes based on your answers to question 1.
Define the read accessors for the first and last name.
Redefine the toString method as it returns for example:
- (Sun, Sunflower) for the teacher of the first name Sun and name Sunflower.
- (Jean, Duval) for the student with the first name Jean and the last name Duval.

---

## Question 3: Evaluation class

**For each evaluation, the subject concerned, the floating value of the score, is indicated, 
the corrected student and the remedial teacher.

Code the Evaluation class defining:
- the 4 attributes above.
- a 4-parameter constructor.

The class **Evaluation** redefines the method **toString** as it returns for example:

`((Jean, Duval) (Sun, Sunflower) mathematics 12.0)`

Write the code for this method.

---

## Question 4: Student class (continued)

**Each student has the following attributes:**
- an ID number.
- his name, his first name.
- its evaluations, their average and their average.

Indication: the identifier is an integer constant and all students have identifiers 
unique (the use of class variables, static keyword, can be considered).

Code the Student class defining:
- a class constant `NB_EVALUATIONS` of the integer type and being 10.
- a public builder with 3 parameters allowing to give a name, a first name and a
    identifying to a student.
- a read accessor for the identifier.
- a **average** method calculating and returning the average of a student's grades.
If the student has no notes, the exception `IllegalStateException` is thrown.
- a **mediane** method calculating and returning the median of a student's scores.
If the student has no notes, the exception `IllegalStateException` is thrown.
- the `getCorrectors` method allowing to arrange in an instance of the class
"HashSet", all the correctors having evaluated a student. She returns this
collection.
The signature is: `public Set<Prof> getCorrectors();`

**Reminder:** `HashSet`` is a class implementing the ``Set``` interface, available in the package ``java.util```.
Method of adding the `Set` interface, where `E` refers to a generic type: `boolean add(E)`.
>Adds the specified element to this set if it is not already present (optional operation).
More formally, adds the specified element e to this set if the set contains no element e
such that (`e==null?e2==null:e.equals(e2)`). If this set already contains the
element, the call leaves the set unchanged and returns false. In combination with the
restriction on constructors, this ensures that **sets never contain duplicate elements.**

The `HashSet` class redefines a `toString` method so that a collection of
teachers will be displayed as follows: `[(Max, The Threat), (Sun, Sunflower)]`

The class **Pupil** redefines the `toString` method as it returns for example: 
```
(Jean, Duval) id: 1
grades: mathematics 12.0 French 18 mathematics 6.0 English 15.
average = 12.
mediane = 13.
corrector(s): [(Max, The Threat), (Sun, Sunflower)]
```

Write the code for this method.
Note: the Student class must implement the `equals` and `hashcode` methods for the
needs of some methods of the HashSet class among others.
The same applies to the other classes.
However, beware of the circularity of the calls to these methods. You will need to change the code
generated in order to short-circuit any observed circularity.

---

## Question 5: Promotion class

**All the students are a promotion.

Code the Promotion class defining among other things:
- an attribute **name** of type `String`.
- an attribute **students** of a generic container. A promotion contains a
student collection.
- a constructor with one parameter.
- read and write accessors for the **name** of the promotion.
- a `getEleves` read accessor.
- a **research** method that searches for a student in the student collection according to
its identifier passed as a parameter. If the desired student is found, this method
returns the found student, otherwise returns a null reference.

---

## Question 6: Student class (continued)

**All students are a promotion and every student knows his or her promotion.

Complete classes **Promotion** and **Pupil** accordingly, in particular: the `toString` method 
of the class **Pupil** must display the name of a student's promotion.

---

## Question 7: Teacher class (continued)

**Each teacher can search for a student in a promotion based on his or her ID number.

Write a search method that searches for a student in a given promotion according to
its identifier passed as a parameter. If the desired student is found, this method returns
the found student, otherwise returns a null reference.

---

## Question 8: Teacher class (continued)

**Each teacher can change marks on a student's evaluations.

Write a `setNote` method that modifies a student's ith note:
the promotion, the student ID, the grade value and the index i are passed as parameters
of this method. From the student's ID number, this method searches for this student
and modifies a note if possible:
- if the student you are looking for does not exist, the **IllegalStateException** is launched.
- if the student exists and if the index score i also exists then is modified.
- if the student exists and the index score i does not exist then it is created and the assessment is
added to existing evaluations.

---

## Question 9: Student and Promotion classes (continued)

**Students in a promotion can be ranked according to the average and median of their
notes. **

- Students are ranked in ascending and then descending order according to the average and median
of their notes. How do I complete the **Pupil** class? Write the necessary code.
- In the **Promotion** class, code the methods that classify the students in the promotion by
in ascending and then descending order of average and median.

---

## Question 10: Test classes

Write several test classes, in a package **test**, containing a method **main** so that :
- Create several students and several teachers.
- The data is hard coded in test classes.
- Rank students in their promotion.
- Put notes on the students, indicate the correctors.
- Display a student with his or her name, promotion, markers, marks, average and
their median.
- Display all students in a promotion.
- Search for a student by his identifier and then display it (no display in the search!).
- Rank students in ascending and then descending order of their average and median.
- Display all students in a promotion according to the rankings made.

---

# VERSION 2 : Console mode with a test set

The data is read from files in CSV format.
The use of the **Scanner** class is required. Consult Javadoc.
The definition of the file's reading grid is left to your judgment.
Data that can be modified by the application (including notes), saved,
in the same CSV format, is required.

---

# VERSION 3 : Various statistics console mode with a test set

The data is hard-coded in test classes or read from files in the
CSV format.
A student's report card is to be modelled.
The assessments, their average and median by subject taught and overall are at
to inform.
For promotion, the average and median per subject taught and overall are
enter their minimum and maximum values.
As a result, various statistics on ratings (including average and median) are available at
represent graphically.
The use of **JfreeChart** is highly recommended.

---

# VERSION 4 : Graphical mode with a test set

A graphical version including all the previous features (mode
console, CSV files, statistics) is to be developed.
The design of the graphical interface is to be taken care of.
The use of the JTable class is recommended.