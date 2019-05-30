package bigO.orange01.finalExam;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcab";
		System.out.println(KMP2(a));
	}
	private static int KMP2( String p) {
		int m = p.length();
		int[] border = new int[p.length()+1];
		border[0] = -1;
		for (int i = 0; i < m; ++i) {
		    border[i+1] = border[i];
		    while (border[i+1] > -1 &&
		    		//if (p.charAt(i) == p.charAt(j)) {
		    		
		    		p.charAt(border[i+1]) != p.charAt(i) ){
		      border[i+1] = border[border[i+1]];
		    }
		    border[i+1]++;
		  }

		  return border[border.length-1];
	}

}
