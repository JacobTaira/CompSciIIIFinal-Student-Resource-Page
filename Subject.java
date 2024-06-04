import mayflower.*;
import java.util.*;
public class Subject extends ParentUI
{
    private double gpa;
    private String gpaNumber;
    private String gpaLabel;
    
    private MouseInfo mouse;
    private PanelButton addCourse;
    
    private Course test1;
    private Course test2;
    private Course test3;
    private Course test4;
    private Course test5;
    
    Set<String> courseNames = new MySet<String>();
    private boolean right = false;
    private ListMap<String, Course> courses = new ListMap<String, Course>();
    
    private Course[][] grid = new Course[4][2];
    //we're adding the course labels halfway through the screen, so it's gonna be 4 rows, 2 columns. To know if we need to add
    // the next label on the right half of the screen, using the right variable to check. After adding a label, change the boolean to true (or false)
    
    public Subject(GPACalculator past, String course){
        super();
        setBackground("img/whiteBackground.jpg");
        
        courses = new ListMap(); // arguments?
        
        addCourse = new PanelButton("addCourse");
        addObject(addCourse, 25, 75);
        gpaLabel = "Weighted GPA";
        gpa = StudentResourcePage.getGPACalculator().gpa;
        gpaNumber = StudentResourcePage.getGPACalculator().gpaNumber;
        //StudentResourcePage.getGPACalculator().displayGPA();
        displayGPA();  
    
        mouse = Mayflower.getMouseInfo();
        /*
        test1 = new Course(CourseLevel.AP,"tester", 0, 0);
        test2 = new Course(CourseLevel.AP,"tester", 0, 0);
        test3 = new Course(CourseLevel.ON_LEVEL,"tester", 0, 0);
        test4 = new Course(CourseLevel.ADVANCED,"tester", 0, 0);
        test5 = new Course(CourseLevel.ADVANCED,"tester", 0, 0);
        addObject(test1, 325, 40);
        addObject(test2, 325, 180);
        addObject(test3, 325, 320);
        addObject(test4, 325, 460);
        addObject(test5, 755, 40);*/
        // First Column: 325  Second Column: 755; 1st Row: 40, 2nd Row: 180, 3rd Row: 320, 4th: 460
        }
    
    public void act(){
        mouse = Mayflower.getMouseInfo();
        //System.out.println(mouse.getActor());
        if(mouse.getButton() == 1 && mouse.getActor() == getHome()){
            Mayflower.setWorld(new TitleScreen());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getReset()){
            Mayflower.setWorld(StudentResourcePage.getGPACalculator());
            //parent.displayGPA();
            //When you click "Reset" and redisplay parent, the Weighted GPA number doesn't stay the same and it goes back to 0.0
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getExit()){
            Mayflower.exit();
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getAddCourse()){
            //System.out.println(calculateSubjectGPA());
            newCourse();
            //System.out.println(calculateSubjectGPA());
            StudentResourcePage.getGPACalculator().calculateFinalGPA();
            updateGPANumber();
            //this.showText(gradeValue, 
            //Scanner is not working, text is printing out but the program isn't asking for a user input
            //If able to get user input, set courseName = input. Then use the string to use the "put" method for ListMaps and add the courseName as a key. 
            //Store the value as a new Course Object with different instance variables like grade, gpa, teacher, period, etc.
        }
    }
    
    public void newCourse(){        
        //Instead of using a scanner, each course will not have a name and will only have the numerical grade scale. When add course is clicked, pull up a number bar that increases in ones
        //that users can interact with using up and down arrows. Print the directions in the terminal where up arrow is +1, down arrow is -1, and ENTER submits the grade. Do this twice
        //For each semester whenever the "add new course button is pressed"
        //Overview -> All Classes -> Mayflower -> ask() method puts a pop-up prompt to ask for user input?
        
        String inputLevel = Mayflower.ask("Please enter one of the following course levels: [AP, ADVANCED, ON_LEVEL]");
        CourseLevel level = null;
        boolean courseLevelGood = false;
        while(!courseLevelGood){
            if(inputLevel == null)
                return;
            else if(inputLevel.equals("AP"))
                level = CourseLevel.AP;
            else if(inputLevel.equals("ADVANCED"))
                level = CourseLevel.ADVANCED;
            else if(inputLevel.equals("ON_LEVEL"))
                level = CourseLevel.ON_LEVEL;
            
            if(level == null)
                inputLevel = Mayflower.ask("*ERROR* Please enter either AP, ADVANCED, or ON_LEVEL:");
            else
                courseLevelGood = true;
        }

        String inputName = level + " " + Mayflower.ask("Please enter the course name: ");
        if(level != null && inputName != null){
            while(courseNames.contains(inputName)){
                inputName = level + " " + Mayflower.ask("*ERROR* Please enter a NEW course name: ");
            }
            courseNames.add(inputName);
        }
        
        boolean semOneGood = false;
        int sem1Grade = 100;   
        String semOne = Mayflower.ask("Please enter semester 1 grade: ");   
        while(!semOneGood){
            if(semOne == null)
                return;
            else {
                sem1Grade = (int) Math.round(Double.parseDouble(semOne));}   
            
            if(sem1Grade < 0 || sem1Grade > 100)
                semOne = Mayflower.ask("*ERROR* Please enter a VALID semester 1 grade (0-100): ");
            else
                semOneGood = true;
            
        }
            
        
        boolean semTwoGood = false;
        int sem2Grade = 100;
        String semTwo = Mayflower.ask("Please enter semester 2 grade: ");
        while(!semTwoGood){
            if(semTwo == null)
                return;
            else{    
                sem2Grade = (int) Math.round(Double.parseDouble(semTwo));  
             }
             
             if(sem2Grade < 0 || sem2Grade > 100)
                 semTwo = Mayflower.ask("*ERROR* Please enter a VALID semester 2 grade(0-100): ");
             else
                 semTwoGood = true;
        }
        
        if(inputName != null && level != null){
            Course added = new Course(level, inputName, sem1Grade, sem2Grade); 
            courses.put(inputName,added);
            displayCourse(inputName);
        }
                
    }
    
    public double calculateSubjectGPA(){
        ArrayList<Double> semesterGrades = new ArrayList<Double>();
        
        int numSemesters = courses.size() * 2;
        //System.out.println("Number of Semesters " + numSemesters);
        if(numSemesters == 0)
            return 0.0;
        List<Course> classes = courses.values();
        for(Course thing : classes){
            semesterGrades.add(thing.getGrade(1));
            semesterGrades.add(thing.getGrade(2));
        }
        
        Collections.sort(semesterGrades);
        double sum = 0;
        if(numSemesters > 8){
            for(int i = 0; i < 8; i++)
                sum += semesterGrades.remove(semesterGrades.size() - 1); }
        else
            for(Double gpa : semesterGrades)
                sum += gpa;
        
        if(numSemesters > 8)
            return (sum / 8);
        return (sum / numSemesters);
    }

    public void displayGPA(){
        showText(StudentResourcePage.getGPACalculator().gpaLabel, 28, 55, 525, Color.WHITE);
        StudentResourcePage.getGPACalculator().gpaNumber = "" + StudentResourcePage.getGPACalculator().gpa;
        showText(StudentResourcePage.getGPACalculator().gpaNumber, 28, 55, 560, Color.GREEN);
    }
    
    public void updateGPANumber(){
        //showText(gpaNumber, 28, 55, 560, Color.GREEN);
        //showText(StudentResourcePage.getGPACalculator().gpaLabel, 28, 55, 525, Color.WHITE);
        this.removeText(55, 650);
        this.showText(StudentResourcePage.getGPACalculator().gpaNumber, 28, 55, 560, Color.GREEN);
    }
    
    //Need code to override when more than 8 courses are add. Just put a new course box on top of the lowest GPA previously
    public void displayCourse(String key){
        int row = 0;
        int col = 0;
        outerLoop:
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == null){
                    grid[r][c] = courses.get(key);
                    row = r;
                    col = c;
                    break outerLoop;
                }
            }
        }
        
        int xLocation = 325 + (430 * col);        
        int yLocation = 40 + (140 * row);
        
        addObject(courses.get(key), xLocation, yLocation);
        showText(key, 13, xLocation + 110, yLocation + 28, Color.BLACK);
        showText(Double.toString(courses.get(key).getFirstGPA()), 13, xLocation + 55, yLocation + 53, Color.BLACK);
        showText(Double.toString(courses.get(key).getSecondGPA()), 13, xLocation + 55, yLocation + 78, Color.BLACK);
        showText(Integer.toString(courses.get(key).getFirstSemesterGrade()), 13, xLocation + 255, yLocation + 53, Color.BLACK);
        showText(Integer.toString(courses.get(key).getSecondSemesterGrade()), 13, xLocation + 255, yLocation + 78, Color.BLACK);
    }
    }
