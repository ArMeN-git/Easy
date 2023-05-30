package com.company;

public class Main {
    public static void main(String[] args) {
       StudentsDAO student = new StudentsDAO();
//       1. Create 7 objects of Students and output the list of students
        System.out.println("List of the students: ");
        student.showStudents();
//        2. Sort students on their names in alphabetical order
        System.out.println("Sorting in alphabetical order");
        student.printStudentsAlphabetical();
//        3.Output those students' data whose grades contain at least one prime number and whose name is palindrome
        System.out.println("With prime grade and palindrome number: ");
        System.out.println();
        student.primeAndPalindrome();
    }
}

package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Students {
    private String name;
    private String surName;
    private String birthDate;
    private int[] grades;

    public Students() {
    }

    public Students(String name, String surName, String birthDate,  int[] grades) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public int getAge(){

           LocalDate birthDate = LocalDate.parse(this.getBirthDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
           LocalDate now = LocalDate.now();
           int age = Period.between(birthDate, now).getYears();
           return age;

   }

    @Override
    public String toString() {
        return name + " " + surName + " " + getAge() +  " " + Arrays.toString(grades) + '\n';
    }


    public boolean isPrime() {
        boolean isPrime;
        for (int i = 0; i < getgrades.length; i++)
        {
            isPrime = true;
            for (int j = 2; j <= getgrades[i]/2; j++)
            {
                if (getgrades[i] % j == 0)
                {
                    isPrime = false;
                    break;
                }
                if (isPrime == true)
                    return true;
            }
        }
        return false;
    }

    public boolean IsPalindrome() {
        int low = 0;

            int high = (name.length()) - 1;
            boolean isPalindrome = true;
            while (low < high) {
                if (name.toLowerCase().charAt(low)!= name.toLowerCase().charAt(high)) {
                    isPalindrome = false;
                    break;
                }

                low++;
                high--;
            }
        return isPalindrome;
    }


}
package com.company;
public class StudentsDAO {
    Students[] students;


    public Students[] addStudents() {
        Students student1 = new Students("Varduhi",  "Gevorgyan", "2001.05.06",  new int[]{14,13,20,15,16});
        Students student2 = new Students("Armen",  "Vardanyan", "2000.08.25",  new int[]{13,11,17,16,10});
        Students student3 = new Students("Anna",  "Militonyan", "2001.07.15", new int[]{20,17,16,10,18});
        Students student4 = new Students("Levon",  "Petrosyan", "2001.11.04", new int[]{14,12,8,7,10});
        Students student5 = new Students("Arshak",  "Arshakyan", "2001.10.21",  new int[]{10,10,2,3,5});
        Students student6 = new Students("Marine",  "Makaryan", "2000.08.17", new int[]{18,17,15,14,15});
        Students student7 = new Students("Anna",  "Voskanyan", "2001.03.11", new int[]{4,7,4,8,4});
        this.students = new Students[]{student1, student2, student3, student4, student5, student6, student7};
        return students;
    }
    public void showStudents(){
        addStudents();
        for (Students student : students) {
            System.out.println(student);
        }
    }
    public void alphabeticalSort() {
        addStudents();
        int lengthOfArray  = this.students.length;
        for (int i = 0; i < lengthOfArray - 1; ++i) {
            for (int j = 0; j < lengthOfArray - i - 1; ++j) {
                if (this.students[j].getName().compareTo(this.students[j + 1].getName()) > 0) {
                    Students temporary = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = temporary;
                } else if (this.students[j].getName().compareTo(this.students[j + 1].getName()) == 0) {
                    if (this.students[j].getSurName().compareTo(this.students[j + 1].getSurName()) > 0) {
                        Students temporary = this.students[j];
                        this.students[j] = this.students[j + 1];
                        this.students[j + 1] = temporary;
                    }
                }
            }
        }
    }
    public void printStudentsAlphabetical() {
        this.alphabeticalSort();
        Students[] student = this.students;
        for (Students s : student) {
            System.out.println(s);
        }

    }

  public void primeAndPalindrome(){
        addStudents();
      for(int i = 0; i< students.length; i++ ){
          if(students[i].isPrime() && students[i].IsPalindrome()){
              System.out.println(students[i]);
          }
      }
  }

}
