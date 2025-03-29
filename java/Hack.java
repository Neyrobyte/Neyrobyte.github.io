/*
* Читай описание метода hackEmitter()
*/
public class Hack {
    private static final float DEFAULT_RANGE_MULTIPLIER = 500;
    private static final int DEFAULT_SPEED = 1;
    private static final String EXCEPTION_MESSAGE = "   Ошибочный формат параметров. Используйте: [int, int, boolean, float]";

    public static void main(String[] args) {
        try {
            int charCount = (args.length > 0) ? Integer.parseInt(args[0]) : -1;
            int speed = (args.length > 1) ? Integer.parseInt(args[1]) : DEFAULT_SPEED;
            boolean green = (args.length > 2) ? Boolean.parseBoolean(args[2]) : true;
            float rangeMultiplier = (args.length > 3) ? Float.parseFloat(args[3]) : DEFAULT_RANGE_MULTIPLIER;
            
            hackEmitter(charCount, speed, green, rangeMultiplier);
        }
        catch (NumberFormatException e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    }

    /*
     * Метод hackEmitter() выводит случайные символы с заданной скоростью и цветом.
     *
     * charCount – Количество символов для вывода. Если отрицательное, вывод бесконечный.
     * speed – Задержка между выводом каждого символа (в миллисекундах).
     * green – Если true, текст будет зеленым.
     * rangeMultiplier – Множитель для рандомного индекса символа 
     */
    static void hackEmitter(int charCount, int speed, boolean green, float rangeMultiplier) {
        String color = (green) ? "\u001B[32m" : "";
        boolean infinite = charCount < 0;
        
        while(infinite || charCount-- > 0) {
            char result = (char) (Math.random() * rangeMultiplier); // Печатает символы ASCII по рандомному значению
            System.out.print(color + result);
            try {
                Thread.sleep(speed);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("\nПроцесс прерван.");
                break;
            }
        }
    }
}