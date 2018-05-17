
public class tc5Submission {

	public static void main(String[] args) {
		int lenDigits = 0;
		int i = 0;
		for (i = 1000; i > 1; i--) {
		    if (lenDigits >= i) break;
		    int[] repDigits = new int[i];
		    int val = 1;
		    int place = 0;
		    while (repDigits[val] == 0 && val != 0) {
		        repDigits[val] = place;
		        val *= 10;
		        val %= i;
		        place++;
		    }
		    if (place - repDigits[val] > lenDigits) lenDigits = place - repDigits[val];
		}
		System.out.println(i);
		System.out.println(lenDigits);
	}

}
