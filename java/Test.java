
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) {
        setTimer(0, 0, 0, 10, 100);
    }
    public static void setTimer(int days, int hours, int minutes, int seconds, int millis) throws InterruptedException {
        System.out.println("Таймер запущен!");
        TimeUnit.DAYS.sleep(days);
        TimeUnit.HOURS.sleep(hours); 
        TimeUnit.MINUTES.sleep(minutes);
        TimeUnit.SECONDS.sleep(seconds);
        TimeUnit.MILLISECONDS.sleep(millis); 
        System.out.println("♬ ♪ ♬♬♬♬ ♪♪♪♪");
    }
}
                               





























                                                                 





/*public class Test {
    public static void main(String[] args) {
        int[] intArgs = new int[args.length + 1];
        int subtitle = 0;
        for(int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
            subtitle += sum(intArgs[i], intArgs[i + 1]);
        }
        System.out.println(">    " + subtitle);
    }
    public static int sum(int intArgsOno, int intArgsTwo) {
        return intArgsOno + intArgsTwo;
    }
}*/