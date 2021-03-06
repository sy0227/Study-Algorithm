import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018 {

	static int N,M;
	static char[][] board;
	static char[][] cmp1;
	static int answer;
	
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		cmp1 = new char[8][8];
		int flag=1;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(flag==1) {
					cmp1[i][j]='B';
				}
				else {
					cmp1[i][j]='W';
				}
				flag*=-1;
			}
			flag*=-1;
		}
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		String tmp;
		board = new char[N][M];
		answer = N*M+1;
		for(int i=0;i<N;i++) {
			tmp=br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		int limity = N-8;
		int limitx = M-8;
		
		for(int i=0;i<=limity;i++) {
			for(int j=0;j<=limitx;j++) {
				painting(i,j);
			}
		}
		
		System.out.println(answer);
		
		
	}
	private static void painting(int sy, int sx) {

		int count1=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i+sy][j+sx]!=cmp1[i][j]) {
					count1++;
				}				
			}
		}
		int count = Math.min(count1, 64-count1);
		answer = Math.min(count, answer);
	}

}
