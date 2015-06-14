package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DFS3 {
	static int N,M,Q;
	static boolean[][] g1,g2;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int t,T;
		T=in.nextInt();
		for(t=0;t<T;t++){
			int i,type,x1,x2,y1,y2;
			N=in.nextInt();
			M=in.nextInt();
			Q=in.nextInt();
			g1=new boolean[N+2][M+2];
			g2=new boolean[N+2][M+2];
			int ans=0;
			for(i=0;i<Q;i++){
				type=in.nextInt();
				if(type==1){
					x1=in.nextInt();
					y1=in.nextInt();
					x2=x1;
					y2=y1+1;
					g1[x1][y1]=true;
					
				}else if(type==2){
					x1=in.nextInt();
					y1=in.nextInt();
					x2=x1+1;
					y2=y1;
					g2[x1][y1]=true;
					
				}else if(type==3){
					x1=in.nextInt();
					y1=in.nextInt();
					x2=in.nextInt();
					y2=in.nextInt();
					if(x1>x2||y1>y2){
						int x=x1;
						x1=x2;
						x2=x;
						int y=y1;
						y1=y2;
						y2=y;
					}
					if(x1==x2&&y1==y2){
						ans++;
					}else{
						boolean[][] visited=new boolean[N+1][M+1];
						if(dfs(x1,y1,x2,y2,visited)==1)
							ans++;
					}
				}else if(type==4){
					int max=0,ret;
					boolean f=false;
					boolean[][] visited=new boolean[N+1][M+1];
					for(x1=1;x1<=N&&!f;x1++){
						for(y1=1;y1<=M&&!f;y1++){
							if(!visited[x1][y1]){
								ret=dfs(x1,y1,0,0,visited);
								max=Math.max(max,ret);
								if(max>=N*M/2){
									f=true;
									break;
								}
							}
						}
					}
					ans+=max;
				}
			}
			out.println(ans);
		}
		out.flush();
	}
	static int dfs(int x1,int y1,int x2,int y2,boolean[][] visited){
		PosType e;
		PosType[] stack=new PosType[N*M+1];
		int top=-1;
		int ret=0;
		PosType curpos=new PosType(x1,y1,0);
		do{
			if(valid(curpos,visited)){
				if(!visited[curpos.x][curpos.y]){
					visited[curpos.x][curpos.y]=true;
					ret++;
				}
				e=new PosType(curpos.x,curpos.y,0);
				stack[++top]=e;
				if(curpos.x==x2&&curpos.y==y2)
					return 1;
				curpos=nextPos(curpos,0);
			}else{
				if(top>-1){
					e=stack[top--];
					while(e.di==3&&top>-1){
						e=stack[top--];
					}
					if(e.di<3){
						e.di++;
						stack[++top]=e;
						curpos=nextPos(e,e.di);
					}
				}
			}
		}while(top>-1);
		
		if(x2==0&&y2==0)
			return ret;
		return 0;
	}
	static boolean valid(PosType pos,boolean[][] visited){
		if(pos==null)
			return false;
		if(pos.x>=1&&pos.x<=N&&pos.y>=1&&pos.y<=M&&!visited[pos.x][pos.y])
			return true;
		else
			return false;
	}
	static PosType nextPos(PosType cur,int di){
		if(di==0){//right
			if(!g1[cur.x][cur.y]){
				return new PosType(cur.x,cur.y+1,di);
			}
		}else if(di==1){//down
			if(!g2[cur.x][cur.y]){
				return new PosType(cur.x+1,cur.y,di);
			}
		}else if(di==2){//left
			if(!g1[cur.x][cur.y-1]){
				return new PosType(cur.x,cur.y-1,di);
			}
		}else if(di==3){//up
			if(!g2[cur.x-1][cur.y]){
				return new PosType(cur.x-1,cur.y,di);
			}
		}
		return null;
	}
	static class PosType{
		int x,y,di;
		PosType(int x,int y,int di){
			this.x=x;
			this.y=y;
			this.di=di;
		}
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br=new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st==null||!st.hasMoreElements())
				try{st=new StringTokenizer(br.readLine());}catch(Exception e){}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
