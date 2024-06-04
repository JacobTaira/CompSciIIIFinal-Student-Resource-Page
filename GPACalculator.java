import java.util.ArrayList;
import java.util.*;
import java.math.BigDecimal;

import mayflower.*;
public class GPACalculator extends ParentUI
{
    public Subject[] subjects = new Subject[5];
    public String gpaLabel = "Weighted GPA";
    public String gpaNumber = "";;
    public double gpa = 0.0;
    private MouseInfo mouse;
    private SubjectTabs math;
    private SubjectTabs english;
    private SubjectTabs science;
    private SubjectTabs socialStudies;
    private SubjectTabs lote;
    
    private Subject sub1;
    private Subject sub2;
    private Subject sub3;
    private Subject sub4;
    private Subject sub5;
    public GPACalculator(){
        super();
        setBackground("img/whiteBackground.jpg");
        addObject(new titleLabel("GPACalculator"), 550, 0);
        mouse = Mayflower.getMouseInfo();
        
        math = new SubjectTabs("Math");
        english = new SubjectTabs("English");
        science = new SubjectTabs("Science");
        socialStudies = new SubjectTabs("SocialStudies");
        lote = new SubjectTabs("LOTE");
        
        Mayflower.showBounds(false);
        createLabels();
    }
    
    public void createLabels(){
        addObject(math, 412, 150);
        addObject(english, 675, 150);
        addObject(science, 938, 150);
        addObject(socialStudies, 500, 375);
        addObject(lote, 850, 375);
        // 0 = math, 1 = english, 2 = science, 3 = socialstudies, 4 = lote
        // Make the 5 buttons and paste them on the page, make separate "subject" classes that use a listmap to store up to 
        // 8 classes, each with a key and value (the value will be different aspects of a class)
        // Don't need to check if you're adding to the right list because the "adding course" function will only be
        // available after you click on the button from the GPA Calculator page for each of the classes
    }
    
    public void updateGPANumber(double updated){
         String temp = (String) String.format("%.4f", updated);
         gpa = Double.parseDouble(temp);
        gpaNumber = "" + gpa;
        //showText(gpaNumber, 28, 55, 560, Color.GREEN);
        this.removeText(55, 650);
        this.showText(gpaNumber, 28, 55, 560, Color.GREEN);
    }

    public void displayGPA(){
        showText(gpaLabel, 28, 55, 525, Color.WHITE);
        gpaNumber = "" + gpa;
        showText(gpaNumber, 28, 55, 560, Color.GREEN);
    }
    
    
    public void act(){
        mouse = Mayflower.getMouseInfo();
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            updateGPANumber(gpa + 0.1);
        if(mouse.getButton() == 1 && mouse.getActor() == getHome()){
            Mayflower.setWorld(StudentResourcePage.getTitleScreen());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getReset()){
            Mayflower.setWorld(StudentResourcePage.getGPACalculator());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getExit()){
            Mayflower.exit();
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == math){
            if(subjects[0] == null){
                sub1 = new Subject(this, "Math");
                subjects[0] = sub1;}
            Mayflower.setWorld(sub1);
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == english){
            if(subjects[1] == null){
                sub2 = new Subject(this, "English");
                subjects[1] = sub2;}
            Mayflower.setWorld(sub2);
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == science){
            if(subjects[2] == null){
                sub3 = new Subject(this, "Science");
                subjects[2] = sub3;}
            Mayflower.setWorld(sub3);
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == socialStudies){
            if(subjects[3] == null){
                sub4 = new Subject(this, "SocialStudies");
                subjects[3] = sub4;}
            Mayflower.setWorld(sub4);
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == lote){
            if(subjects[4] == null){
                sub5 = new Subject(this, "LOTE");
                subjects[4] = sub5;}
            Mayflower.setWorld(sub5);
        }
    }
    
    public void calculateFinalGPA(){
        double total = 0.0;
        int numSubjects = 0;
        for(Subject subject : subjects){
            if(subject != null){
                total += subject.calculateSubjectGPA();
                //System.out.println(subject.calculateSubjectGPA());
                numSubjects++;
            }
        }
        updateGPANumber(total / numSubjects);
        displayGPA();
    }
}
