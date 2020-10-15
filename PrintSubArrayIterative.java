	class PrintSubArrayIterative {
	  public static void main(String args[]) {
		int a[]={7,8,6,5,4};
		for (int i = 0; i < a.length; i++) {
		  for (int j = i; j < a.length; j++) {
			for (int k = i; k <= j; k++) {
			  System.out.print(a[k] + " ");
			}
			System.out.println();
		  }
		}
	  }
	}
