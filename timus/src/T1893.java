package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1893 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String seat = in.next();
		
		int row = 0;
		int col = 0;
		if (seat.length() == 2) {
			row = seat.charAt(0) - '0';
			col = seat.charAt(1) > 'I' ? seat.charAt(1) - 'A' : seat.charAt(1) - 'A' + 1;
		} else {
			row = Integer.parseInt(seat.substring(0, 2));
			col = seat.charAt(2) > 'I' ? seat.charAt(2) - 'A' : seat.charAt(2) - 'A' + 1;
		}
		
		if (row <= 2) {
			if (col == 2 || col == 3) {
				out.println("aisle");
			} else {
				out.print("window");
			}
		} else if (row >= 3 && row <= 20) {
			if (col == 1 || col == 6) {
				out.println("window");
			} else {
				out.print("aisle");
			}
		} else {
			if (col == 1 || col == 10) {
				out.println("window");
			} else if (col == 3 || col == 4 || col == 7 || col == 8) {
				out.print("aisle");
			} else {
				out.print("neither");
			}
		}
		out.flush();
		in.close();
	}

}
