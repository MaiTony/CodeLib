package Theorem;

public class ModularMultiplicativeInverse {

	public static void main(String[] args) {
		int a=3;
		int m=11;
		int b=a;
		while(b%m!=1){
			b+=a;
		}
		System.out.println(b);
		for(int i=0;i<10;i++)
			System.out.println(b/a+(m*i));

	}

}
