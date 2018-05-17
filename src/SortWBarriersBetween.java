import java.util.Arrays;

public class SortWBarriersBetween {
	public static int[] sortByHeight(int[] a) {

	    int t;
	    
	    for(int i=0; i<a.length; i++)
	        for(int j=i+1; j<a.length; j++)
	            if(a[i]>a[j] && a[i]!=-1 && a[j]!=-1) {
	                
	                t = a[i];
	                a[i] = a[j];
	                a[j] = t;
	            }
	    
	    return a;
	}
	
	public static String reverseParentheses(String s){
		String finalStr = ""; String revStr = "";
		if(s.indexOf('(') >= 0) {
			for(int j=0; j<s.indexOf('('); j++) finalStr+=s.charAt(j);
			for(int i=s.indexOf('(')+1; i<s.lastIndexOf(')'); i++) revStr+=s.charAt(i);
			finalStr+=recurseReverse(revStr);
			for(int j=s.lastIndexOf(')')+1; j<s.length(); j++) finalStr+=s.charAt(j);
			s = finalStr;
		}
		return s;
	}
	public static String recurseReverse(String s) {
	    String currStr = s; String revStr = "";  String finalStr = s;
	    if(currStr.indexOf('(') == 0) {
	    	finalStr = "";
	    	for(int i=currStr.indexOf('('); i<=currStr.lastIndexOf(')'); i++) revStr+=s.charAt(i); //Rev Str includes parentheses
	    	if(currStr.substring(1, currStr.length()).indexOf('(') >= 0) finalStr += recurseReverse(revStr); //if >1 open par., recurse
	    	else { //Reverse the string in parentheses & exclude the parentheses
	    		revStr = new StringBuilder(revStr.substring(revStr.indexOf('(')+1, revStr.indexOf(')'))).reverse().toString();
	    		finalStr+=revStr;
	    		for(int j=revStr.lastIndexOf(')')+1; j<revStr.length(); j++) finalStr+=revStr.charAt(j);
	    	}
	    	
	    } else if(currStr.indexOf('(') > 0) {
	    	for(int j=0; j<currStr.indexOf('('); j++) finalStr+=currStr.charAt(j);
	    	for(int i=currStr.indexOf('('); i<=currStr.lastIndexOf(')'); i++) revStr+=s.charAt(i); //Rev Str includes parentheses
	    	if(currStr.substring(1, currStr.length()).indexOf('(') >= 0) finalStr += recurseReverse(revStr); //if >1 open par., recurse
	    	
	    	
	    }
	    finalStr = new StringBuilder(finalStr).reverse().toString();
	    return finalStr;
	}

	public static void main(String args[]){
		//System.out.println(Arrays.toString(sortByHeight(new int[] {-1, 150, 190, 170, -1, -1, 160, 180})));
		System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}
}
