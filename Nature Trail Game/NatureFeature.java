
/**
 * This class contains nature features and has fields for specifying type of feature ,position of feature on the trail and space penalty associated with 
 * it.
 * @Trilochan Yadav (ID - 30379660)
 * @1.0 (17.04.2019)
 */
public class NatureFeature
{
    // instance variables - replace the example below with your own
    private int featurePosition;//position of feature on the trail 
    private String featureType;// feature name or its type
    private int spacePenalty;//penalty associated with nature feature
   
    public NatureFeature()//default constructor used to initialise field values
    {
        // initialise instance variables
        featurePosition = 1;//initialise position to 1 
        featureType = "";//initialise 
        spacePenalty = 0;//initialise space penalty to 0
    }

    public NatureFeature(int newPosition,String newFeature,int newPenalty)//non default constructor 
    {
        // initialise instance variables
        featurePosition = newPosition;//initialise to user given position
        featureType = newFeature;//initialise to user given type
        spacePenalty = newPenalty;//initialise to user given penalty
    }
    
    public int getFeaturePosition()//accessor method used to get current feature position
    {
      return featurePosition;
    }
    
    public String getFeatureType()//accessor method used to get the feature type
    {
      return featureType;
    }
    
    public int  getSpacePenalty()//accessor method used to get current space penalty associated with the feature
    {
        return spacePenalty;
    }
    
    public void setFeatureType(String newType)//mutator method used to set feature type
    {
      featureType = newType;
    }
    
    public void setFeaturePosition(int newPosition)//mutator method used to set feature position
    {
      featurePosition = newPosition;
    }
    
    public void setSpacePenalty(int newPenalty)//mutator method used to set space penalty
    {
      spacePenalty = newPenalty;
    }
       
}
        
        
     
        
        
        
     

