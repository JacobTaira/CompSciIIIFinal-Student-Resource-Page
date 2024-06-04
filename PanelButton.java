import mayflower.*;
public class PanelButton extends Actor
{
    private MayflowerImage button;
    public PanelButton(String type){
        if(type.equals("home"))
           button = new MayflowerImage("img/homeButton.png");
        else if(type.equals("reset"))
           button = new MayflowerImage("img/resetButton.png");
        else if(type.equals("addCourse"))
            button = new MayflowerImage("img/addCourseButton.png");
        else
            button = new MayflowerImage("img/exitButton.png");
        button.crop(0,0,1200,220); //(int x, int y, int w, int h) x/y are offsets from the origin, w/h are the actual lengths
        button.scale(250,60);
        setImage(button);
    }
    
    public void act(){
        
    }
}
