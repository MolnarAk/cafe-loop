package hu.ma.cfl.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class SecurityUtils {

    // Base64 kódoló és dekódoló
    // Röviden a Base64-ről: https://hu.wikipedia.org/wiki/Base64
    // A lényege, hogy ezekkel az osztályokkal olvashatatlan bájtokból olvasható String-eket tudunk nyerni
    private static final Encoder ENCODER = Base64.getEncoder();
    private static final Decoder DECODER = Base64.getDecoder();

    // A kriptográfiai hash függvény nevét String-ként adjuk meg
    // A java.security csomagban használt algoritmusokra nevükkel hivatkozunk
    // Az alábbi algoritmus függvény az egyik legbiztonságosabb hash függvény
    // További infó: https://www.baeldung.com/java-password-hashing
    public static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA1";

    public static String encryptPassword(String password, byte[] salt) {
        try {
            // Kriptográfiai kulcs specifikáció
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

            // Titkosítást reprezentáló megoldás valamilyen algoritmus felhasználásával
            SecretKeyFactory factory = SecretKeyFactory.getInstance(HASH_ALGORITHM);

            // Titkos kulcsot generálunk, majd elkódoljuk bájtokba
            byte[] encodedPassword = factory.generateSecret(spec).getEncoded();

            // Olvasható Base64 String-et csinál a bájtokból
            return ENCODER.encodeToString(encodedPassword);

        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            // Ha ilyen kivétel keletkezik, ha rosszul van konfigurálva a SecretKeyFactory
            throw new RuntimeException(e);
        }
    }

    public static String encryptPassword(String password, String salt) {
        return encryptPassword(password, DECODER.decode(salt));
    }

    public static String encodeSalt(byte[] salt) {
        return ENCODER.encodeToString(salt);
    }

}
