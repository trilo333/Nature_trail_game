import java.util.Scanner;
/**
 * Trail class contains a array of naturefeature class objects and is used to store and change values of the various nature features on the trail.
 * Here we define four features like Creek,Bridge,Fallen Tree and Landslide and penalties associated with them.
 * Initial positions of all these features is 1 but is randomly assigned along the trail when the game is started through startGame method in Game class
 * @Trilochan Yadav (ID - 30379660)
 * @1.0 (17.04.2019)
 */
public class Trail
{
    // instance variables - replace the example below with your own
    private NatureFeature[] features;//Declaring an array of type Nature Feature with name features

    /**
     * Constructor for objects of class Trail
     */
    public Trail()//default constructor to initialise the array
    {
        // initialise instance variables
      features = new NatureFeature[4];
      features[0] = new NatureFeature(1,"Creek",-2);
      features[1] = new NatureFeature(1,"Bridge",4);
      features[2] = new NatureFeature(1,"Fallen Tree",-3);
      features[3] = new NatureFeature(1,"Landslide",-5);
    }
    
    
    public int getFeaturePosition(int index)//mutator method to set the position of feature along the trail
    {
       return features[index].getFeaturePosition();
    }
    
    public String getFeatureType(int index)//accessor method to get the type of a particular feature in the array
    {
        return features[index].getFeatureType();
    }
    
    public int getSpacePenalty(int index)//accessor method to get space penalty of a particular feature
    {
      return features[index].getSpacePenalty();
    }
    
    public NatureFeature[] getTrail()//returns the current state of array features
    {
        return features;
    }
    
    public void setFeaturePosition(int index,int newFeaturePosition)//mutator method to set the feature position using index and new value 
    {
        features[index].setFeaturePosition(newFeaturePosition);
    }
    
    public void setFeatureType(int index,String newType)//mutator method to set the type of feature 
    {
        features[index].setFeatureType(newType);
    }
    
    public void setSpacePenalty(int index,int newPenalty)//mutator method to set the space penalty for a feature
    {
        features[index].setSpacePenalty(newPenalty);
    }
       
}
