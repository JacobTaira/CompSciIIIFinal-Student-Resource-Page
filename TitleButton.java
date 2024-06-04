import mayflower.*;
public class TitleButton extends Actor
{
    private MayflowerImage button;
    public TitleButton(String type){
        if(type.equals("GPA"))
            button = new MayflowerImage("img/gpaButton.png");
        else
            button = new MayflowerImage("img/plannerButton.png");
        button.crop(0,0,1200,325);
        button.scale(600, 175);
        setImage(button);
    }
    public void act(){
        
    }
}
