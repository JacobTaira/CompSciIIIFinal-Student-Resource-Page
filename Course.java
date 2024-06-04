import mayflower.*;
import java.lang.Math;
public class Course extends Actor
{
    private MayflowerImage label;
    private String className;
    private CourseLevel level;
    private int firstSemGrade;
    private int secondSemGrade;
    private double firstGPA;
    private double secondGPA;
    //private String teacher;
    //private int period;
    public Course(CourseLevel lev, String name, int sem1, int sem2){
        label = new MayflowerImage("img/courseLabel.png");
        label.crop(0,0,1200,200);
        label.scale(415,100);
        className = name;
        level = lev;
        firstSemGrade = sem1;
        secondSemGrade = sem2;
        calculateGPA();
        setImage(label);
    }
    
    public void act(){
        
    }
    
    public void enterGrade(double grade, int semester){
        int temp = (int) Math.round(grade);
        if(semester == 1)
            firstSemGrade = temp;
        else if(semester == 2)
            secondSemGrade = temp;
    }
    
    public int getFirstSemesterGrade(){
        return firstSemGrade;
    }
    
    public int getSecondSemesterGrade(){
        return secondSemGrade;
    }
    
    public double getFirstGPA(){
        return firstGPA;
    }
    
    public double getSecondGPA(){
        return secondGPA;
    }
    
    public void calculateGPA(){
        double gpa = 0;
        if(level == CourseLevel.AP)
            gpa = 6.0;
        else if(level == CourseLevel.ADVANCED)
            gpa = 5.5;
        else
            gpa = 5.0;
        firstGPA = gpa;
        for(int i = 100; i > firstSemGrade; i--)
            firstGPA -= .1;
        String temp1 = (String) String.format("%.4f", firstGPA);
        firstGPA = Double.parseDouble(temp1);
        
        //System.out.println(firstGPA);
        secondGPA = gpa;
        for(int i = 100; i > secondSemGrade; i--)
            secondGPA -= .1;
        String temp2 = (String) String.format("%.4f", secondGPA);
         secondGPA = Double.parseDouble(temp2);
        //System.out.println(secondGPA);
    }
    
    public double getGrade(int semester){
        return semester == 1 ? firstGPA : secondGPA;
    }
}
