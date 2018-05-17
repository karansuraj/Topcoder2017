import java.util.Arrays;
import java.util.List;

public class TCP32016 {
	
	public static List<String> ones = Arrays.asList("One","Two","Three","Four","Five","Six", "Seven", "Eight", "Nine");
	public static List<String> tens = Arrays.asList("","Twenty","Thirty","Forty","Fifty","Sixty", "Seventy", "Eighty", "Ninety");
	public static List<String> teens = Arrays.asList("Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen");
	public static List<String> hundreds = Arrays.asList("","OneHundredAnd","TwoHundredAnd","ThreeHundredAnd","FourHundredAnd","FiveHundredAnd","SixHundredAnd", "SevenHundredAnd", "EightHundredAnd", "NineHundredAnd");
	public static String thousand = "OneThousand";
	public static void main(String[] args){
		
		int count=0;
		int hInd, tenInd;
		int hundredLen, tenLen;
		for(hInd=0; hInd<hundreds.size(); hInd++){
			hundredLen = hundreds.get(hInd).length();
			for(tenInd=0; tenInd<tens.size(); tenInd++){
				tenLen = tens.get(tenInd).length();
				count = countOnes(count, hundredLen, tenLen);
			}
			count+=hundredLen+3; //for "Ten"
			count = countTeens(count, hundredLen);
		}
		count+= thousand.length();
		System.out.println(count);
	}
	public static int countOnes(int curCount, int hundredLen, int tenLen){
		int oInd;
		for(oInd=0; oInd<ones.size(); oInd++){
			curCount+= hundredLen + tenLen + ones.get(oInd).length();
		}
		return curCount;
	}
	
	public static int countTeens(int curCount, int hundredLen){
		int teenInd;
		for(teenInd=0; teenInd<teens.size(); teenInd++){
			curCount+= hundredLen + teens.get(teenInd).length();
		}
		return curCount;
	}
	
	
	
}
