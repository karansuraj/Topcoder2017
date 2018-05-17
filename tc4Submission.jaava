import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tc4Submission {
	public static void main(String[] args) {
		String num = "34241726";
		String tempStr = "";
		char tmpChar;
		List<Integer> maxLst = new ArrayList<Integer>();
		for(int i = 0; i<num.length(); i++){
			for(int j = 0; j<num.length(); j++){
				tempStr = num;
				char[] tchars = tempStr.toCharArray();
				tmpChar = tchars[i];
				tchars[i] = tchars[j];
				tchars[j] = tmpChar;
				tempStr = String.valueOf(tchars);
				if(Integer.parseInt(tempStr)>Integer.parseInt(num)){
					maxLst.add(Integer.parseInt(tempStr));
				}
			}
		}
		System.out.println(Collections.min(maxLst));
	}
}
