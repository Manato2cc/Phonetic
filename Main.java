import java.io.*;
import java.util.HashMap;

public class Main{

	public HashMap<String, String> WORDS = new HashMap<String, String>();
	public HashMap<String, String> TABLE = new HashMap<String, String>();
	public static void main(String[] args){
		FileCreate fc = new FileCreate();
		try{
			File file = new File("./eigo.7b");
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);

			String resultStr = "";

			String str = br.readLine();
			String[] re;
			while(str != null){
				re = str.split("  ");

				fc.WORDS.put(re[0], re[1]);
				
				str = br.readLine();
			}

			File file1 = new File("./table.txt");
			FileReader filereader1 = new FileReader(file1);
			BufferedReader br1 = new BufferedReader(filereader1);

			String resultStr1 = "";

			String str1 = br1.readLine();
			String[] re1;
			while(str1 != null){
				re1 = str1.split(" ");

				fc.TABLE.put(re1[0], re1[1]);
				
				str1 = br1.readLine();
			}

			String v = "";
			for (String s : args) {
				v = fc.WORDS.get(s.toUpperCase());
				if(v != null){
					String[] w = v.split(" ");
					String y = "";
					for (String x : w) {
						y += fc.TABLE.get(x);
					}
					System.out.print(y+" ");
				}
			}
			System.out.println("");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}