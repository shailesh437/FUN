
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Max sub-string length with same letters if max 'K' characters can be replaced*/
public class SlidingWindowApplication {

	public static int calculateMaxLengthSubStringByReplacingOneChar(String s, int k) {
		int max_length = 0;
		int startWindow = 0;
		int endWindow = 0;
		int maxFreq = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (; endWindow < s.length(); endWindow++) {
			char x = s.charAt(endWindow);
			map.put(x, map.getOrDefault(x, 0) + 1);
			maxFreq = Math.max(maxFreq, map.get(x));
			if (endWindow - startWindow + 1 - maxFreq > k) {
				char startChar = s.charAt(startWindow);
				map.put(startChar, map.getOrDefault(startChar, 0) - 1);
				startWindow++;
			}
			max_length = Math.max(max_length, endWindow - startWindow + 1);
		}
		return max_length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String s = sc.next();
		if (k >= s.length()) {
			System.out.println(s.length());
			return;
		}
		System.out.println(calculateMaxLengthSubStringByReplacingOneChar(s, k));
	}
}
