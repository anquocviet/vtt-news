package fit.se.vttblog.backend.services;

import fit.se.vttblog.backend.exceptions.AppException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
public class CypherService {
   private static final SecureRandom RAND = new SecureRandom();

   private static final int ITERATIONS = 65536;
   private static final int KEY_LENGTH = 512;
   private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

   private final static Logger logger = Logger.getLogger(CypherService.class.getName());

   private CypherService() {
   }

   public static Optional<String> generateSalt(final int length) {
      if (length < 1) {
         logger.severe("error in generateSalt: length must be > 0");
         throw new AppException(500, "Internal error");
      }

      byte[] salt = new byte[length];
      RAND.nextBytes(salt);

      return Optional.of(Base64.getEncoder().encodeToString(salt));
   }

   public static Optional<String> hashPassword(String password, String salt) {

      char[] chars = password.toCharArray();
      byte[] bytes = salt.getBytes();

      PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

      Arrays.fill(chars, Character.MIN_VALUE);

      try {
         SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
         byte[] securePassword = fac.generateSecret(spec).getEncoded();
         return Optional.of(Base64.getEncoder().encodeToString(securePassword));

      } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
         logger.severe("Exception encountered in hashPassword: " + ex.getMessage());
         throw new AppException(500, "Internal error");

      } finally {
         spec.clearPassword();
      }
   }

   public static boolean verifyPassword(String password, String key, String salt) {
      Optional<String> optEncrypted = hashPassword(password, salt);
      return optEncrypted.map(s -> s.equals(key)).orElse(false);
   }
}
