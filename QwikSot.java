public class  QwikSot{
	
	public static int divide_(int[] x,int low,int high) {
		int pvt=x[high];
		int temp;
		int k=low-1;
		for(int l=low;l<=high-1;l++) {
			if(x[l]<pvt) {
				k++;
				temp = x[l];
				x[l]=x[k];
				x[k]=temp;
			}
		}
		temp=x[k+1];
		x[k+1]=x[j];
		x[j]  = temp;
		return k+1;		
	}
     public static void q_s(int[] x,int i,int j) {
    	 if(j>i) {
    	 int p = divide_(x,i,j);
    	 q_s(x,i,p-1);
    	 q_s(x,p+1,j);
    	 }
     }
     private static void display(int a[]) {
    		for(int i=0;i<a.length;i++)
    			System.out.println(a[i]);
     }
	public static void main(String[] args) {
	int a[]= {9,8,7,34,1,3,100,109,87,4,-4,909,1234,8786,0};
	q_s(a,0,a.length-1);
	display(a);
}
}
