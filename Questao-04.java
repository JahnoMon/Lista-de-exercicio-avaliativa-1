/*
Escreva um programa em Java que represente uma Senha. Faça o método
criptografar() que aplica algum algoritmo de criptografia a essa senha. Faça também o
método descriptografar(), que, a partir de um código criptografado, realiza a sua
descriptografia. O algoritmo de criptografia em questão é livre, desde que seja feito “na
mão” por você. Utilize sua criatividade para pensar em um algoritmo de criptografia
interessante.
*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Senha {
    private static final String chaveSecreta = "MinhaChaveSecreta";

    public static String criptografar(String senha) {
        try {
            SecretKeySpec chave = new SecretKeySpec(chaveSecreta.getBytes(), "AES");
            Cipher cifra = Cipher.getInstance("AES"); 
            cifra.init(Cipher.ENCRYPT_MODE, chave); 
            byte[] textoCifrado = cifra.doFinal(senha.getBytes()); 
            return Base64.getEncoder().encodeToString(textoCifrado); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String descriptografar(String senhaCriptografada) { ;
        try {
            SecretKeySpec chave = new SecretKeySpec(chaveSecreta.getBytes(), "AES"); 
            Cipher cifra = Cipher.getInstance("AES");
            cifra.init(Cipher.DECRYPT_MODE, chave); 
            byte[] textoDecifrado = cifra.doFinal(Base64.getDecoder().decode(senhaCriptografada)); 
            return new String(textoDecifrado); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chaveSecreta;
    }

    public static void main(String[] args) {
        String senhaOriginal = "MinhaSenhaSecreta";
        String senhaCriptografada = criptografar(senhaOriginal);
        System.out.println("Senha Criptografada: " + senhaCriptografada);

        String senhaDescriptografada = descriptografar(senhaCriptografada);
        System.out.println("Senha Descriptografada: " + senhaDescriptografada);
    }
}
