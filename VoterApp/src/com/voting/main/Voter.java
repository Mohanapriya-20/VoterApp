package com.voting.main;

import com.voting.exception.NotEligibleException;
import com.voting.service.ElectionBooth;
import java.util.Scanner;

public class Voter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectionBooth booth = new ElectionBooth();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Age ");
		int age = sc.nextInt();
		System.out.println("Enter Street Name");
		sc.nextLine();
		String sname = sc.nextLine();
		System.out.println("Enter Voter's ID");
		int id = sc.nextInt();
		try {
			booth.checkEligibility(age, sname, id);
		} catch (NotEligibleException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			sc.close();
		}
	}

}
