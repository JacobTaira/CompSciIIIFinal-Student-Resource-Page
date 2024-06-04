import mayflower.*;
import java.util.Scanner;
public class TitleScreen extends ParentUI
{
    private TitleButton gpa;
    private TitleButton planner;
    private MouseInfo mouse;
    public TitleScreen(){
       super();
       setBackground("img/whiteBackground.jpg");
       addObject(new titleLabel("titleScreen"), 400, 10);
       gpa = new TitleButton("GPA");
       planner = new TitleButton("Planner");
       addObject(gpa, 450, 200);
       addObject(planner, 450, 425);
       mouse = Mayflower.getMouseInfo();
       //Mayflower.showBounds(true);
    }
    
    public void act(){
        //Mouse.getButton() returns a value depending on what is being clicked: 0 = nothing clicked, 1 = left button, 2 = middle button, 3 = right button
        mouse = Mayflower.getMouseInfo();
        //System.out.println(mouse.getActor());
        if(mouse.getButton() == 1 && mouse.getActor() == gpa){
            Mayflower.setWorld(StudentResourcePage.getGPACalculator());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == planner){
            Mayflower.setWorld(StudentResourcePage.getStudentPlanner());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getHome()){
            Mayflower.setWorld(StudentResourcePage.getTitleScreen());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getReset()){
            Mayflower.setWorld(StudentResourcePage.getTitleScreen());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getExit()){
            Mayflower.exit();
        }
    }
}
