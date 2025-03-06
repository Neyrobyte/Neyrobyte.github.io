public class ASCIITable {
	public static void main(String[] args) {
		for (char ch = 0; ch < 127 ; ch++) {
			try {				
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
                   e.printStackTrace();
               }
			System.out.print(ch + "  ");		
		}
	}
}