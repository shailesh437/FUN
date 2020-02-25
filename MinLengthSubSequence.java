public class MinLengthSubSequence {
public static void main(String[] args) {
	String s1 = "ABCSE AAADEKC ABXCDE";
	String s2 = "BCDE";
	int s1ptr=0;
	int s2ptr=0;
	s1ptr= s1.indexOf(s2.charAt(0));
	int minWidth=Integer.MAX_VALUE;
	int localWidth=0;
	while(s1ptr<s1.length()) {
		localWidth++;
		if(
				Character.toLowerCase(s1.charAt(s1ptr))==
				Character.toLowerCase(s2.charAt(s2ptr))
		  ) {
			s2ptr++;			
			if(s2ptr==s2.length()) {
				s2ptr=0;
				if(localWidth<minWidth)
					minWidth = localWidth;
				int nextJump = s1.substring(s1ptr).indexOf(s2.charAt(0)); 
				if(nextJump<0) break; else {
					s1ptr+=nextJump;
					s1ptr--;
				}
				localWidth=0;
			}
		}
		s1ptr++;	
	}
	if(minWidth==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minWidth);
}
}
