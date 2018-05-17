import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class FileIOReadByChars {

	public static void readFilebyChars(String fname){
		try {
			List<String> combList = Arrays.asList("259","295","529","592","925","952");
			char chOldPrev=0, chPrev = 0, chCurr;
			int chInt, count=0;//,piInd=0;
			Charset enc = Charset.defaultCharset();
			InputStream piFile = new FileInputStream(fname);
			Reader freader =  new InputStreamReader(piFile, enc);
			BufferedReader bread = new BufferedReader(freader);
			while((chInt = bread.read())!= -1){//for(i=0;i<6;i++){line = bread.readLine();
				chCurr = (char)chInt;
				StringBuffer compBuff = new StringBuffer(3);
				compBuff.append(chOldPrev); compBuff.append(chPrev); compBuff.append(chCurr);
				//System.out.println(compBuff);
				if(combList.contains(compBuff.toString())) count++;
				chOldPrev = chPrev;
				chPrev = chCurr;				
			}
			System.out.println(count);
			bread.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		readFilebyChars("pi.txt");
	}

}
