package playSafeGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			  int numberPlayed=0;
			  int count=0,result,spin=0;
			  double amountPlayedWith=0.0;
			  double amountWin=0;
			  int total=36;
			  
              int luckyNumber=0;
              
			  String name;
			  
			  Random random=new Random();
			  
			  
			  List<String>players=new ArrayList<String>();
		      File myObj = new File("playersnames.txt");
		      String data="";
		      Scanner inputs=new Scanner(System.in);
		      
		      
		      
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	 data = myReader.nextLine();
		    	 players.add(data);
		        System.out.println(data);
		      }
		      myReader.close();
		       System.out.print("\n");
			      
		       
		       name =inputs.nextLine();
		       
		       
		       String[] myString=name.split(" ");
		       
		       if(myString[1].matches("-?\\d+(\\.\\d+)?")) {
	    		   numberPlayed=Integer.parseInt(myString[1]);
	    		   System.out.println("Numeric Value");
	    	   }
		       
		       amountPlayedWith=Double.parseDouble(myString[2]);
		       while(myString[0].equals(players.get(count)) || myString[0].equals(players.get(count+1))) {
		    	   
		    	  
		    	   luckyNumber=randomNumber(random);
		    	   
		    	   
		    	   System.out.println("number :"+luckyNumber);
		    	   
		    	   if(numberPlayed>0 && numberPlayed<36) {
		    		  if(luckyNumber==numberPlayed) 
		    			  
		    			//  System.out.println("Numeric Value");
		    			  result=36;
		    		  else 
		    			 // result=0;
		    		  System.out.println("lost");
		    		   
		    	   }

		    	   
		    	   if(myString[1].equals("EVEN")) {
		    		   
		    		  if(luckyNumber %2 ==0)
		    			  
		    			   result=2; 
		    		  else 
		    			 result=0;
		    			  
		    	   }
		    	   
		    	   
		    	   if(myString[1].equals("ODD")) {
		    		   
		    		   if(luckyNumber %2 !=0)
		    			    // result=2;
		    		     System.out.println("Odd number win");
		    		   else 
		    			    //result=0;
		    			   
		    			   System.out.println("Odd number lost");
		    	   }
		    	   
		    	   if(myString[1].matches("-?\\d+(\\.\\d+)?")) {
		    		   numberPlayed=Integer.parseInt(myString[1]);
		    		   System.out.println("Numeric Value");
		    	   }
		    	   
		    	   name =inputs.nextLine();
		    	   myString=name.split(" ");
		    	 
		    	   amountPlayedWith=Double.parseDouble(myString[2]);
		    	   spin++;
		    	   
		    	   
		       }
	
		      

		       
		       
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	
	
	//this methods return random every thirty second
	public static int randomNumber(Random random) {
		long time=System.currentTimeMillis();
		do {
			int storedRandom=random.nextInt(37);
			return storedRandom;
		}while(System.currentTimeMillis()-time<30000);
	}

}
