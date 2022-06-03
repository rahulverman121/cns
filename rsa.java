import java.util.Scanner;
import java.io.*;
public class rsa {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the prime number");
		int e=2;
		int d=2;
		int p=sc.nextInt();
		System.out.println("Enter another prime number");
		int q=sc.nextInt();
		int n=p*q;
		int phi=(p-1)*(q-1);
		for(int i=2;i<phi;i++) {
			if(gcd(i,phi)==1) {
				if(i==3)
					continue;
				else {
				e=i;
				break;
			}
			}
		}
		System.out.println("the value of e is "+e);
		for(int k=1;  ;k++) {
			if(((k*e)%phi)==1) {
				d=k;
				break;
			}
		}
		System.out.println("The value of d is"+d);
		System.out.println(" public key{"+e+","+n+"}");
		System.out.println(" private key{"+d+","+n+"}");
	}
	public static int gcd(int a,int b) {
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
}
