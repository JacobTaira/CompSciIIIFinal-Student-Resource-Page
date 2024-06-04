import mayflower.*;
import java.util.*;
public class StudentPlanner extends ParentUI
{
    private MouseInfo mouse;
    public StudentPlanner(){
        super();
        setBackground("img/whiteBackground.jpg");
        addObject(new titleLabel("StudentPlanner"), 550, 8);
        mouse = Mayflower.getMouseInfo();
        Mayflower.showBounds(false);
    }
    
    public void act(){
        mouse = Mayflower.getMouseInfo();
        if(mouse.getButton() == 1 && mouse.getActor() == getHome()){
            Mayflower.setWorld(new TitleScreen());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getReset()){
            Mayflower.setWorld(new StudentPlanner());
        }
        else if(mouse.getButton() == 1 && mouse.getActor() == getExit()){
            Mayflower.exit();
        }
    }
}
