public class SinX {
    public static int N = 25;

    public static void drawValue(double y) {
        int value = (int) (y * N) + N;
        for (int i = 0; i < 2 * N; i++) {
            char c = i == N ? '|': '.';
            if (i == value) {c = '*';}
            System.out.print("\u001B[32m" + c);
        }
    System.out.println();
    }

   public static void main(String[] args)
   {
     for (int i = 0; i < 10 * N; i++)
     {
       double x = i * 1.0 / N;
       double y = Math.sin(x);
       drawValue(y);
     }
   }
}