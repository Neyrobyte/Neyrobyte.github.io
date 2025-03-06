/*
* Метод hackEmitter() принимает аргументы:
* int charCount – Сколько будет написано символов (в том числе невидимых)
* int speed – задержка между выводом каждого символа
* boolean green – будет ли цвет текста зеленым
*/
public class Hack {	
	static char result;
	static double d;
	static String exeptionMessage = "×	Ошибочный формат параметров. Используйте:\n [int, int, boolean]";
	public static void main(String[] args) {
		// Ветвление для корректной работы с 0, 1, 2 и 3 переданными аргументами
		if(args.length == 0) {
			hackEmitter(-1, 1, true);
		} 
		else if(args.length == 1) {
			try {
				int intArgs0 = Integer.parseInt(args[0]);
				hackEmitter(intArgs0, 1, true);
			}
			catch (NumberFormatException e) {System.out.println(exeptionMessage);}
			
		}
		else if(args.length == 2) {
			try {
				int intArgs0 = Integer.parseInt(args[0]);
				int intArgs1 = Integer.parseInt(args[1]);
				hackEmitter(intArgs0, intArgs1, true);
			}
			catch (NumberFormatException e) {System.out.println(exeptionMessage);}			
		}		
		else if(args.length == 3 || args.length >= 3) {
			try {
				int intArgs0 = Integer.parseInt(args[0]);
				int intArgs1 = Integer.parseInt(args[1]);
				boolean boolArgs = Boolean.parseBoolean(args[2]);
				hackEmitter(intArgs0, intArgs1, boolArgs);
			}
			catch (NumberFormatException e) {System.out.println(exeptionMessage);}
		}		
	}

	static void hackEmitter(int charCount, int speed, boolean green) {
		String color = "";
		if(green) {color = "\u001B[32m";}
		for(int i = 0; i < charCount || charCount < 0; i++) {
			d = Math.random();
			result = (char) (d * 500.0);
			System.out.print(color + result);
			try {Thread.sleep(speed);}
        	catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}