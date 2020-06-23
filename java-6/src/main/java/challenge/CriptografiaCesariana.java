package challenge;

public class CriptografiaCesariana implements Criptografia {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final int SHIFT = 3;

    @Override
    public String criptografar(String texto) {
        return caesarCipher(texto, "ENCRYPT");
    }

    @Override
    public String descriptografar(String texto) {
        return caesarCipher(texto, "DECRYPT");
    }

    private String caesarCipher(String message, String type) {
        if (message.isEmpty()) {
            throw new IllegalArgumentException("The text cannot be empty!");
        }

        char[] letters = message.toLowerCase().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int charIndex = ALPHABET.indexOf(letters[i]);
            if (charIndex >= 0) {
                charIndex = type.toUpperCase() == "ENCRYPT" ? charIndex + SHIFT : Math.abs(charIndex - SHIFT);
                letters[i] = ALPHABET.toCharArray()[charIndex % ALPHABET.length()];
            }
        }
        return new String(letters);
    }
}
