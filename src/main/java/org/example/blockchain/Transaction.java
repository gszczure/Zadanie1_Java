package org.example.blockchain;

import org.example.hash.Hash;

public class Transaction implements ITransaction {

    private Double amount;
    private int nonce;
    private String lastTransaction;
    private String foundHash;

    private static final Hash hasher = Hash.getInstance();

    public Transaction(String lastTransaction, Double amount) {
        this.lastTransaction = lastTransaction;
        this.amount = amount;
    }

    @Override
    public void findNonce() {
        nonce = 0;
        while (true) {
            String hash = hasher.hashgenerate(toString());
            if (hash.endsWith("00000")) {
                foundHash = hash;
                return;
            }
            nonce++;
        }
    }

    public String getFoundHash() {
        return foundHash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"amount\": " + amount + ",\n" +
                "  \"lastTransaction\": \"" + lastTransaction + "\",\n" +
                "  \"nonce\": " + nonce + "\n" +
                "}";
    }

}
