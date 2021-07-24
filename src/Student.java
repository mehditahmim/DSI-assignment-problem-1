import java.util.concurrent.atomic.AtomicInteger;

public class Student {
	
 private static final AtomicInteger count = new AtomicInteger(0); 
 private final int id;
 private String name;
 private int cls;
 private boolean[] subjects;
 private float averageMarks;
 private int totalMarks;
 private int earning;
 private int daysTaught;
 
 
public Student(String name, int cls, boolean[] listOfSubjects) {
	
    this.name = name;
	id = count.incrementAndGet(); 
	this.cls = cls;
	this.subjects = listOfSubjects;
	this.averageMarks = 0;
	this.totalMarks = 0;
	this.earning = 0;
	this.daysTaught = 0;
	
}

public int numberOfSubjects() {
	
	int numberOfSubjects = 0;	
	for(boolean sub:subjects) {
		if(sub) numberOfSubjects += 1;
	}
	return numberOfSubjects;
}
 
public void calculateAverageMark() {
	
	averageMarks = (float)totalMarks/numberOfSubjects();

}

public void addMarks(int marks) {
	
	totalMarks += marks;
	calculateAverageMark();
}

public void addDaysTaught(int days) {
	
	daysTaught += days;
	calculateEarning();
}

public void calculateEarning() {
	
	earning = numberOfSubjects() * daysTaught;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public int getCls() {
	return cls;
}

public void setCls(int cls) {
	this.cls = cls;
}

public float getAverageMarks() {
	return averageMarks;
}

public boolean[] getListOfSubjects() {
	return subjects;
}

public void setListOfSubjects(boolean[] listOfSubjects) {
	this.subjects = listOfSubjects;
}

public int getTotalMarks() {
	return totalMarks;
}


public int getEarning() {
	return earning;
}


public int getDaysTaught() {
	return daysTaught;
}

@Override
public String toString() {
	return "Student [name=" + name + ", cls=" + cls + ", averageMarks=" + averageMarks + ", totalMarks=" + totalMarks
			+ ", earning=" + earning + "]";
}


 
}
