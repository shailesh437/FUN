
public class FindPowerUsingRecursion {
	static int pow_met1(int b,int i) {
		return i==0?1:b*pow_met1(b,i-1);
	}
	static int pow_met2(int b,int i) {
		if (i==0)
			return 1;
		int x = pow_met2(b,i/2);
		x     = x*x;
		if((i & 1) ==1) return b*x;
		else
			return x;
	}
public static void main(String[] args) {
	System.out.println(pow_met1(3,5));
	System.out.println(pow_met2(3,5));
}

}
