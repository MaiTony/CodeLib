import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class R054Div2B {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.close();
		
		TreeSet<Integer> ans=new TreeSet<Integer>();
		ans.add(n);
		
		while(n>1){
			TreeSet<Integer> set=new TreeSet<Integer>();
			for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				boolean can=true;
				for(int j:ans){
					if(j%(n/i)!=0){
						can=false;
						break;
					}
				}
					if(can)
						set.add(n/i);
				}
			}
			if(set.size()>0){
				n=set.last();
				ans.add(n);
			}else{
				break;
			}
		}
		ans.add(1);
		PrintWriter out=new PrintWriter(System.out);
		for(Iterator<Integer> x=ans.descendingIterator();x.hasNext();)
			out.print(x.next()+" ");
		out.flush();
	}

}
