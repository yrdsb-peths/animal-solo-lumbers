import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld() {
        super(600, 400, 1, false);
        //creates new elephant
        Elephant ele = new Elephant();
        addObject(ele, 300, 300);
        
        //creates a label for score
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        //references the apple method 
        createApple();
    }
    
    public void gameOver()
    {
        //creates a new label after you die, which is game over
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        //increases score and changes the label to match
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 ==0)
        {
            level += 1;
        }
    }
    
    public void createApple()
    {   
        //creates a new apple object
        Apple apple = new Apple();
        //changes the speed of the apple falling every 5 seconds
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
