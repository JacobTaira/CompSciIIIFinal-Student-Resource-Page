import mayflower.*;
public class titleLabel extends Actor
{
    private MayflowerImage title;
    public titleLabel(String type){
        if(type.equals("titleScreen")){
            title = new MayflowerImage("img/titleInstructions.png");
            title.crop(62,0,1081,200);
            title.scale(700, 200);
        }
        else if(type.equals("GPACalculator")){
            title = new MayflowerImage("img/GPACalculatorTitle.png");
            title.crop(390,25, 413, 70);
            title.scale(400, 65);
        }
        else if(type.equals("StudentPlanner")){
            title = new MayflowerImage("img/StudentPlannerTitle.png");
            title.crop(380,40,444,69);
            title.scale(400, 65);
        }
        setImage(title);
    }
    
    public void act(){
        
    }
}
