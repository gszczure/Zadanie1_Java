package org.example;

import org.example.blockchain.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[] args) {
        String lastTransaction = "4d00d79b6733c9cc066584a02ed03410";

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random random = new Random();

            double amount = random.nextInt(1000);
            Transaction transaction = new Transaction(lastTransaction, amount);

            transaction.findNonce();
            transactions.add(transaction);

            lastTransaction = transaction.getFoundHash();
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            System.out.println("Hash: " + transaction.getFoundHash());
            System.out.println();
            System.out.println("---------------------------------------------------");

        }
    }
}
