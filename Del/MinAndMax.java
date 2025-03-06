public class MinAndMax {
    int subtotalNum;
    public static void main(String[] args) {
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
        } 
        for (int i = 1; i < intArgs.length; i++) {
            subtotalNum = Math.min(intArgs[i], intArgs[i - 1]);
        }
        System.out.println(subtotalNum);
    }
}