package stream;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,8,9,1,4,6,6,9,9);

        //FOR EACH
        printList(list);
        System.out.println(" ");
        //SKIP
        skipAndPrintList(list, 2);
    }

    private static void printList(List<Integer> list) {
        list.stream().forEach(e -> System.out.print(e + " "));
        // It is better to use just  list.forEach(e -> System.out.print(e + " ")) in this case
    }
    private static void skipAndPrintList(List<Integer> list, int n) {
        list.stream()
                .skip(n)
                .forEach(e -> System.out.print(e + " "));
    }
}
