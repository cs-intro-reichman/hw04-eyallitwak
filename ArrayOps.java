public class ArrayOps {
    public static void main(String[] args) {
        //int[] array = new int[] { 4, 1, 31, 33, 112 };
        int[] array2 = new int[] { 33333, 4444, 111, 11, 2 };

        System.out.println(isSorted(array2));
    }

    /*
     * gets an array of n length which contains all but 1 integers 0<=x<=n
     * returns that missing integer
     */
    public static int findMissingInt(int[] array) {
        int missingInteger = -1;

        for (int i = 0; i <= array.length; i++) {
            boolean alreadyFound = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    alreadyFound = true;
                }
            }
            if (!alreadyFound) {
                missingInteger = i;
            }
        }

        return missingInteger;
    }

    /* gets array of integers, returns 2nd highest value in array */
    public static int secondMaxValue(int[] array) {
        int max = array[0], secondMax = array[1];

        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                secondMax = max;
                max = array[i];
            } else {
                if (array[i] >= secondMax) {
                    secondMax = array[i];
                }
            }
        }
        return secondMax;
    }

    /*
     * gets 2 arrays of integers, returns whether they contain exactly the same
     * values (with no regard for location or repetitions)
     */
    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        if (array1.length < array2.length) {
            return containsTheSameElements(array2, array1);
        }

        for (int i = 0; i < array1.length; i++) {
            boolean isInArray2 = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    isInArray2 = true;
                }
            }
            if (!isInArray2)
                return false;
        }
        return true;
    }

    /*
     * gets array of integers, returns true if it's sorted (either ascending or
     * descending)
     */
    public static boolean isSorted(int[] array) {
        return isAscending(array) || isDescending(array);
    }

    /* returns true if given array of integers is ascending */
    public static boolean isAscending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /* returns true if given array of integers is descending */
    public static boolean isDescending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
