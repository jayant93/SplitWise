package com.splitwise.main;

import java.util.ArrayList;
import java.util.Map;

public class Expense {

	public static void expense(User payer, ArrayList<User> users, EXPENSETYPE expenseType, Float amount,
			Float[] shares) {

		if (expenseType == EXPENSETYPE.EQUAL) {
			for (int i = 0; i < users.size(); i++) {

				if (users.get(i) != payer) {

					if (!users.get(i).transaction.entrySet().isEmpty()) {

						for (Map.Entry<String, Float> me : users.get(i).transaction.entrySet()) {
							users.get(i).transaction.put(payer.userId,
									me.getValue() != null ? me.getValue() + amount / (users.size())
											: amount / (users.size()));

						}

					} else {
						users.get(i).transaction.put(payer.userId, amount / (users.size()));
					}
				}
			}

		}

		if (expenseType == EXPENSETYPE.EXACT) {
			int j = 0;
			for (int i = 0; i < users.size(); i++) {

				if (users.get(i) != payer) {

					if (!users.get(i).transaction.entrySet().isEmpty()) {

						for (Map.Entry<String, Float> me : users.get(i).transaction.entrySet()) {
							users.get(i).transaction.put(payer.userId,
									me.getValue() != null ? me.getValue() + shares[j] : shares[j]);

						}

					} else {
						users.get(i).transaction.put(payer.userId, shares[j]);
					}
					j++;

				}
			}
		}

	}

}
