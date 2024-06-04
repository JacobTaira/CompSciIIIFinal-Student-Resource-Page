import java.util.*;
import mayflower.*;
public class SubjectTabs extends Actor
{
    private MayflowerImage subject;
    public SubjectTabs(String type){
        if(type.equals("Math"))
            subject = new MayflowerImage("img/mathTab.png");       
        else if(type.equals("English"))
            subject = new MayflowerImage("img/englishTab.png");
        else if(type.equals("Science"))
            subject = new MayflowerImage("img/scienceTab.png");
        else if(type.equals("SocialStudies"))
            subject = new MayflowerImage("img/socialStudiesTab.png");
        else if(type.equals("LOTE"))
            subject = new MayflowerImage("img/loteTab.png");
        if(subject != null)
            subject.crop(0,0,650,650);
        subject.scale(150, 150);
        setImage(subject);
    }
    
    public void act(){
        
    }
    
    public void imageScale(int x, int y){
        subject.scale(x,y);
        setImage(subject);
    }
}
