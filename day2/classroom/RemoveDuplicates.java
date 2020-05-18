package week3.day2.classroom;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "PayPal India";
		char[] charArray = text.toCharArray();
		System.out.println(charArray);
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		for (int i=0;i< charArray.length-1;i++)
		{
		
			
			if(!charSet.add(charArray[i]))
				dupCharSet.add(charArray[i]);
			
		}
		System.out.println(dupCharSet);
		System.out.println(charSet);	
		
		charSet.removeAll(dupCharSet);
		
		
		
		for (Character str : charSet) 
		{	
			if(str!=' ')
				System.out.print(str);
			    
			
		}
		

		}
	
 
	}

