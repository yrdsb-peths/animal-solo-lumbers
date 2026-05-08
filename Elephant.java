import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THe ELEPHANT OUR HERO
 * @author Noah
 * @version 27/04/2026
 */
public class Elephant extends Actor
{
    //found the sound for what happens when u touch the apple
    GreenfootSound elephantsound = new GreenfootSound("vine-boom.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    //creates a new timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Elephant()
    {
        //these are all for animations and also wherever the elephant is facing
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        //this is the code for how the elephant moves 
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        
        //kills off the apple if ele eats it
        eat();
        
        animateElephant();
    }
    
    public void eat()
    {
        //destroys apple class, increases score, creates a new apple and 
        //plays a sound for user feedback
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore(); 
            elephantsound.play();
        }
    }
}
