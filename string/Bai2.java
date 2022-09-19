package string;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicMenuUI.ChangeHandler;

public class Bai2 {

	public static void main(String[] args) {
		String str=new String();
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhap xau ky tu: ");
		str=sc.nextLine();
		System.out.print("=>Xen ke in hoa, in thuong: ");
		System.out.println(xenKeHoaThuong(str));;
	}

	public static StringBuilder xenKeHoaThuong(String str) {
		StringBuilder sb=new StringBuilder();
		int length=str.length();
		String[] str2= new String[length];
		
		for(int i=0; i<length; i++) {
			str2[i]=String.valueOf(str.charAt(i));
		}
		for(int i=0; i<length; i++) {
			if(i%2==0) {
				sb.append(str2[i].toUpperCase());
			}else {
				sb.append(str2[i].toLowerCase());
			}
		}
		return sb;
	}
}
