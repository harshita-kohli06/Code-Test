import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * The Robo class displays the distance from the starting point (0,0).The input commands are checked against the available commands, 
 * depending the commands the value of(x,y) changes.The final values of x and y are then used to calculate the distance from Home.
 * 
 * @author (Harshita Kohli)
 * @version (V 2.5 - 28/01/2020)
 */
public class Robo
{
    private ArrayList<String> command;
    Scanner sc = new Scanner(System.in);
    /**
     * Constructor for objects of class Robo
     */
    public Robo()
    {
        command = new ArrayList<String>();
    }

    /**
     * This method checks the given commands and accordingly change either the direction or the value of x and y.
     * The command ‘F’ and 'B' changes either x or y according to following rules.
       a) If current direction is North, then ‘F’ increments y and doesn’t change x and vice versa for 'B'.
       b) If current direction is East, then ‘F’ increments x and doesn’t change y and vice versa for 'B'.
       c) If current direction is South, then ‘F’ decrements y and doesn’t change x and vice versa for 'B'.
       d) If current direction is West, then ‘F’ decrements x and doesn’t change y and vice versa for 'B'.

       The moves ‘L’ and ‘R’, do not change x and y coordinates, they only change direction according to following rule.
       a) If current direction is East (dir = 0), then ‘L’ changes direction to North (dir = 3) and ‘R’ changes to South ( dir = 1).
       b) If current direction is South (dir = 1), then ‘L’ changes direction to East (dir = 0) and ‘R’ changes to West (dir = 2).
       c) If current direction is West ( dir = 2), then ‘L’ changes direction to South ( dir = 1) and ‘R’ changes to North (dir = 3).
       d) If current direction is North (dir = 3), then ‘L’ changes direction to West (dir = 2) and ‘R’ changes to East (dir = 0).
     *
     * @return    the sum of x and y as the distance from starting point i.e. (0,0)
     */

    public static void calculateDistance(String commands)
    {
        int dir = 0; // Initializing the strating direction as E East
        int x = 0; // Initializing the strating point for Robot as (0,0)
        int y = 0;
        String[] command = commands.split(",");
        if(commands.equals("")) // Checking if the 'Enter' is pressed instead of command
        {
            System.out.println("  You didn't insert any text  ");
            System.out.println("  Please start again !!  ");
        }
        else {
        for (String s : command)
        {
            // Finding the current move of the Robot
            // If the direction is 'L' or 'R', then change the direction
            // If the current move is 'F' or 'B' then change the value of x and y accordingly
            
            if(Character.toString(s.charAt(0)).equals("R")) // Checking if the command is equal to 'R'
            {

                if(dir == 0 || dir == 1 || dir == 2 ) // Checking if direction is East, South, West 
                {
                    dir++; // Then change the directions to South, West, North respectively
                }
                else
                {
                    dir = 0; // If the direction is North, then change it to East
                }
            }
            else if(Character.toString(s.charAt(0)).equals("L")) // Checking if the command is equal to 'L'
            {

                if(dir == 1 || dir == 2 || dir == 3 ) // Checking if direction is South, West, North 
                {
                    dir--; // Then change the directions to East, South, West respectively
                }
                else
                {
                    dir = 3; // If the direction is East, then change it to North
                }   
            }
            else if(Character.toString(s.charAt(0)).equals("F"))
            {
                if (dir == 0) // If the direction is East, then increment in x 
                {
                    x = x + Integer.parseInt(s.substring(1));
                    y = y;
                }
                else if (dir == 1) // If the direction is South, then decrement in y
                {
                    y = y - Integer.parseInt(s.substring(1));
                    x = x;
                }

                else if (dir == 2) // If the direction is West, then decrement in x
                {
                    x = x - Integer.parseInt(s.substring(1));
                    y = y;
                }
                else if (dir == 3) // If the direction is North, then increment in y
                {
                    y = y + Integer.parseInt(s.substring(1));
                    x = x;
                }
            }
            else if(Character.toString(s.charAt(0)).equals("B"))
            {
                if (dir == 0) // If the direction is East, then decrement in x
                {
                    x = x - Integer.parseInt(s.substring(1));
                    y = y;
                }
                else if (dir == 1) // If the direction is South, then increment in y
                {
                    y = y + Integer.parseInt(s.substring(1));
                    x = x;
                }

                else if (dir == 2) // If the direction is West, then increment in x
                {
                    x = x + Integer.parseInt(s.substring(1));
                    y = y;
                }
                else if (dir == 3) // If the direction is North, then decrement in y
                {
                    y = y - Integer.parseInt(s.substring(1));
                    x = x;
                }
            }  
        }

        int distanceFromHome = (Math.abs(x)+ Math.abs(y));
        System.out.println(" ");
        System.out.println("The Distance from the starting point of the given command is : " + Math.abs(distanceFromHome));

    }
}

    public void start() 
    {
        System.out.println("");
        System.out.println("*****************************************************************");
        System.out.println("");
        System.out.println("           ## Welcome to the World of Robots ##       ");
        System.out.println("");
        System.out.println("*****************************************************************");
        System.out.println("");
        System.out.println("###  Rules :");
        System.out.println("");
        System.out.println("1. The Commands to be entered in the format <command><number>.");
        System.out.println("2. The robot can only turn 90 degrees at a time, so L and R can only support '1' eg. L1 and R1.");
        System.out.println("3. The Commands to be entered in capital letters only.");
        System.out.println("");
        System.out.println("###   Available commands:");
        System.out.println("");
        System.out.println("* `F` - move forward 1 unit");
        System.out.println("* `B` - move backward 1 unit");
        System.out.println("* `R` - turn right 90 degrees");
        System.out.println("* `L` - turn left 90 degrees");
        System.out.println("");
        System.out.println("Please Enter a string of comma-separated commands eg `F1,R1,B2,L1,B3`: ");
        System.out.println("");
        Scanner scan = new Scanner(System.in);
        String commands = scan.nextLine();
        calculateDistance(commands);
    }

}

