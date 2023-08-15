package array;
public class Sort {
    public static void main(String[] args) {
        
    //task 3
    // Buatkan java program untuk sorting angka dari suatu array
    // Input array[] = {3,2,4,1,5}
    // Output array[] = {1,2,3,4,5}

    int[] array = {4,2,3,6,5,10,8,9,1};

    
    sort(array);
    
    for (int i : array){
        System.out.println(i);
    }
}

    private static void sort(int[] array) {

    for (int i = 0; i < array.length - 1; i++){
        for (int p = 0; p < array.length -i -1; p++){
            if (array[p] > array [p+1]){
                int space = array[p];
                array[p] = array[p+1];
                array[p+1] = space;
            }
        }
    }

    }


    
    }

