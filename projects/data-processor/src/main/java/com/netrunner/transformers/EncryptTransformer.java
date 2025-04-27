package com.netrunner.transformers;

import com.netrunner.core.DataTransformer;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptTransformer implements DataTransformer<String> {
    @Override
    public String transform(String input, String... params) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        try {
            String key = params[0]; // Chave de criptografia
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }
}