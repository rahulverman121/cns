import javax.crypto.*;
import java.io.*;
import java.util.Scanner;
public class DES 
{
    public static void main(String[] args) 
    {
        try 
        {
            Scanner sc = new Scanner(System.in);
            String plaintext;
            System.out.println("\nenter a message:");
            plaintext= sc.nextLine();
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            SecretKey mydeskey= kg.generateKey();
            Cipher c= Cipher.getInstance("DES/ECB/PKCS5Padding");
            byte[]text=plaintext.getBytes();
            System.out.println("\nText in bytes: \t" +text);
            System.out.println("\nThe text: \t"+new String(text));
            c.init(Cipher.ENCRYPT_MODE, mydeskey);
            byte[] textenc=c.doFinal(text);
            System.out.println("\nEncrypted text in bytes: \t"+textenc);
            System.out.println("\nEncrypted text: \t"+new String(textenc));
            c.init(Cipher.DECRYPT_MODE, mydeskey);
            byte[] textdec = c.doFinal(textenc);
            System.out.println("\nthe decrypted text in bytes: \t" +textdec);
            System.out.println("\nthe decrypted text: \t" + new String(textdec));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
