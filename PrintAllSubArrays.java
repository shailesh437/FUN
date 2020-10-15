import java.util.Arrays;
import java.util.List;

public class PrintAllSubArrays {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		printAllSubArrays(list, 0);
	}

	static void printAllSubArrays(List<Integer> list, int start) {
		if (start == list.size())
			return;
		for (int i = start + 1; i <= list.size(); i++) {
			System.out.println(list.subList(start, i));
		}
		printAllSubArrays(list, start + 1);
	}
}
