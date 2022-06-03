import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class des {
	public static void main(String args[])
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			String plaintext;
			System.out.println(" enter message");
			plaintext=sc.nextLine();
			KeyGenerator kg=KeyGenerator.getInstance("DES");
			SecretKey mydeskey=kg.generateKey();
			Cipher c= Cipher.getInstance("DES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE,mydeskey);
			byte[]text=plaintext.getBytes();
			System.out.println("text in bytes"+text);
			System.out.println("the text"+new String(text));
			byte[]textenc=c.doFinal(text);
			System.out.println("text Encrypt"+textenc);
			System.out.println("the Encrypted"+new String(textenc));
			c.init(Cipher.DECRYPT_MODE,mydeskey);
			byte[]textdec=c.doFinal(textenc);
			System.out.println("Decrypt text in bytes"+textdec);
			System.out.println("Decrypted text"+new String(textdec));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
