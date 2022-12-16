import java.util.Hashtable;

public class Main {
    static public Double findUnique(double[] array) {
        int minimumHashtableSize = array.length / 2;
        Hashtable<Double, Boolean> hashtable =
                new Hashtable<Double, Boolean>(minimumHashtableSize);
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
    }
}