
import java.util.Scanner;
/**
 * Game class is the main class and has four fields and many methods to conduct the game and store two player class objects values.Player one is human,
 * Player two is computer ,game has a trail whose length can be between 10 and 20 spaces.Trail contains 5 animals and 4 nature features each feature is
 * assigned a random position at the start of the game excluding start and finish position.For each player turn ,there is a 50 % chance of spotting an
 * animal,for spotting animal points are awarded ,for landing on a feature ,there is a space penalty ,a player can land on both animal and feature at 
 * the same time.Players take turns by rolling a dice which has values from 1 to 4 ,player one has to press Enter for dice to roll,computer dice is 
 * rolled automatically. Player that reaches the finish position first is awarded 10 points and game ends at that point.
 * Result is displayed.
 * startGame is the main method of this class which starts the game and calls all other methods.
 *
 * @Trilochan Yadav (ID - 30379660)
 * @1.0 (17.04.2019)
 */
public class Game
{
    // instance variables - replace the example below with your own
    private int trailLength;//field that stores length of the trail entered by the user
    private Trail natureTrail;//object of trail class which stores values of all nature features
    private Player playerOne;// object of player class which stores values of human player like its name ,score and position
    private Player playerTwo;//object of player class which stores values of computer like its name,score and position

    public Game()//default constructor which initialises the value of fields
    {
        // initialise instance variables
        trailLength = 0;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player();

    }

    public int  checkForAnimal()//check if the player will see any animal on their turn
    {
        int animalSpot = -1;
        int probability = (int)(Math.random() * 9);//spotting an animal has 50 % probability
        if(probability < 5)//if animal is spotted then which one
            animalSpot = probability;
        return animalSpot;
    }

    public int checkForNatureFeature(int newPosition)//check if a player has landed on a nature feaure
    {
        int featurePenalty = 0;
        for(int i = 0;i < 4;i++)
        {
            if (natureTrail.getFeaturePosition(i) == newPosition)
                featurePenalty = natureTrail.getSpacePenalty(i);
        }
        return featurePenalty;//return the penalty for the feature on which player has landed
    }

    /*
     *this method displays the nature trail, we have used 2 -d array with 2 rows and columns till the length of the trail.
     *The first row displays H and C for human and computer position.The second row displays the position on which players are.
     *First position is shown by S .Last position is shown by F.
     */
    public void displayNatureTrail(int humanPosition,int computerPosition)
    {
        int human = humanPosition;
        int computer = computerPosition;
        String[][] trail = new String[2][trailLength];
        for(int i = 0;i < trailLength;i++)//set the first row of the array
        {
            trail[0][i] = " _ ";
            if(human != computer)
            {
                trail[0][human - 1] = " H ";
                trail[0][computer - 1] = " C ";
            }

            else if(human == computer && human != trailLength && computer != trailLength)//if both are at same position
            {
                trail[0][human - 1] = "HC";
            }
        }

        for(int i = 0;i < trailLength;i++)//set the second row of the array
        {
            if(i < 9 && i != 0)
            {
                trail[1][i] = "0" + (i+1) + " ";
            }
            else if(i == 0)
            {
                trail[1][0] = "S  ";
            }
            else if(i >= 9 && i!= (trailLength-1))
            {
                trail[1][i] = Integer.toString(i+1) + " ";
            }

            else
            {
                trail[1][trailLength - 1] = " F ";
            }
        }

        for(int i = 0;i < 2;i++)//print the trail
        {
            for(int j = 0;j < trailLength;j++)
            {   
                if(i == 0 && j == (trailLength - 1))
                {
                    System.out.println(trail[i][j]);
                }
                else if(i == 1 && j == (trailLength - 1))
                {
                    System.out.println(trail[i][j]);
                }
                else
                {
                    System.out.print(trail[i][j]); 
                }   
            }
        }

    }

    public void displayResult(int position1, int position2)//display final result and player scores
    {
        System.out.print('\u000C');
        if(position1 > position2)
        {
            System.out.println("Game has ended as " + playerOne.getName() + " has reached the final position");
            System.out.println(playerOne.getName() + " has scored 10 points for finishing first ");
            scoreUpdate(playerOne.getName(),10);
        }

        else
        {
            System.out.println("Game has ended as " + playerTwo.getName() + " has reached the final position");
            System.out.println(playerTwo.getName() + " has scored 10 points for finishing first ");
            scoreUpdate(playerTwo.getName(),10);
        }

        System.out.println("*************GAME ENDS***************");
        int humanScore = playerOne.getScore();
        int computerScore = playerTwo.getScore();

        if(humanScore > computerScore)//if human wins
        {
            System.out.println("The winner is " + playerOne.getName() + " and their score is " + humanScore + " Congratulations!!!");
            System.out.println("Don't worry " + playerTwo.getName() + " your score is " + computerScore + " Better Luck Next Time !!!");
        }

        else if(humanScore < computerScore)//if computer wins
        {
            System.out.println("The winner is " + playerTwo.getName() + " and their score is " + computerScore + " Congratulations!!!");
            System.out.println("Don't worry " + playerOne.getName() + " your score is " + humanScore + " Better Luck Next Time !!!");
        }

        else//if a tie happens
        {
            System.out.println("It's a TIE !!" + " .Both players have scored " + playerOne.getScore() +" have seen the beautiful nature trail ");
            System.out.println(" Better Luck Next Time ");
        }
    } 

    /* 
     * It asks the user for their name with which they want to play and keeps asking until their input is between 1 and 6 characters and then sets 
     * player one name to input name  
     */
    public void enterName()
    {
        System.out.println("Enter your name. It should be between 1 and 6 characters. ");
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        int check = 1;
        do//perform atleast once
        {
            if(s.length() >= 1 && s.length() <= 6)
            {
                playerOne.setName(s);
                check = 0;
            }

            else
            {
                System.out.println("ERROR,Enter your name again,name should be between 1 and 6 characters");
                s = console.nextLine();
            }
        }while (check != 0);//loop condition
    }

    /*
     *First roll before the game starts to decide which player starts first ,whoever rolls greater number starts first 
     */

    public int firstRoll()
    {

        int greater = 0 ;
        System.out.println("Almost done");
        System.out.println("Now determining which player starts the game");
        String start = " is on tile 1 with a score of 0 ";
        System.out.println(playerOne.getName() + start + " Roll your dice. Press enter to roll.");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int first = rollDice();
        System.out.println(playerOne.getName() + " rolled a " + first);
        System.out.println(playerTwo.getName() + start + " and is going to roll ");
        int second = rollDice();
        System.out.println(playerTwo.getName() + " rolled a " + second);
        sleep();

        if (first > second)
            greater = 1;
        else if (first < second)
            greater = 2;
        return greater;
    }

    public void movePlayer(String name,int moveTiles)//move the player along the trail
    {
        int newMove = moveTiles;
        if(name == playerOne.getName())
        {        
            playerOne.setPosition(newMove,trailLength);
        }

        else if(name == playerTwo.getName())
        {
            playerTwo.setPosition(newMove,trailLength);
        }
    }

    /*
     * player takes a turn and rolls the dice ,for human Enter is pressed to roll the dice ,for computer dice is rolled automatically,
     * player roll the dice and moves the no of spaces which the dice has rolled and sees either only animal,only nature feature,both animal and 
     * feature or nothing
     */
    public void playerTurn(String name)
    {
        String rollhuman = " .Roll your dice. Press Enter to Roll.";
        String rollcomputer = " and is going to roll";
        String score = " and has  a score of ";
        String tile = " is now on tile number ";
        int roll = 0;
        int animal;
        int feature;
        displayNatureTrail(playerOne.getPosition(),playerTwo.getPosition());
        String playerName = name;

        if(playerName == playerOne.getName())
        {

            System.out.println(playerName + " is on tile " + playerOne.getPosition() + score + playerOne.getScore() + rollhuman);
            Scanner console = new Scanner (System.in);
            console.nextLine();
            roll = rollDice();
            System.out.println(name + " rolled a " + roll);
            animal = checkForAnimal();
            movePlayer(name,roll);
            feature = checkForNatureFeature(playerOne.getPosition());

            if(animal != -1 && feature != 0)
            {
                spotAnimalAndFeature(playerOne.getName(),animal,feature);
                sleep();
            }
            else if (animal  != -1 && feature == 0)
            {
                spotAnimal(playerOne.getName(),animal);
                sleep();
            }
            else if (animal == -1 && feature != 0)
            {
                spotNatureFeature(playerOne.getName(),feature);
                sleep();
            }
            else
            {
                spotNothing();
                System.out.println(playerOne.getName() + tile + playerOne.getPosition() + score + playerOne.getScore());
                sleep();
            }
        }

        else if(playerName == playerTwo.getName()) 
        {

            System.out.println(playerName + " is on tile " + playerTwo.getPosition() + score + playerTwo.getScore() + rollcomputer);
            roll = rollDice();
            System.out.println(name + " rolled a " + roll);
            animal = checkForAnimal();
            movePlayer(name,roll);
            feature = checkForNatureFeature(playerTwo.getPosition());
            if(animal != -1 && feature != 0)
            {
                spotAnimalAndFeature(playerTwo.getName(),animal,feature);
                sleep();
            }

            else if (animal!= -1 && feature == 0)
            {
                spotAnimal(playerTwo.getName(),animal);
                sleep();
            }
            else if (animal == -1 && feature != 0)
            {
                spotNatureFeature(playerTwo.getName(),feature);
                sleep();
            }
            else
            {
                spotNothing();
                System.out.println(playerTwo.getName() + tile + playerTwo.getPosition() + score + playerTwo.getScore());
                sleep();
            }
        }

    }

    public void randomGenerateFeatures()//Generate unique numbers and assign nature features on these positions
    {
        boolean distinct = true;
        int[] pos = new int[4];
        do
        {
            for(int i = 0; i < 4;i++)
            {
                int random = 1 + (int)(Math.random() * (trailLength -2));//features cannot be on first and last position
                natureTrail.setFeaturePosition(i,random);
                pos[i] = random;
            }

            for(int i = 0; i < 4;i++)//to insure that positions are unique
            {
                for(int j = 3;j > 0;j--)
                {
                    if (pos[j] == pos[i])
                    {
                        distinct = false;
                    }
                }

            }
        }while(distinct != false);//loop condition
    }  

    public int rollDice()//Roll the dice by creating an object of dice and calling it's method
    {
        Dice d = new Dice();
        return d.randomNumberGenerator();
    }

    public void scoreUpdate(String name,int points)//updates player score
    {
        if(name == playerOne.getName())
            playerOne.setScore(points);
        else
            playerTwo.setScore(points);
    }

    /*
     * When only animal is spotted,print appropriate message and update the player score,it has 2 parameters
     */
    public void spotAnimal(String name,int newAnimalNo)
    {
        String[] animals = new String[]{"Koala","Emu","Wombat","Kangaroo","Redback Spider"};
        int[] points = new int[]{10,7,5,2,-5};
        String spot = " has spotted ";
        String score = " and has scored ";
        String now = " is now on ";
        String tile = " tile number  ";
        String playerName = name;
        int animalNo = newAnimalNo;
        switch(newAnimalNo)//switch for which animal spotted
        {
            case 0 : System.out.println(playerName + spot + animals[0] + score + points[0] + " points");
            scoreUpdate(playerName,points[0]);
            break;
            case 1 : System.out.println(playerName + spot + animals[1] + score + points[1] + " points");
            scoreUpdate(playerName,points[1]);
            break;
            case 2 : System.out.println(playerName + spot + animals[2] + score + points[2] + " points");
            scoreUpdate(playerName,points[2]);
            break;
            case 3 : System.out.println(playerName + spot + animals[3] + score + points[3] + " points");
            scoreUpdate(playerName,points[3]);
            break;
            case 4 : System.out.println(playerName + spot + animals[4] + score + points[4] + " points");
            scoreUpdate(playerName,points[4]);
            break;
        }

        if(name == playerOne.getName())
            System.out.println(name + now + tile + playerOne.getPosition() + " with a score of " + playerOne.getScore());

        else if (name == playerTwo.getName())
            System.out.println(name + now + tile + playerTwo.getPosition() + " with a score of " + playerTwo.getScore()); 
        sleep();
    }

    /*
     * When both animal and nature features are spotted,appropriate message is displayed,first player is awarded points and their score is updated,then
     * they are awarded penalty and their position  is updated,it has 3 parameters
     */
    public void spotAnimalAndFeature(String name,int animalNo,int featurePenalty)
    {
        String[] animals = new String[]{"Koala","Emu","Wombat","Kangaroo","Redback Spider"};
        int[] points = new int[]{10,7,5,2,-5}; 
        String animal = animals[animalNo];
        int point = points[animalNo];
        String land =  " and has landed ";
        String onfeature = " on nature feature ";
        String moveb = " has to go back ";
        String movef = " has to move forward ";
        String space = " spaces!!";
        String now = " is now on ";
        String tile = " tile number ";
        String spot = " has spotted ";
        String score = " has scored ";
        String Good = " Great,it is a GOOD nature feature ";//only feature is good and awards positive penalty
        String Bad = " Unfortunately,it is a BAD nature feature ";//3 features are bad an award negative penalty
        int penalty = featurePenalty;

        switch(penalty)
        {
            case -2 : System.out.println(name + spot + animal + land + onfeature + natureTrail.getFeatureType(0));
            System.out.println(name + score + point + " points."); 
            System.out.println(Bad + name + moveb + 2 + space);
            scoreUpdate(name,point);
            movePlayer(name,penalty);
            break;
            case -3 : System.out.println(name + spot + animal + land + onfeature + natureTrail.getFeatureType(2));
            System.out.println(name + score + point + " points."); 
            System.out.println(Bad + name + moveb + 3 + space);
            scoreUpdate(name,point);
            movePlayer(name,penalty);
            break;
            case -5 : System.out.println(name + spot + animal + land + onfeature + natureTrail.getFeatureType(3));
            System.out.println(name + score + point + " points."); 
            System.out.println(Bad + name + moveb + 2 + space);
            scoreUpdate(name,point);
            movePlayer(name,penalty);
            break;
            case 4  : System.out.println(name + spot + animal + land + onfeature + natureTrail.getFeatureType(1));
            System.out.println(name + score + point + " points."); 
            System.out.println(Good + name + movef + 4 + space);
            scoreUpdate(name,point);
            movePlayer(name,penalty);
            break;
        }

        if(name == playerOne.getName())
            System.out.println(name + now + tile + playerOne.getPosition() + " with a score of " + playerOne.getScore());

        else if(name == playerTwo.getName())
            System.out.println(name + now + tile + playerTwo.getPosition() + " with a score of " + playerTwo.getScore());
        sleep();
    }

    /*
     * When only nature feature is spotted, check for features penalty and display appropriate message and update player position,it has 2 parameteres 
     */
    public void spotNatureFeature(String name,int newPenalty)
    {
        String land = " has landed ";
        String onfeature = " on nature feature ";
        String moveb = " and has to go back ";
        String movef = " and has to move forward ";
        String space = " spaces!!";
        String now = " is now on ";
        String tile = " tile number ";
        int penalty = newPenalty;
        String playerName = name;

        switch(penalty)//Switch for penalty
        {
            case -2 : System.out.println(playerName + land + onfeature + natureTrail.getFeatureType(0) + moveb + 2 + space);
            sleep();
            movePlayer(playerName,penalty);
            break;
            case -3 : System.out.println(playerName + land + onfeature + natureTrail.getFeatureType(2) + moveb + 3 + space);
            sleep();
            movePlayer(playerName,penalty);
            break;
            case -5 : System.out.println(playerName + land + onfeature + natureTrail.getFeatureType(3) + moveb + 5 + space);
            sleep();
            movePlayer(playerName,penalty);
            break;
            case 4  : System.out.println(playerName + land + onfeature + natureTrail.getFeatureType(1) + movef + 4 + space);
            sleep();
            movePlayer(playerName,penalty);
            break;
        }

        if(name == playerOne.getName())
            System.out.println(name + now + tile + playerOne.getPosition() + " with a score of " + playerOne.getScore());

        else if (name == playerTwo.getName())
            System.out.println(name + now + tile + playerTwo.getPosition() + " with a score of " + playerTwo.getScore());
    }

    public void spotNothing()// If player does not see anything on their turn
    {
        System.out.println(" Unfortunately no animals or nature features sighted...Try again");

    }

    public void sleep()//sleep method to make the user understand whats going on in the game and game plays in human readable speed
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie) 
        {
            ie.printStackTrace();
        }
    }

    /*
     * Main method which starts the game and calls other methods in the class,first welcome method is called ,then features are set across the trail on 
     * unique and random positions along the trail ,the dice is rolled first time until one player rolls higher number to decide which player starts
     * the game first.Then players take turns until one reaches the last position ,the one reaching last position first is awarded 10 bonus points,
     * result is then displayed and one who scores more points wins the game.
     */
    public void startGame()
    {
        System.out.print('\u000C');//Clear the screen
        welcome();
        System.out.println("Now setting up nature features along the trail");
        randomGenerateFeatures();
        sleep();
        int firstRoll = 0 ;
        do 
        {
            firstRoll = firstRoll();

        }while (firstRoll == 0);

        System.out.print('\u000C');
        if(firstRoll == 1)
        {
            System.out.println(playerOne.getName() + " starts the game first ");
            System.out.println(playerOne.getName() + " is shown by H on the trail. ");
            System.out.println(playerTwo.getName() + " is shown by C on the trail. ");
            System.out.println(" Press Enter to start the game. ");
            Scanner console = new Scanner(System.in);
            String start = console.nextLine();
            do
            {
                System.out.print('\u000C');
                playerTurn(playerOne.getName());
                sleep();
                if (playerOne.getPosition() == trailLength)
                    break;
                System.out.println("**********************************");
                playerTurn(playerTwo.getName());
                if (playerTwo.getPosition() == trailLength)
                    break;

                System.out.println("Press enter for next set of turns ");
                String input = console.nextLine();
            }while ((playerOne.getPosition() != trailLength) && (playerTwo.getPosition() != trailLength));

        }

        else if (firstRoll == 2)
        {
            System.out.println(playerTwo.getName() + " starts the game first");
            System.out.println(playerOne.getName() + " is shown by H on the trail. ");
            System.out.println(playerTwo.getName() + " is shown by C on the trail. ");
            System.out.println(" Press Enter to start the game. ");
            Scanner console = new Scanner(System.in);
            String start = console.nextLine();
            do
            {
                System.out.print('\u000C');
                playerTurn(playerTwo.getName());
                sleep();
                if (playerTwo.getPosition() == trailLength)
                    break;
                System.out.println("**********************************");
                playerTurn(playerOne.getName());
                if (playerOne.getPosition() == trailLength)
                    break;
                System.out.println("Press enter for next set of turns "); 
                String input = console.nextLine();
            }while ((playerOne.getPosition() != trailLength) && (playerTwo.getPosition() != trailLength));

        }
        displayResult(playerOne.getPosition(),playerTwo.getPosition());
    }

    /*
     * It inputs the trail length by asking the user for input until user inputs length betwen 10 and 20
     */
    public void trailLength()
    {   
        System.out.println(" Setting up the trail for you ");
        System.out.println("Enter the trail length. Trail length should be between 10 and 20 ");
        Scanner console = new Scanner(System.in);
        String input  = console.nextLine();
        int userInput = Integer.valueOf(input);//convert string to int
        int check = 1;
        do//(ask until correct input)
        {
            if(userInput >= 10 && userInput <=20)
            {
                trailLength = userInput;
                check = 0;
            }

            else
            {
                System.out.println(" ERROR,Enter the trail length again, it should be between 10 and 20");
                input = console.nextLine();
                userInput = Integer.valueOf(input);
            }

        }while (check != 0);//loop condition
    }

    /* It displays the welcome message and calls trailLength method to input the trail length from user and enter name method to input the player name
     */
    public void welcome()
    {
        System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
        System.out.println(" Welcome to The Nature Trail Game ");
        System.out.println("*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
        trailLength();
        enterName();
        System.out.println(" Setting up your opponent ");
        System.out.println(" Your opponent is computer and his name is Rocky" );
        System.out.println(" Good News,we have found some animals ");
    }

    public static void main(){
        Game game = new Game();
        game.startGame();
    }

}

       
             
            
             
           
    
        
    


          
        
        
    
        
        
