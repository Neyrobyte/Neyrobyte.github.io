import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "out.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class SmoothOut {
	public static void main(String[] args) {
		int intArgs = Integer.parseInt(args[1]);
		//smPrint(args[0], intArgs);
		//smPrint(ss, 5);
	}
	public static void smPrint(String text, int time) {
		for (int i = 0; i < text.length(); i++) {
        	char ch = text.charAt(i);
             System.out.print(ch);
             try {Thread.sleep(time);}
             catch (InterruptedException e) {e.printStackTrace();}
         }
         System.out.println("");
	}
}