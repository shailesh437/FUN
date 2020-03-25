package com.sp.Programming;

import java.util.Scanner;

public class MinimumStringWindow{
	public static String calculateMinLength(
			String s1,String s2) {
		int minLength=10001;
		int[] s1_hash=new int[256];
		int[] s2_hash=new int[256];
		for(int i=0;i<s2.length();i++)
			s2_hash[s2.charAt(i)]++;
		int count=0;
		int s2len = s2.length();
		int start_index=-1;
		int start=0;
		for(int i=0;i<s1.length();i++) {
			s1_hash[s1.charAt(i)]++;
			
			if( s1_hash[s1.charAt(i)] <= s2_hash[s1.charAt(i)] 
				&& s2_hash[s1.charAt(i)]!=0
				)
				count++;
			if(count==s2len) {
				while(
						s1_hash[s1.charAt(start)]>s2_hash[s1.charAt(start)]
						||
						s2_hash[s1.charAt(start)]==0
						) {
						if(s1_hash[s1.charAt(start)]>s2_hash[s1.charAt(start)])
							s1_hash[s1.charAt(start)]--;
						start++;
				}				
				if(minLength>(i-start+1)) {
					minLength = i-start+1;
					start_index=start;
				}
			}
		}
		if(start_index==-1)
			return "No string";
		return s1.substring(start_index, start_index+minLength);
	}
	public static void main(String[] args) {
		Scanner inpTaker = new Scanner(System.in);
		String s1 = inpTaker.nextLine();
		String s2 = inpTaker.nextLine();
		System.out.println(calculateMinLength(s1,s2));
	}
}
