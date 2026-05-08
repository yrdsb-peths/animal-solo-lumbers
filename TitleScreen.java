import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen 
 * 
 * @Noah
 * @May 2026
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 300,100);
        prepare();
    }

    public void act()
    {
        //when u press space, the game will start 
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //sets the labels to set places and prevents them from moving
        Elephant elephant = new Elephant();
        addObject(elephant,300,200);
        Label label = new Label("press space to start", 50);
        addObject(label,310,288);
        elephant.setLocation(300,200);
        label.setLocation(391,186);
        label.setLocation(300,300);
        Label label2 = new Label("use the left and right arrow keys to move", 50);
        addObject(label2,286,311);
        label2.setLocation(406,298);
        label2.setLocation(477,305);
        label2.setLocation(419,304);
        removeObject(label2);
        Label label3 = new Label("\u2190 and \u2192 to move", 50);
        addObject(label3,290,286);
        label3.setLocation(300,350);
    }
}
