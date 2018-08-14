package com.array;
//test
public class DoubleArray {
	public boolean Find(int target, int [][] array) {
		int i = array.length-1;
		int j = 0;
		while(i>=0&&j<array[0].length){
			if(target>array[i][j])
				j++;
			else if(target<array[i][j])
				i--;
			else
				return true;
		}
		return false;
    }
	public static void test(){
		
	}
	
	
	public static void main(String[] args){
		String str = "qwertyuiop";
		StringBuffer stringBuffer = new StringBuffer(str);
		StringBuffer reverse = stringBuffer.reverse();
		String result = reverse.toString();
		System.out.println(result);
	}
}
