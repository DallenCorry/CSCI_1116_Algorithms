import java.util.*;

/**
* This class matches the states with their capitals
*
* @author Unknown
* Edited by: Dallen Corry
* @version 1.2 
* @since Feb/08/2022
*/
public class Exercise20_3 {
  public static void main(String[] args) {
    
    ArrayList<String []> myStateCapital = new ArrayList<String []>();
    
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };
    
    for(String[] arr:stateCapital){
      if(arr.length == 2){
        myStateCapital.add(arr);
      } else {
        System.out.println("Missing State/Capital");
      }
    }
    
    Random r = new Random();
    Collections.shuffle(myStateCapital,r);
    Scanner input = new Scanner(System.in);
    int correctCount = 0;
      
    for(String[] arr:myStateCapital){
      // Prompt the user with a question
      System.out.print("What is the capital of " + arr[0]+ "? ");
      String capital = input.nextLine().trim().toLowerCase();
    
      if (capital.toLowerCase().equals(arr[1].toLowerCase())) {
        System.out.println("Your answer is correct");
        correctCount++;
      }
      else{        System.out.println("The correct answer should be " + arr[1]);
      }
    }
    System.out.println("Your Score: " + correctCount + "/50");
    double percent = (double)correctCount/stateCapital.length;
    System.out.printf("%.1f%% correct",(percent*100));
  }
}
  