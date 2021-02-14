import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class CS1 {

    // You may change this function parameters
    static int findMaxProfit(int n, int[] arr) {
        if(n<2){
            return 0;
        }
        int maxDiff = arr[1] - arr[0]; 
        int minElement = arr[0]; 
        int i; 
        for (i = 1; i < n; i++)  
        { 
            if (arr[i] - minElement > maxDiff) 
                maxDiff = arr[i] - minElement; 
            if (arr[i] < minElement) 
                minElement = arr[i]; 
        } 
        return maxDiff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] firstLine = scanner.nextLine().split(" ");
        int[] firstLineArr = Stream.of(firstLine).mapToInt(Integer::parseInt).toArray();
        int numOfPredictedDays = firstLineArr[0];
        int[] predictedSharePrices = Arrays.copyOfRange(firstLineArr, 1, firstLineArr.length);
        scanner.close();

        int result = findMaxProfit(numOfPredictedDays, predictedSharePrices);

        // Do not remove this line
        System.out.println(result);
        // Do not print anything after this line
    }
}