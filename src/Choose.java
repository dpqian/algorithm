import java.util.Arrays;

public class Choose {
	public static int[] sort(int[] arr){
		int min =arr[0];
		int temp;
		for(int i=0;i<arr.length;i++){
			min=arr[i];
			temp=i;
			for(int j=i+1;j<arr.length;j++){
				
				if(min>arr[j]){
					temp=j;
					min=arr[j];
				}
			}
			
			if(temp!=i){
				arr[temp]=arr[i];
				arr[i]=min;
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr={6,5,3,4,1,2};
		arr=sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
