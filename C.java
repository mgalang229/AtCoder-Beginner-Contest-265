import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			char[][] a = new char[n][];
			for (int i = 0; i < n; i++) {
				a[i] = fs.next().toCharArray();
			}
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(visited[i], false);
			}
			int row = 0;
			int col = 0;
			boolean checker = false;
			while (true) {
				if (visited[row][col]) {
					break;
				}
				visited[row][col] = true;
				if (a[row][col] == 'U') {
					if (!withinRows(row - 1, n)) {
						checker = true;
						break;
					}
					row--;
				} else if (a[row][col] == 'D') {
					if (!withinRows(row + 1, n)) {
						checker = true;
						break;
					}
					row++;
				} else if (a[row][col] == 'R') {
					if (!withinCols(col + 1, m)) {
						checker = true;
						break;
					}
					col++;
				} else if (a[row][col] == 'L') {
					if (!withinCols(col - 1, m)) {
						checker = true;
						break;
					}
					col--;
				}
			}
			if (checker) {
				out.println((row + 1) + " " + (col + 1));
			} else {
				out.println(-1);
			}
		}
		out.close();
	}
	
	static boolean withinRows(int row, int n) {
		return 0 <= row && row < n;
	}
	
	static boolean withinCols(int col, int m) {
		return 0 <= col && col < m;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}