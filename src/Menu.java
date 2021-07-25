import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

  Scanner sc;
  StudentLedger ledger;
  
  public Menu() {
	  sc = new Scanner(System.in);
	  ledger = new StudentLedger();
  }
  
  
  public void takeInput() {
      System.out.println("Please select a number from 1 to 5");

      try {
          int userInput = sc.nextInt();

          switch (userInput) {
              case 1:
            	  addStudent(sc);
                  break;
              case 2:
                   editStudent(sc);
                  break;
              case 3:
            	  deleteStudent(sc); 
            	  break;
            	  
              case 4:
            	  getStudentInformation(sc);
                  break;
                  
              case 5:
            	  seeOverallInfo();
            	  break;
              case 6:    
                   System.exit(0);
              default:
                  throw new Exception();
          }
      } catch (Exception e) {
          System.out.println("Please provide the natural number from 1 to 6");
          takeInput();
      } 
      finally {
    	  sc.close();
      }
  }
  
  public void mainMenu() {
	  

	  String inputLine = "\nChoose an option (Use number)\n--------------------------------------------------" +
	     "\n1. Add a student \n2. Edit a student\n3. Delete a student\n4. List Of students\n5. See overall info\n6. Exit\n--------------------------------------------------";
	  System.out.println(inputLine);
	  takeInput();
	  
  }
  
  public void addStudent(Scanner sc) {
	   
	  String name;
	  sc.nextLine();
	  int cls;
	  System.out.println("Enter name of the student:");
	  name = sc.nextLine(); 
	  System.out.println("Enter class:");
	 
	  while (true) {
		 cls = sc.nextInt();
	
		  if(cls < 8 || cls > 10) {
			  System.out.println("The class number should be between 8 to 10");
		  }
		  else {
			  break;
		  }
	  }
	
	  
	  boolean[] subjects = {false,false, false};
	  System.out.println("press '1' if you teach a subject else press '0'");
	  
	  while(true) {
		  System.out.println("Maths");
		  int m = sc.nextInt();	  
		  if (m == 0 || m== 1) {
			  if (m == 1) {
				  subjects[0] = true;
			  }
			  break;
		  }
		  
		  
	  }
	  while(true) {
		  System.out.println("English");	 
		  int e = sc.nextInt();
		  if(e==0 ||e==1) {
			  if (e == 1) {
				  subjects[1] = true;
			  }
			  break;
		  }
		 
	  }
	  
	  while(true) {
		  System.out.println("Bangla");
		  int b = sc.nextInt();	  
		  if(b == 0 || b == 1) {
			  if (b == 1) {
				  subjects[2] = true;  
			  }
			  break;
		  }
		 
	  }
	 
	  
	  ledger.addNewStudent(name, cls, subjects);
	  mainMenu();
  }
  
  public void addStudent() {
	  
	  ledger.addNewStudent("Tahmim", 8, new boolean[] {true, true, false});
	  ledger.addNewStudent("Mehdi", 8, new boolean[] {true, false, true});
	  ledger.addNewStudent("Shakib", 8, new boolean[] {true, true, true});
	  ledger.addNewStudent("Soumya", 9, new boolean[] {true, true, false});
	  ledger.addNewStudent("Liton", 9, new boolean[] {false, true, true});
	  ledger.addNewStudent("Mushfiq", 9, new boolean[] {true, false, false});
	  ledger.addNewStudent("naim", 10, new boolean[] {true, true, true});
	  ledger.addNewStudent("Mashrafee", 10, new boolean[] {false, true, true});
	  ledger.addNewStudent("Mustafiz", 10, new boolean[] {true, true, false});
	  ledger.addNewStudent("Saifuddin", 10, new boolean[] {false, false, true});
  }
  
  public void deleteStudent(Scanner sc) {
	  
	  System.out.println("Please enter id of the student to be deleted");
	  int id = sc.nextInt();
	  boolean result = ledger.deleteStudent(id);
	  
	  if (result) 
		  System.out.println("The student is deleted");
	  
	  else {
		  System.out.println("The student with this id is not found");
		
	  }
	  System.out.println(result);
	  mainMenu();
		  
  }
  
  public void editStudent(Scanner sc) {
	  System.out.println("Please  choose between the 2 options(use numbers)");
	  System.out.println("-------------------------------------------------");
	  System.out.println("1.Add days\n");
	  System.out.println("2.Add marks\n");
	  System.out.println("3.Go back");
	  int inp;
	  while(true) {
		  inp = sc.nextInt();
		  if (inp >= 1 && inp <=3) break;
	  }
	  try {
		  
		  switch (inp) {
		  
	      case 1:
	    	  addDaysToStudent(sc);
	          break;
	          
	      case 2:
	    	  addMarksToStudent(sc);
	    	  break;
	    	  
	      case 3:
	    	  mainMenu();
	    	  break;
	    	  
	      default:
              throw new Exception(); 	  
	  }
	  } catch (Exception e) {
          System.out.println("Please provide a natural number from 1 to 3");
          editStudent(sc);
	  } 

}
	  
  public void addDaysToStudent(Scanner sc) {
	  
 
	  System.out.println("Enter Id of the student:");
	  int id = sc.nextInt();
	  System.out.println("Enter the days to increase:");
	  int days = sc.nextInt();
	  
	  boolean result = ledger.increaseDays(id, days);
	  
	  if(result) {
		  System.out.println("The days are added to the student profile");
	  }
	  else {
		  System.out.println("The student with this id is not found");
		  
	  }
	  editStudent(sc);
  }
  
  
  public void addMarksToStudent(Scanner sc) {
	  
  
	  System.out.println("Enter Id of the student:");
	  int id = sc.nextInt();
	  System.out.println("Enter the marks to add:");
	  int days = sc.nextInt();
	  
	  boolean result = ledger.addMarks(id, days);
	  
	  if(result) {
		  System.out.println("The marks are added to the student profile");
	  }
	  else {
		  System.out.println("The student with this id is not found");
		  
	  }
	  editStudent(sc);
  }
  
  public void getStudentInformation(Scanner sc) {
	  System.out.println("----------------------------------------------------");
	  System.out.println("1. press 1 to view students of an individual class");
	  System.out.println("2. press 2 to view one particular student");
	  System.out.println("3. press 3 to go back");
	  System.out.println("-----------------------------------------------------");
	  int inp = sc.nextInt();
	  
	  try {	  
		  switch (inp) {
		  
	      case 1:
	    	  viewListOfStudents(sc);
	          break;
	          
	      case 2:
	    	  viewIndividualStudent(sc);
	    	  break;
	    	  
	      case 3:
	    	  mainMenu();
	    	  break;
	    	  
	      default:
              throw new Exception(); 	  
	  }
		  
	  } catch (Exception e) {
          System.out.println("Please provide a natural number from 1 to 3");
          getStudentInformation(sc);
	  } finally {
		  sc.close();
	  }  
	  
  }
	  
	  
public void viewListOfStudents(Scanner sc) {
	System.out.println("Enter the class number(8 to 10) to view the students");
	  int cls;
	  
	  while (true) {
		  cls = sc.nextInt();
		  if(cls < 8 || cls > 10) {
			  System.out.println("The class number should be between 8 to 10");
		  }
		  else {
			  break;
		  }
	  }
	  
	  ArrayList<Student> students = ledger.getStudentsOfOneClass(cls);
	  
	  System.out.println("--------------------------------------------------");
	  System.out.printf("%10s %22s %15s", "Name", "Total earning", "Average");
	  System.out.println();
	  System.out.println("--------------------------------------------------");
	  for(Student s:students) {
			 System.out.format("%10s %15s %22s", s.getName(),
	                    s.getEarning(), s.getAverageMarks());
			 System.out.println();	
		}
		System.out.println("--------------------------------------------------");
	  
	  mainMenu();
}

public void viewIndividualStudent(Scanner sc) {
	
	System.out.println("Enter the id of the student");
	int id = sc.nextInt();
	Student s = ledger.searchStudent(id);
	if(s == null) {
		System.out.println("There is no student with this id.");
	}
	else {
		System.out.println(s);
	}
	
	mainMenu();
	
}


public void seeOverallInfo() {
	
	System.out.println("Total days taught across all class: "+ ledger.getTotalDaysTaught()+"\n");
	System.out.println("Days taught in class 8: "+ ledger.getDaysTaughtInEachClass().get(8)+"\n");
	System.out.println("Days taught in class 9: "+ ledger.getDaysTaughtInEachClass().get(9)+"\n");
	System.out.println("Days taught in class 10: "+ ledger.getDaysTaughtInEachClass().get(10)+"\n");
	System.out.println("Total earnings: "+ ledger.getTotalEarnings()+"\n");
	System.out.println("Earning of class 8: "+ledger.getEarningInEachClass().get(8)+" \n");
	System.out.println("Earning of class 9: "+ledger.getEarningInEachClass().get(9)+" \n");
	System.out.println("Earning of class 10: "+ledger.getEarningInEachClass().get(10)+" \n");
	System.out.println("Earning from Maths: "+ledger.getEarningOfEachSubject().get("Maths")+" \n");
	System.out.println("Earning from English: "+ledger.getEarningOfEachSubject().get("English")+" \n");
	System.out.println("Earning from Bangla: "+ledger.getEarningOfEachSubject().get("Bangla")+" \n");
	System.out.println("Average marks of all students: "+ledger.getAverageMarksOfAllStudents());
	mainMenu();
}
	  
  
  
  
  
  
  



}
