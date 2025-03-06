public class PseudoGraphic {
		static int speedArgs, forArgs;
		public static void main(String[] args) {
			speedArgs = Integer.parseInt(args[0]);
			forArgs = Integer.parseInt(args[1]);
			wrint(forArgs, speedArgs);
	}

	static void grc(int count) {
		for (int i = 0 ; i < count ; i++) {
			double d = Math.random();
			d = d * 1000000;
			int is = (int) d;
			System.out.println((i + 1) + ":\n| >	Origin random:  " + is);
			is = is << 1;
			sleep(400 / count);
			System.out.println("| >	Binary right:   " + is);
			is = is >> 1;
			sleep(400 / count);
			System.out.println("| >	Binary left:    " + is + "\n\n");
			sleep(4000 / count);
		}
	}
	static void wrint(int forArgs, int speedArgs) {
		for (int n = 0 ; n < forArgs ; n++) {
			for (int i = 0 ; true ; i++) {
				for (int j = 0 ; j < i ; j++) {
					try {
						Thread.sleep(speedArgs);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print(" ");
					System.out.print("\u001B[32m" + "¿\f?\f");
				}
			} //System.out.println("");
		}
	}

	static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}