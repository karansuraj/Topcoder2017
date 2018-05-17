import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class LoopsListsEx {	
	
	private static HashMap<String, List<String>> grThanMap;
	private static List<String> odah;
	private static List<String> checkedChrs;
	
	public static String answer(String []words){
		if(words.length==1) return words[0];	    	
		//Initialize Data Structures for program
		grThanMap = new HashMap<String, List<String>>();
		odah = new ArrayList<String>();
		checkedChrs = new ArrayList<String>(); 
    	int i,j;
    	
    	/*Iterating through words, comparing every 2 words until the first unmatching character. Then adding comparison to hashmap*/
		for(i=1;i<words.length;i++){
			String curWord = words[i], prevWord = words[i-1];
			for(j=0;j<Math.min(curWord.length(),prevWord.length());j++){
				String curChar = Character.toString(curWord.charAt(j)), prevChar = Character.toString(prevWord.charAt(j));
				if(curChar.compareTo(prevChar)!=0){ //Compare char j. If not equal, add comparison to odah array
					List<String> curCharMap = new ArrayList<String>();
					/*Add to Overall hashmap of relationships of chars. Key is a char, and value is all chars less than it*/
					if(grThanMap.containsKey(curChar)){
						curCharMap = grThanMap.get(curChar);
						if(!curCharMap.contains(prevChar)) curCharMap.add(prevChar);
					} else curCharMap.add(prevChar);
					grThanMap.put(curChar, curCharMap);
					break; //Break from loop since we've finally hit the first uncommon character between 2 words
				}
			}
		}
    		
    	/* Build list of characters that have no rules for any other character to be greater than them. Iterate through this list.*/
    	List<String> EndchrList = EndLst();
    	for(String endChr: EndchrList){
    		buildOdah(endChr);
    	}
    	return convertListToStr(odah);
	}
	
	/*Build list of characters that have no rules for any other character to be greater than them.*/
	private static List<String> EndLst(){
		List<String> EndChars = new ArrayList<String>();
		for(String chr: grThanMap.keySet()){
			boolean sameChrFlag = false;
			outerloop:
			for(String iterChr: grThanMap.keySet()){
				if(chr.compareTo(iterChr)==0) continue;
				for(String LessChr: grThanMap.get(iterChr)){
					if(LessChr.compareTo(chr)==0) { //If outer char is in any of the hash lists, break and add it to End Chars list
						sameChrFlag=true;
						break outerloop;
					}
				}
			}
			if(sameChrFlag==false) EndChars.add(chr);
		}
		return EndChars;
	}	
	
	/*Recursive function to build alphabet string, odah, working from the inside out*/
	private static void buildOdah(String chr){
		if(!checkedChrs.contains(chr)){ //If we have not already looked at the character we are checking
			//Add current char to list of checked chars. If current char is not in hashmap, go ahead and add to odah list
			checkedChrs.add(chr);			
			if(grThanMap.containsKey(chr)) for(String LessChr: grThanMap.get(chr)) buildOdah(LessChr);
			odah.add(chr);
		}
	}
	
	/*Convert a list of strings to a single string*/
	private static String convertListToStr(List<String> yoda){
		StringBuilder listString = new StringBuilder();
	    for (String s : yoda) listString.append(s);
    	return listString.toString();
	}
}