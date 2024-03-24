
public class Searches {
    public static int LinearSearch(int[] array, int value){
        for(int i = 0; i < array.length; ++i){
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public static int BinarySearch(int[] array, int value){

        int low = 0;
        int high = array.length -1;
        while ((high - low) > 1){
            int mid = (high + low) / 2;
            if (array[mid] < value)
                low = mid + 1;
            else high = mid;

        }
        if (array[low] == value)
            return low;
        else if (array[high] == value)
            return high;

        return -1;
    }

}
