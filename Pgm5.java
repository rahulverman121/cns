Program 5

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import sun.misc.BASE64Encoder;
public class BlowFish {
    public static void main(String[] args) throws Exception {
        logic here KeyGeneratorkeyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();
        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
        BASE64Encoder encoder = new BASE64Encoder();
        byte iv[] = cipherOut.getIV();
        if (iv != null) {
            System.out.println("Initialization Vector of the Cipher: " + encoder.encode(iv));
            FileInputStream fin = new FileInputStream("inputFile.txt");
            FileOutputStreamfout = new FileOutputStream("outputFile.txt");
            CipherOutputStreamcout = new CipherOutputStream(fout, cipherOut);
            int input = 0;
            while ((input = fin.read()) != -1) {
                fin.close();
                cout.close();
            }
        }
    }
}
