package Collections;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Lists {
    public static void main(String[] args) {
        List<Integer> numList = new LinkedList<Integer>(Arrays.asList(1, 3, 2, 4, 7));
        int sum = sumNumberList(numList);
        int result = multiplyNumberList(numList);
        System.out.println("List: " + numList);
        System.out.println("Summed: " + sum);
        System.out.println("Multiplied: " + result);

        NumberFormat formatter = new DecimalFormat("#.######");
        double ratio = (double) sum / result;
        System.out.println("Ratio of Summed to Multiplied: " + formatter.format(ratio));

        System.out.println("-------------------------------------------");
        List<List<Integer>> listOfLists = generateList();
        calcRatio(listOfLists);
    }

    public static int multiplyNumberList(List<Integer> numList) {
        int result = 1;
        for (Integer num : numList)
            result *= num;
        return result;
    }

    public static int sumNumberList(List<Integer> numList) {
        int result = 0;
        for (Integer num : numList)
            result += num;
        return result;
    }

    public static List<List<Integer>> generateList() {
        int count = 5;
        Random rand = new Random();
        List<List<Integer>> listOfLists = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            List<Integer> newList = new ArrayList<>();



            for (int j = 0; j < count; j++) {
                int num = rand.nextInt(10) + 1;
                newList.add(num);
            }
            System.out.println(newList);
            if (!listOfLists.contains(newList)) {
                listOfLists.add(newList);
            }
        }
        System.out.println(listOfLists);
        return listOfLists;
    }

    public static void calcRatio(List<List<Integer>> listOfLists) {
        NumberFormat formatter = new DecimalFormat("#.###");
        List<Double> listOfratio = new ArrayList<>();
        double ratioSum = 0;
        int count = 0;
        double avgRatio;
        for (List list : listOfLists) {
            int sum = sumNumberList(list);
            int multipl = multiplyNumberList(list);
            double ratio = (double) sum / multipl;
            double formatted = Double.parseDouble(formatter.format(ratio));
            listOfratio.add(formatted);
        }
        for (Double ratio : listOfratio) {
            ratioSum += ratio;
            count++;
        }
        avgRatio = ratioSum / count;
        System.out.println(listOfratio);
        System.out.println(count);

        System.out.println(formatter.format(avgRatio));


    }
}
