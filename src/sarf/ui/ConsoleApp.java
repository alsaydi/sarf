package sarf.ui;

import java.util.Scanner;

public class ConsoleApp {
	public static void main(String[] args) {
		(new ConsoleApp()).Run();
	}
	
	void Run() {
		Scanner scanner = new Scanner(System.in);
		String root = scanner.nextLine();
		System.out.println(root);		
	}
}
