/**
 *
 * Descrição:Classe Utils
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 17-Apr-2013
 *
 * @version 1.0.0
 *
 */
package br.com.jspproject.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Utils {

    /**
     * Preenche a string definida com um substituidor até
     * o tamanho definido a esquerda.
     *
     * @param String valueToPad String que será preenchida
     * @param String filler Valor a preencher
     * @param int size tamanho total da string
     *
     * @return String
     */
    public static String lpad(String valueToPad, String filler, int size) {
        while (valueToPad.length() < size) {
            valueToPad = filler + valueToPad;
        }
        return valueToPad;
    }

    /**
     * Preenche a string definida com um substituidor até
     * o tamanho definido a direita.
     *
     * @param String valueToPad String que será preenchida
     * @param String filler Valor a preencher
     * @param int size tamanho total da string
     *
     * @return String
     */
    public static String rpad(String valueToPad, String filler, int size) {
        while (valueToPad.length() < size) {
            valueToPad = valueToPad + filler;
        }
        return valueToPad;
    }

    /**
     * Criptografa uma String para sha1
     *
     * @param String senha
     *
     * @return String
     */
    public static String encryptSenha(String senha) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(senha.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
            return sha1;
        } catch (NoSuchAlgorithmException e) {
            return e.getMessage();
        } catch ( UnsupportedEncodingException ex) {
            return ex.getMessage();
        }
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
