
/**
 * Dice class generates a random number between min and max value for the dice roll.
 *
 * @Trilochan Yadav (ID - 30379660)
 * @1.0 (17.04.2019)
 * 
 */
public class Dice
{
    // instance variables - replace the example below with your own
    private int maximumValue;//maximum value of the dice
    private int minimumValue;//minimum value of the dice
    
    public Dice()//default constructor to initialise the fields
    {
        // initialise instance variables
        maximumValue = 4;//maximum value of value of dice is 4
        minimumValue = 1;//minimum value of the dice is 1
    }

    public Dice(int newMin,int newMax)//non default constructor to take user input for field values,it has 2 parameters
    {
        maximumValue= newMax;
        minimumValue = newMin;
    }
    
    public int getMaximumValue()//accessor method to get the maximum value of the dice
    {
        return minimumValue;
    }
   
    public int getMinimumValue()//accessor method to get the minimum value of the dice
    {
        return minimumValue;
    }
    
    public int randomNumberGenerator()//generates and return a random number between min and max no ,imitates the natural roll of a dice
    {
        return 1 + (int)(Math.random() * maximumValue);
    }
    
    public void setMaximumValue(int newMaximum)//mutator method to set the maximum value of the dice
    {
        maximumValue = newMaximum;
    }
    
    public void setMinimumValue(int newMinimum)//mutator method to set the minimum value of the dice
    {
        minimumValue = newMinimum;
    }
    
}
