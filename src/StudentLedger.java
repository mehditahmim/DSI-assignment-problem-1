import java.util.ArrayList;
import java.util.HashMap;


public class StudentLedger {

    private int totalEarnings, totalDaysTaught;
    private HashMap<Integer, Integer> daysTaughtInEachClass;
    private HashMap<Integer, Integer> earningInEachClass;
    private HashMap<String, Integer> earningOfEachSubject;
    private ArrayList<Student> listOfStudents;

    
    public StudentLedger() {
    	
    	this.totalEarnings = 0;
    	this.totalDaysTaught = 0;
    	this.daysTaughtInEachClass = new HashMap<>();
    	this.earningInEachClass = new HashMap<>();
    	this.earningOfEachSubject = new HashMap<>();  	
    	this.listOfStudents = new ArrayList<>();
    	daysTaughtInEachClass.put(8,0);
    	daysTaughtInEachClass.put(9,0);
    	daysTaughtInEachClass.put(10,0);
		earningInEachClass.put(8, 0);
		earningInEachClass.put(9, 0);
		earningInEachClass.put(10, 0);
		earningOfEachSubject.put("Maths",0);
		earningOfEachSubject.put("English",0);
		earningOfEachSubject.put("Bangla",0);
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
    
    public void  addNewStudent(String name, int cls, boolean[] subjects) {
    	
    	Student s = new Student(name, cls, subjects);
    	listOfStudents.add(s);
    	System.out.println("The student named: " + s.getName() +" and id:"+ s.getId()+ " is added");
    	
    }
    
    public boolean increaseDays(int id, int days) {
    	
    	Student s = searchStudent(id);
    	if(s == null) return false;
    	System.out.println("students information before updating days:");
    	System.out.println(s +"\n");
    	int cls = s.getCls();
    	totalDaysTaught += days;
    	s.addDaysTaught(days);
    	totalEarnings += s.getEarning();
    	
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
        System.out.println("students information after updating days");
        System.out.println(s+"\n");
        return true;
    }
    
    public boolean addMarks(int id, int marks) {
    	
    	Student s = searchStudent(id);
    	if (s == null) return false;
    	System.out.println("students information before updating days:");
    	System.out.println(s +"\n");
    	s.addMarks(marks);
    	System.out.println("students information after updating days");
        System.out.println(s+"\n");
    	return true;
    }
    
    public boolean deleteStudent(int id) {
    	
    	Student s = searchStudent(id);
    	System.out.println(s);
    	if (s == null) return false;
    	
    	totalDaysTaught -= s.getDaysTaught();
    	int cls = s.getCls();
    	if(daysTaughtInEachClass.containsKey(cls))
    	{
    		int newDays = daysTaughtInEachClass.get(cls) - s.getDaysTaught(); 
        	System.out.println(newDays);
        	daysTaughtInEachClass.put(cls, newDays);
        	
    	}
    	
    	listOfStudents.remove(s);
    
    	return true;
    			
    	
    }
    
    public ArrayList<Student> getStudentsOfOneClass(int cls){
    	ArrayList<Student> studentOfOneClass = new ArrayList<>();
    	for(Student s:listOfStudents) {
    		if (s.getCls() == cls) {
    			studentOfOneClass.add(s);
    		}
    	}
    	return studentOfOneClass;
    }
    
    public float getAverageMarksOfAllStudents() {
    	
    	float totalMark = 0;
    	for(Student s:listOfStudents) {
    		totalMark = totalMark + s.getTotalMarks();
    	}
    	return (float)totalMark/ listOfStudents.size();
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
