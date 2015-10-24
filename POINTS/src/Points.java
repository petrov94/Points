import java.util.Scanner;

public class Points {

	static void Points_new(int x, int y, String commands) {
		boolean flag = false;
		int nums = 0;
		for (int i = 0; i < commands.length(); i++) {
			char num=commands.charAt(i);
			if (num=='~') {
				nums++;
				if(nums%2!=0){
					flag=true;
				}
				else flag=false;
			}
			
			
			if (num=='<' & flag == false) {
				x--;
			} else if (num=='>' & flag == false) {
				x++;
			} else if (num=='^' & flag == false) {
				y--;
			} else if (num=='v' & flag == false) {
				y++;
			} else if (num=='<' & flag == true) {
				x++;
			} else if (num=='>' & flag == true) {
				x--;
			} else if (num=='^' & flag == true) {
				y++;
			} else if (num=='v' & flag == true) {
				y--;
			}

		}
		System.out.println("New x: " + x + " New y: " + y);

	}

	public static void main(String[] args) {
		int a, b;
		String commands = new String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter na x");
		a = sc.nextInt();

		System.out.println("Enter na y");
		b = sc.nextInt();

		System.out.println("Enter the commands");
		commands = sc.next();

		Points_new(a, b, commands);
		sc.close();
	}

}
