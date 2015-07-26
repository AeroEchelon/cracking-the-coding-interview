
public class DivideDemo {
	
	public static void main(String args[]) {
		try {
			int arg1 = Integer.valueOf(args[0]);
			int arg2 = Integer.valueOf(args[1]);
			int divider = Integer.valueOf(args[2]);

			int result = (arg1 + arg2) / 2;
			System.out.println(String.format("(%1$s + %2$s) / %3$s = %4$s", arg1, arg2, divider, result));
		} catch (Exception e) {
			System.out.println("Please ensure that your input is in the following format: ");
			System.out.println("java " + DivideDemo.class.getSimpleName() + " ARG1 ARG2 DIVIDER");
		}

	}
}