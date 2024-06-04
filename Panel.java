import mayflower.*;
public class Panel extends Actor
{
    public Panel(){
        MayflowerImage backPanel = new MayflowerImage("img/updatedSidePanel.png");
        backPanel.crop(0,0,421,650);
        backPanel.scale(300,650);
        setImage(backPanel);
    }
    
    public void act(){
        
    }
}
