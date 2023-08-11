

public class Array {
    public static void main(String[] args) throws Exception {

        // Buatkan java program untuk menampilkan angka array yang sama
        // Input: array1[]= [2,3,4,5] dan array2[] = [1,3,5,7]
        // Output [3,5].

        int[] array1 = {2, 3, 4, 5, 8, 10, 28};
        int[] array2 = {3, 1, 7, 28, 5, 2, 10};

        int i = 0;
        int ii = 0;

        while (i < array1.length ) {
            if (array1[i] == array2[ii]) {
                System.out.println(array1[i]);
                i++;
                ii = 0; // Reset index array2
            } else if (ii == array2.length-1) {
                i++;
                ii = 0;
            } else {
                ii++;
            }
        }
    }
}
