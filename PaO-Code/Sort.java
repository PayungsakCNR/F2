public class Sort {
	public static void main(String args[]){
		int [] a = {59,10,20,31,22,54,23,22,18,40,39};
		int i,j,temp;

		for(i=1; i<a.length; i++){
			for(j=1; j>0; j--){
				if(a[j] < a[j-1]){
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		for(i=0; i<a.length; i++){
			System.out.print(a[i] + ",");
		}
		System.out.print("\n");
	}
}