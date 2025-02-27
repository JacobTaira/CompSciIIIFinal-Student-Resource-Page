import mayflower.*;

public class StudentResourcePage extends Mayflower 
{
    //Constructor
    private static TitleScreen titleScreen;
    private static GPACalculator gpa;
    private static StudentPlanner planner;
    public StudentResourcePage()
    {
        super("Student Resource Page", 1200, 650);
        //titleScreen = new TitleScreen();
        //gpa = new GPACalculator();
        //planner = new StudentPlanner();
    }

    public void init()
    {
        //Runs program in full screen mode
        Mayflower.setFullScreen(true);
        titleScreen = new TitleScreen();
        gpa = new GPACalculator();
        planner = new StudentPlanner();
        World title =  titleScreen;
        Mayflower.setWorld(title);
    }
    
    public static GPACalculator getGPACalculator(){
        return gpa;
    }
    
    public static TitleScreen getTitleScreen(){
        return titleScreen;
    }
    
    public static StudentPlanner getStudentPlanner(){
        return planner;
    }
}
