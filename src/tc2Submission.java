import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tc2Submission {

	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Map<Integer, String> trans = new HashMap<Integer, String>();
		for(Integer i= 1; i<=alphabet.length(); i++){
			trans.put(i, Character.toString(alphabet.charAt(i-1)));
		}
		trans.put(27, " ");;
		int[] msg1 = {14,5,22,5,18,27,7,15,9,14,7,27,20,15,27,7,9,22,5,27,25,15,21,27,21,16,27,14,5,22,5,18,27,7,15,9,14,7,27,20,15,27,12,5,20,27,25,15,21,27,4,15,23,14};
		List<Integer> msg = new ArrayList<Integer>();
		for (int index = 0; index < msg1.length; index++) msg.add(msg1[index]);
		String decr = "";
		for(int j = 0; j<msg.size(); j++){
			decr += trans.get(msg.get(j));
		}
		System.out.println(decr);

	}

}
