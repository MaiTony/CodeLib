package Test;

public class TestO {
	public static void main(String[] args) {
		int i=8;
		int j=i-1;
		while(j>=1&&j>i/2){
			if(j!=i-j){
				System.out.println((i-j)+"+"+ j);
			}
			j--;
		}
	}

}
