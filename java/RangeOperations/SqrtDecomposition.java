class SqrtDecomposition {

    private int[] arr, blockArray;
    private int BLOCK_SIZE;

    public SqrtDecomposition(int[] arr) {
        this.arr = arr;
        this.BLOCK_SIZE = (int) Math.ceil(Math.sqrt(arr.length));
        this.blockArray = new int[BLOCK_SIZE];
        for(int i = 0; i < arr.length; i++) {
            blockArray[(int) (i / BLOCK_SIZE)] += arr[i];
        }
    }

    public void update(int index, int newValue) {
        int oldValue = this.arr[index];
        arr[index] = newValue;
        blockArray[(int) (index / blockArray.length)] += newValue - oldValue;
    }

    public int query(int left, int right) {
        int sum = 0;
        int startBlock = (int) (left / BLOCK_SIZE);
        int endBlock = (int) (right / BLOCK_SIZE);
        for(int i = left; i <= (startBlock + 1) * BLOCK_SIZE - 1; i++) {
            sum += arr[i];
        }
        for(int j = endBlock * BLOCK_SIZE; j <= right; j++) {
            sum += arr[j];
        }
        for(int k = startBlock + 1; k <= endBlock - 1; k++) {
            sum += blockArray[k];
        }
        return sum;
    }

    public void printArr() {
        for(int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}