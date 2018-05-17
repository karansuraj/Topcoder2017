public class tc3Submission {
	public static void main(String[] args) {
		String num = "";
		int tmpInt = 0;
		int fact = 1;
		int sum =0;
		int totSum = 0;
		for(int i = 1; i<10000000; i++){
			num = Integer.toString(i);
			sum=0;
			for(int j = 0; j<num.length(); j++){
				fact=1;
				tmpInt = Character.getNumericValue(num.charAt(j));
				for(int k=1;k<=tmpInt;k++) fact=fact*k;
				sum+=fact;
			}
			if(i==sum) {
				totSum+= sum;
				System.out.println(sum);
			}
			
		}
		System.out.println(totSum);
		
	}
}
