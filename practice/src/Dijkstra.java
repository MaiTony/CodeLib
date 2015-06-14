
public class Dijkstra {

	public void dijkstra(int n) {

		int path[][] = new int[n+1][n+1];
		for(int i = 1;i < n+1; i ++) {
			for(int j = 1; j < n + 1;j ++)
				path[i][j] = Integer.MAX_VALUE;
		}
		
		int minLen[] = new int[n+1];
		int visit[] = new int[n+1];
		for(int i = 1; i < n + 1; i ++) {
			minLen[i] = path[1][i];
		}

		minLen[1] = 0;
		visit[1] = 1;
		int minj = 1;
		for(int i = 1; i < n + 1; i ++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j < n + 1; j ++) {
				if(visit[j] == 0 && minLen[j] < min) {
					min = minLen[j];
					minj = j;
				}
			}
			visit[minj] = 1;
			for(int j = 1; j < n + 1; j ++) {
				if(visit[j] == 0 && minLen[minj] != Integer.MAX_VALUE && path[minj][j] != Integer.MAX_VALUE && 
					minLen[j] > (minLen[minj] + path[minj][j])) {
					minLen[j] = minLen[minj] + path[minj][j];
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
