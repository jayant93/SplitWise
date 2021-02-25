package com.splitwise.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum EXPENSETYPE {
	EXACT, EQUAL
}

public class SplitWise {

	static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) {

		users.add(new User("gunnu", "Gunjan Chaudhary"));
		users.add(new User("jay", "Jayant Chaudhary"));
		users.add(new User("op", "Om Prakash"));

		for (int i = 0; i < users.size(); i++) {
			users.get(i).transaction = new HashMap<String, Float>();
		}

		Expense.expense(users.get(0), users, EXPENSETYPE.EQUAL, 1000f, null);

		Float[] cuts = { 370f, 850f };
		Expense.expense(users.get(0), users, EXPENSETYPE.EXACT, 1000f, cuts);
		// Expense.expense(users.get(0), users, EXPENSETYPE.EQUAL, 1500f,null);
		show();
		//show(users.get(1));

	}

	// will show all transactions
	public static void show() {
		for (int i = 0; i < users.size(); i++) {
			for (Map.Entry<String, Float> me : users.get(i).transaction.entrySet()) {
				System.out.println(users.get(i).userId + "  Owes " + me.getKey() + " = " + me.getValue());
			}

		}
	}

	// will show transaction for particular user
	public static void show(User user) {
		for (Map.Entry<String, Float> me : user.transaction.entrySet()) {
			System.out.println(user.userId + "  Owes " + me.getKey() + " = " + me.getValue());
		}
	}

}
