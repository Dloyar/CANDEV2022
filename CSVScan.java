package Candev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;





public class CSVScan {
	
	public static void main(String[] args) throws IOException {
	/*	
		String path ="C:\\Users\\13432\\Desktop\\CANDEV\\Classeur1.csv";
		String line ="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) !=null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner scan = new Scanner(new File("C:\\Users\\13432\\Desktop\\CANDEV\\Classeur1.csv"));
		ArrayList<String[]> records = new ArrayList<String[]>();
		String[] record = new String[2];
		while(scan.hasNext())
		{
		    record = scan.nextLine().split(",");
		    records.add(record);
		}
		
		//code = code.replace("ï»¿", "");
		
	// enlever ï»¿ au debut du caractere
		/*System.out.println(Objects.equals("ï»¿",code.substring(0, 3)));
		System.out.println(Objects.equals(code,code2));
		System.out.println(records.size());
		*/
		
		
		int i = 0;
		int count = 0;
		while (i< records.size()) {
			
			
			String first = records.get(i)[0].trim();                   
			String second = records.get(i+1)[0].trim();
			
			if (Objects.equals("ï»¿",first.substring(0, 3))) {
				first = first.replace("ï»¿", "");
			}
			
			if (first.charAt(0)=='\ufeff') first = first.substring(1);
			if (second.charAt(0)=='\ufeff') second = second.substring(1);
			
			if (Objects.equals(first,second)) {
				count +=1;
				
			}else {
				if (count>3) {
					count=count-3;
					System.out.println(first + " à été renvoyé "+ count+" fois");
				}
				count=0;
			}
			i++;
		}
	}
}
