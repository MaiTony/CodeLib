
public class CrossWord {

	public int countWords(String[] board, int size) {
		int n=board.length;
		int m=board[0].length();
		int ans=0;
		for(int i=0;i<n;i++){
			int cnt=0;
			for(int j=0;j<m;j++){
				if(board[i].charAt(j)=='.'){
					cnt++;
				}else{
					if(cnt==size)
						ans++;
					cnt=0;
				}
			}
			if(board[i].charAt(m-1)=='.'){
				if(cnt==size)
					ans++;
			}
		}
		return ans;
	}

}
