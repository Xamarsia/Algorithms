import java.util.Arrays;
import java.util.Hashtable;

public class Main {
    static public void sortOddNumbersInArray(int[] array) {
        int[] sortedOddNumbers = Arrays.stream(array)
                .filter(s -> s % 2 == 1)
                .sorted().toArray();

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i] = sortedOddNumbers[j];
                j++;
            }
        }
    }

    static public Double findUnique(double[] array) {
        int minimumHashtableSize = array.length / 2;
        Hashtable<Double, Boolean> hashtable = new Hashtable<Double, Boolean>(minimumHashtableSize);
        for (double num : array) {
            if (!hashtable.containsKey(num)) {
                hashtable.put(num, true);
            } else {
                hashtable.replace(num, false);
            }
        }

        Double uniqueDouble = hashtable.entrySet()
                .stream().filter(x -> x.getValue())
                .findFirst().get().getKey();

        return uniqueDouble;
    }

    public static void main(String[] args) {
        double[] array = {0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 6.0, 6.0, 8.0, 8.0};
        System.out.println("The unique number is: " + findUnique(array));


        int[] array2 = {5, 3, 2, 8, 1, 4};
        sortOddNumbersInArray(array2);

        System.out.print("Array of sorted odd numbers: ");
        Arrays.stream(array2).forEach(n -> System.out.print(n + " "));

    }
}