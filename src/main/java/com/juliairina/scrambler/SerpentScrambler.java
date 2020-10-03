package com.juliairina.scrambler;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SerpentScrambler {

    private final int KEY_SIZE = 256;
    private final int EXPIRATION_TIME = 3;
    private byte[] iv;
    private SecretKey key;
    private KeyGenerator keyGenerator;
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    private int expirationTime;

    public SerpentScrambler(byte[] encodedKey, byte[] iv) throws GeneralSecurityException {
        keyGenerator = KeyGenerator.getInstance("Serpent", "BC");
        keyGenerator.init(KEY_SIZE);

        expirationTime = EXPIRATION_TIME;

        this.key = new SecretKeySpec(encodedKey, "Serpent");
        this.iv = iv;

        encryptCipher = Cipher.getInstance("Serpent/CFB/NoPadding", "BC");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        decryptCipher = Cipher.getInstance("Serpent/CFB/NoPadding", "BC");
        decryptCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
    }

    public void changeKey(SecretKey key, byte[] iv) throws GeneralSecurityException {
        this.key = key;
        this.iv = iv;

        encryptCipher = Cipher.getInstance("Serpent/CFB/NoPadding", "BC");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        decryptCipher = Cipher.getInstance("Serpent/CFB/NoPadding", "BC");
        decryptCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
    }

    public byte[] encrypt(byte[] data)
            throws GeneralSecurityException {
        expirationTime--;
        return encryptCipher.doFinal(data);
    }

    public byte[] decrypt(byte[] cipherText)
            throws GeneralSecurityException {
        return decryptCipher.doFinal(cipherText);
    }

    public boolean isKeyExpired() {
        return expirationTime == 0;
    }

    public int getKEY_SIZE() {
        return KEY_SIZE;
    }

    public int getEXPIRATION_TIME() {
        return EXPIRATION_TIME;
    }

    public byte[] getIv() {
        return iv;
    }

    public SecretKey getKey() {
        return key;
    }

    public KeyGenerator getKeyGenerator() {
        return keyGenerator;
    }

    public Cipher getEncryptCipher() {
        return encryptCipher;
    }

    public Cipher getDecryptCipher() {
        return decryptCipher;
    }

    public int getExpirationTime() {
        return expirationTime;
    }
}
