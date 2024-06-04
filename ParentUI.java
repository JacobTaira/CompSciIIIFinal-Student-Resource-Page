import mayflower.*;
public class ParentUI extends World implements Mouse
{
    private Panel sidePanel;
    private PanelButton home;
    private PanelButton reset;
    private PanelButton exit;
    private PanelButton addCourse;
    public ParentUI(){
        home = new PanelButton("home");
        reset = new PanelButton("reset");
        exit = new PanelButton("exit");
        addCourse = new PanelButton("addCourse");
        
        addObject(addCourse, 25, 75);
        addObject(home, 25, 173);
        addObject(reset, 25, 280);
        addObject(exit, 25, 392);
        //Mayflower is weird because if you add panel after the button objects, it detects the presence of the buttons, but you
        // can't actually see the buttons. We edited the panel image to have the buttons to be visible, but
        // the actual buttons are under the panel
        addObject(new Panel(), 0, 0);
        addObject(new PanelTitle(), 0, 0);
    }
     
    public void act(){
        
    }
    
    public PanelButton getHome(){
        return home;
    }
    
    public PanelButton getReset(){
        return reset;
    }
    
    public PanelButton getExit(){
        return exit;
    }
    
    public PanelButton getAddCourse(){
        return addCourse;
    }
    
    public void addCourseButton(){
        
    }
}
