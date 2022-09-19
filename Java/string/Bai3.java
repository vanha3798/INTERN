package string;

import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		String str=new String();
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhap xau ky tu: ");
		str=sc.nextLine();
		System.out.print("=>Chuan hoa: ");
		System.out.println(chuanHoa(str));
		
	}
	public static StringBuilder chuanHoa(String str) {
		StringBuilder sb=new StringBuilder();
		boolean readed=false, firstRead=false;
		int length=str.length();
		String[] string= new String[length];
		
		for(int i=0; i<length; i++) {
			string[i]=String.valueOf(str.charAt(i));
		}
		
		for(int i=0; i<length; i++) {
			if(string[i].equals(" ")==false && string[i].equals("\t")==false) {
				if(firstRead==false) {
					sb.append(string[i].toUpperCase());
					firstRead=true;
					readed=true;
				}else {
					sb.append(string[i].toLowerCase());
				}
			}
			else{
				if(readed==true) {
					sb.append(" ");
					readed=false;
					firstRead=false;
				}
			}
		}
		return sb;
	}
}
