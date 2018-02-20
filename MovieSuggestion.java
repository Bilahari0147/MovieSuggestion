/*

Note:This code works better if followings rules are followed

1.input should be input.txt(should not be empty)

2.input file should contain Person_Name and Movie_Name seperated by a tab no element should be  empty (like empty at Person_Name or empty at Movie_Name)

3.input.txt should be sorted with Person_Name (i.e  Persons with same names should be in consecutive lines)

4.this Filename is Movie_Suggestion.java

5.compile : javac Movie_Suggestion.java -Xlint (it shows two wanings but don't worry code works well you can run)

6.Run:java java Movie_Suggestion

5.Then it shows "Enter movie name to get suggestion" (give movie name command line to know movies watched by people who watched given movie )

6.This Movie_Name must be one of the Movie_Names in the input otherwise it print "No Suggestions"


@ code by Bilahari Goruputi B.Tech CSE IIT Patna @



*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Scanner;



public class MovieSuggestion {

    public static void main(String[] args) throws Exception
    {

    String line,token ;

    List<String> Name = new ArrayList<String>(); //creating Arraylist to stores names
    List<String> Movie = new ArrayList<String>();//creating Arraylist to store Movies
    List<String> print = new ArrayList<String>(); // creating list to store suggestions
    StringTokenizer tokenizer;
    BufferedReader input = null;
 




    String filename = "input.txt"; //input file
    input = new BufferedReader(new FileReader(filename));
    line = input.readLine(); // when printed gives first line in file
    int t=0; //to eliminate duplicate keys and to define size of Hashmap




    //  while (process lines)
    while (line != null)
    {

    String[] output = line.trim().split("\t");//delimiter tab
    Name.add(output[0]);  //adding names to the list
    Movie.add(output[1]); //adding movies to the list
                                     
    t++; //to check no:of watched by a person 
    line = input.readLine(); // next line
    }// close  while





    // creating Hashmap to store

    Map<String, List<String>> map = new HashMap<String, List<String>>();


    //creating Array of ArrayLists

    ArrayList<String>[] lists = new ArrayList[t];

    int c=1,k=0;

    for(int i=0;i<Name.size();i++)

    {// outer for loop
      
      if( (i+1)<Name.size() && Name.get(i).equals(Name.get(i+1))) { c++;} //

      else{
        //creating ArrayList to each Array element
        lists[k] = new ArrayList<String>();  
      
        for(int j=i-c+1;j<=i;j++)
            {// ineer for loop
              lists[k].add(Movie.get(j));

            } // closing inner for loop

        map.put(Name.get(i), lists[k]);  // putting keys(names) and ArrayList(Movies Watched) into HashMap
        c=1;
        k++;
          }

         } // closing outter for loop


        System.out.println("Enter movie name to get suggestion\n");
            Scanner sc = new Scanner(System.in);
 
            // String input
            String Movie_name = sc.nextLine();  
  

    for (Map.Entry<String, List<String>> entry : map.entrySet())
    {  //inner for loop

            List<String> values = entry.getValue(); // getting all the movies watched by that person
    

       if(values.contains(Movie_name))  //if list contain given movie
        {

            for (int i = 0; i < values.size(); i++)    
            { //inner for loop

            if(!print.contains(values.get(i))) { print.add(values.get(i));} //if print(suggestion movie list) does not contain then add it
            } //closing inner for loop

        }

    }  //outter for loop


    if(!print.isEmpty()) { //if suggestions not empty print them

    System.out.println("Those who Watched " + Movie_name + " also Watched: \n");

    for (int i = 0; i < print.size(); i++) { //for loop

    if(!print.get(i).contains(Movie_name)){System.out.println(print.get(i)); } //printing suggested movies

         				   } //closing inner for loop

                	 } // closing outter if 

    else { System.out.println("No suggestions");} // if not print no suggestions



    }
}

