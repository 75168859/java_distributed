package reflect;

import java.util.Arrays;

public class ArrayDemo1 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		/*int[] b = new int[a.length+1];
		for(int i = 0; i < a.length;i++){
			b[i] = a[i];
		}
		a = b;*/
	  a  = Arrays.copyOf(a, 2*a.length);
	 
	}

}
