import java.util.Scanner;

//regular N-polygon Triangle
public class R001C {
	static final double EPS=1E-4;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		double x1=in.nextDouble();
		double y1=in.nextDouble();
		double x2=in.nextDouble();
		double y2=in.nextDouble();
		double x3=in.nextDouble();
		double y3=in.nextDouble();
		
		double a=distance(x1,y1,x2,y2);
		double b=distance(x1,y1,x3,y3);
		double c=distance(x2,y2,x3,y3);
		
		double r=a*b*c/Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));
		double n=Math.PI/gcd(gcd(angle(a,b,c),angle(a,c,b)),angle(b,c,a));
		double area=n/2*r*r*Math.sin(2*Math.PI/n);
		System.out.println(String.format("%.6f", area));
		in.close();
	}
	static double gcd(double x,double y){
		while(Math.abs(x)>EPS&&Math.abs(y)>EPS){
			if(x>y)
				x-=Math.floor(x/y)*y;
			else
				y-=Math.floor(y/x)*x;
		}
		return x+y;
	}
	static double angle(double a,double b,double c){
		return Math.acos((a*a+b*b-c*c)/(2*a*b));
	}
	static double distance(double x1,double y1,double x2,double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
