public class Arrays_Review {
    
    public double getAverage(int arr[]){
        int lens = arr.length;
        double sum  = 0;
        for (int num : arr)
            sum += num;

        return sum / lens;
    }

    public void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++)
        {
            int j = i;
            int target = arr[j];
            while(j >= 1 && target > arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }

    public int secLargestElem(int arr[]){
        // sort array in ascending by insertion sort
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException("Array must have at least 2 elements.");
        insertionSort(arr);
        return arr[1];
    }

    public static void main(String args[]){
        Arrays_Review arr = new Arrays_Review();
        int num_arr[] = {17, 42, 9, 99, 25};
        System.out.println(arr.getAverage(num_arr));

        try {
            System.out.println(arr.secLargestElem(num_arr)); //42
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
