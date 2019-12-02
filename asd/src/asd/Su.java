package asd;

import java.util.Scanner;

public class Su {
	public static void main(String[] args) {
		
		int su = 0;
		int value =0;
		int result = 0;
		String buho;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수를입력하세요");
		su=sc.nextInt(); 		//int 에서 엔터를 눌르면 부호 수 같이출력되는데 nextLine 쓰면 개행처리가안되서 
		sc.nextLine();  
		System.out.println("부호를 입력하세요");
		buho=sc.nextLine();
		System.out.println();
		System.out.println("수를 입력하세요");
		value=sc.nextInt();
		
		if(buho.equals("+")) {
			System.out.println(su+value+result);
		}else if(buho.equals("-")) {
			System.out.println(su-value+result);
		}else if(buho.equals("*")) {
			System.out.println(su*value+result);
		}else if(buho.equals("/")) {
			System.out.println(su/value+result);
		}else {
			System.out.println("값을 제대로 입력해주세요.");
		}
	}
	}

