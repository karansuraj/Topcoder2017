import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tc1Submission {

	public static void removeTopDigits(String Infname){
		String Outfname = "tc1.csv";
		String line;
		try {
			FileReader file = new FileReader(Infname);
			BufferedReader bread = new BufferedReader(file);
			FileWriter outFile = new FileWriter(Outfname);
			BufferedWriter bwrite = new BufferedWriter(outFile);
			while((line = bread.readLine())!=null){
				int strLen = line.length();
				List<Integer> digits = new ArrayList<Integer>();
				for(int k=0; k<strLen; k++){
					digits.add(Character.getNumericValue(line.charAt(k)));
				}
				for(int l=0; l<9; l++) digits.remove(Collections.max(digits)); 
				String finalStr = "";
				for(int m=0; m<digits.size(); m++){
					finalStr+=digits.get(m).toString();
				}
				System.out.println(line);
				System.out.println(finalStr);
				System.out.println();
				bwrite.write(finalStr);

				bwrite.write("\n");
			}
			bread.close(); bwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		removeTopDigits("LowestNumber.csv");
	}

}
