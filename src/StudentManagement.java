import java.util.ArrayList;
import java.util.HashMap;
public class StudentManagement {

    private int totalEarnings, totalDaysTaught;
    private HashMap<Integer, Integer> daysTaughtInEachClass;
    private HashMap<Integer, Integer> earningInEachClass;
    private HashMap<String, Integer> earningOfEachSubject;
    //private HashMap<Integer, Student> studentsInEachClass;
    private ArrayList<Student> listOfStudents;

    
    public StudentManagement() {
    	
    	this.totalEarnings = 0;
    	this.totalDaysTaught = 0;
    	this.daysTaughtInEachClass = new HashMap<>();
    	this.earningInEachClass = new HashMap<>();
    	this.earningOfEachSubject = new HashMap<>();  	
    	this.listOfStudents = new ArrayList<>();
    }
    
    public Student searchStudent(int id) {
    	
    	for(Student s:listOfStudents) {
    		if(s.getId() == id) 
    		{
    			return s;
    		}
    	}
    	return null;
    }
    
    public Student  addNewStudent(String name, int cls, boolean[] subjects) {
    	
    	Student s = new Student(name, cls, subjects);
    	listOfStudents.add(s);
    	System.out.println("The student named" + s.getName() +" and id"+ s.getId()+ " is added");
    	return s;
    }
    
    public boolean increaseDays(int id, int days) {
    	
    	Student s = searchStudent(id);
    	if(s == null) return false;
    	int cls = s.getCls();
    	totalDaysTaught += days;
    	s.addDaysTaught(days);
    	totalEarnings += s.getEarning();
    	boolean isExecute = false;

    	if (isExecute == false)
    	{
    		daysTaughtInEachClass.put(cls,0);
    		earningInEachClass.put(cls, 0);
    		earningOfEachSubject.put("Maths",0);
    		earningOfEachSubject.put("English",0);
    		earningOfEachSubject.put("Bangla",0);
    		isExecute = true;
    	}
    	
    	boolean[] listOfSubjects = s.getListOfSubjects();
    	int newDays = daysTaughtInEachClass.get(cls) + days;
    	daysTaughtInEachClass.put(cls, newDays);
    	int subjects = 0;
    	for(int i = 0; i<listOfSubjects.length; i++) {
    		
    		if (listOfSubjects[i] == true) subjects = subjects + 1;
    	}
    	
    	int newEarningOfClass = earningInEachClass.get(cls) + subjects * days;
    	earningInEachClass.put(cls, newEarningOfClass);
        
        
        if(listOfSubjects[0] == true)
        {
        	int newEarnings = earningOfEachSubject.get("Maths") + days;
        	earningOfEachSubject.put("Maths", newEarnings);
        }
        if(listOfSubjects[1] == true)
        {
        	int newEarnings = earningOfEachSubject.get("English") + days;
        	earningOfEachSubject.put("English", newEarnings);
        }
        if(listOfSubjects[2] == true)
        {
        	int newEarnings = earningOfEachSubject.get("Bangla") + days;
        	earningOfEachSubject.put("Bangla", newEarnings);
        }
        return true;
    }
    
    public boolean addMarks(int id, int marks) {
    	
    	Student s = searchStudent(id);
    	if (s == null) return false;
    	s.addMarks(marks);
    	return true;
    }
    
    public boolean deleteStudent(int id) {
    	
    	Student s = searchStudent(id);
    	
    	if (s == null) return false;
    	
    	totalDaysTaught -= s.getDaysTaught();
    	int cls = s.getCls();
    	int newDays = daysTaughtInEachClass.get(cls) - s.getDaysTaught(); 
    	daysTaughtInEachClass.put(cls, newDays);
    	listOfStudents.remove(s);
    	return true;
    			
    	
    }

	public int getTotalEarnings() {
		return totalEarnings;
	}


	public int getTotalDaysTaught() {
		return totalDaysTaught;
	}


	public HashMap<Integer, Integer> getDaysTaughtInEachClass() {
		return daysTaughtInEachClass;
	}


	public HashMap<Integer, Integer> getEarningInEachClass() {
		return earningInEachClass;
	}



	public HashMap<String, Integer> getEarningOfEachSubject() {
		return earningOfEachSubject;
	}


	public ArrayList<Student> getListOfStudents() {
		return listOfStudents;
	}


    
    
    
    	
}
