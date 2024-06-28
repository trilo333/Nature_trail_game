
/**
 * Player class is used to store player details like player name,player position and their current score.It has accessor and mutator methods to get and set
 * these values.Player score can be negative or positive.Player position can not be negative and must be between 1 and maximum length of the trail.
 * Player name is by default Computer Rocky as one player Computer for our Nature Trail game.
 *
 * @Trilochan Yadav (ID - 30379660)
 * @1.0 (17.04.2019)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;//contains name of Player
    private int position;//contains position of the player
    private int score;//contains score of the player
    
    public Player()//default constructor 
    {
        // initialise instance variables
        name = "Computer Rocky";//initialise name to Computer Rocky
        position= 1;//initialise position to 1
        score = 0;// initialise score to 1
    }

    public Player(String newName,int newPosition,int newScore)//non default constructor has three paramteres
    {
        // initialise instance variables
        name = newName;//initialise to name to new name
        position = newPosition;//initialise position to new position
        score = newScore;//initialise score to new score
    }
    
    public void displayPlayer()//display the current state of the player object
    {
        String s = "Player" + name + "is on position" + "with a score of" + score + "points";
        System.out.println("s");
    }
    
    public String getName()//accessor method to get current value of name
    {
        return name;
    }
    
    public int getPosition()//accessor method to get the current position of the player
    {
        return position;
    }
    
    public int getScore()//accessor method to get the current score of the player
    {
        return score;
    }
    
    public void setName(String newName)//mutator method to set name of the player 
    {
        name = newName;
    }
    
    public void setPosition(int newPosition,int max)//mutator method to set position of the player
    {
        if((position + newPosition) < max && (position + newPosition) > 1)//check for valid position after making move
            position = position + newPosition;
        else if ((position + newPosition) >=  max)//check if new position is greater than max trail length
            position = max;
        else 
            position = 1;
    }
    
    public void setScore(int newScore)//mutator method to set the score of the player
    {
        score = score + newScore;
    }
     
}
