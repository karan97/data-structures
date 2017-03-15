/*
	Program to create, update and find sum in a Fenwick Tree
*/
	
class FenwickTree {
	
	public int[] createFenwick(int[] inputArray) {
		int[] fenwickArray = new int[inputArray.length +1];
		for(int i = 1; i<=inputArray.length;i++) {
			updateFenwick(fenwickArray, inputArray[i-1], i);
		}
		return fenwickArray;
	}

	public void updateFenwick(int[] fenwickArray, int value, int index)	{
		while(index < fenwickArray.length) {
			fenwickArray[index] += value;
			index = index + (index & - index);
		}
	}

	public int getSum(int[] fenwickArray, int index){
		int sum = 0;
		while(index > 0) {
			sum  += fenwickArray[index];
			index = index - (index & - index);			
		}
		return sum;
	}

	public int[] updateInputArray(int[] inputArray , int value, int index) {
		inputArray[index] = value;
		return createFenwick(inputArray);
	}
	
	public static void main(String args[]) {

		int[] inputArray = {3,1,-1,6,5,4,-3,3,7,2,3};
		FenwickTree ft = new FenwickTree();
		int[] fenwickArray = ft.createFenwick(inputArray);
		
		for (int a : inputArray) {
			System.out.print(a+" ");
		}
		System.out.println();
		for (int a : fenwickArray) {
			System.out.print(a+" ");
		}
		
		// Find sum upto  <= element
		// System.out.println(ft.getSum(fenwickArray, 11));
	
		System.out.println("\n");


		// Updating array elements
		// Syntax - updateInputArray(int[] inputArray , int value, int index)
		fenwickArray = ft.updateInputArray(inputArray, 1, 2);
		for (int a : inputArray) {
			System.out.print(a+" ");
		}
		System.out.println();
		for (int a : fenwickArray) {
			System.out.print(a+" ");
		}
	}
}