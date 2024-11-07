package org.example.hash;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash implements Ihash {

    private static final Hash INSTANCE = new Hash();

    public Hash() {
    }

    public static Hash getInstance() {
        return INSTANCE;
    }

    @Override
    public  String hashgenerate(String hash) {
        return DigestUtils.md5Hex(hash);
    }
}