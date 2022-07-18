package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class AccountMain {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double limit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, limit);

		System.out.println();
		System.out.println("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		// quando digitar o saque deve chamar o método para sacar
		try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f ", acc.getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}

}
