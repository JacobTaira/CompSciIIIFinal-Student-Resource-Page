import mayflower.*;
public class PanelTitle extends Actor
{
    public PanelTitle(){
        MayflowerImage title = new MayflowerImage("img/panelTitle.png");
        title.crop(0,0,1200,160); 
        title.scale(300,50);
        setImage(title);
    }
    
    public void act(){
        
    }
}
