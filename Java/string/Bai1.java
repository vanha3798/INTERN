package string;

public class Bai1 {
	public static void main(String[] args) {
		System.out.println("Cac so thuan nghich co 6 chu so: ");
		for(int a=1; a<=9; a++) {
			for(int b=1; b<=9; b++) {
				for(int c=1; c<=9; c++) {
					StringBuilder sb= new StringBuilder();
					sb.append(a).append(b).append(c).append(c).append(b).append(a);
					System.out.println(sb.toString());
				}
			}
		}
	}
}
