package week3.day2.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		List<String> companies = new ArrayList<String>();
		companies.add("HCL");
		companies.add("Wipro");
		companies.add("Aspire Systems");
		companies.add("CTS");
		Collections.sort(companies);
		System.out.println(companies);
		for (int i=companies.size()-1;i>=0;i--) {
			System.out.println(companies.get(i));
		}
		
		

	}

}
