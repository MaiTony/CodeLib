package Theorem;

public class ChineseRemainder {

	public static void main(String[] args) {
		int[] d={3,5,7};
		int[] r={2,3,2};
		
		int[] m={0,0,0};
		int[] t={0,0,0};
		
		int i,sum,e,res;
		
		//total for a
		sum=1;
		for(i=0;i<d.length;i++){
			sum*=d[i];
		}
		//every m for d
		for(i=0;i<r.length;i++){
			m[i]=sum/d[i];
		}
		//inverse m to t
		for(i=0;i<d.length;i++) {
			e=m[i];
			while(e%d[i]!=1){
				e+=m[i];
			}
			t[i]=e;
		}
		res=0;
		for(i=0;i<r.length;i++){
			res+=t[i]*r[i];
		}
		System.out.println(res%sum);
	}

}
