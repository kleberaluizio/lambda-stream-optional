package stream.operacoes_finais;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Uma operação final encerra o fluxo de dados, não é possível realizar mais operações sobre ele
        List<Integer> list = Arrays.asList(1,5,8,9,1,4,6,6,9,9);

        //COUNT - Retorna long com a quantidade de elementos presentes no fluxo
        System.out.print("COUNT ");
        long count = list.stream()
                .filter(e -> e == 9)
                .count();
        System.out.print(count + " ");
        System.out.println(" ");

        //MIN - Retorna o menor dado com base no comparator recebido
        System.out.print("MIN ");
        Optional<Integer> min = list.stream()
                .skip(2)
                .min(Comparator.naturalOrder()); //.naturalOrder() -> usa comparador implementado na classe
        System.out.print(min.get() + " ");
        System.out.println(" ");

        //MAX - Retorna o maior dado com base no comparator recebido
        System.out.print("MAX ");
        Optional<Integer> max = list.stream()
                .filter(e -> e % 2 == 0)
                .max(Comparator.naturalOrder()); //.naturalOrder() -> usa comparador implementado na classe
        System.out.print(max.get() + " ");
        System.out.println(" ");

        //COLLECT
        System.out.print("COLLECT ");
        List<Integer> novaLista = list.stream()
                .map(e -> e*e)
                .collect(Collectors.toList());
        printList(novaLista);
        System.out.println(" ");

        System.out.print("COLLECT ");
        Map<Boolean, List<Integer>> map = list.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0));
        System.out.print(map);
        System.out.println(" ");

        System.out.print("COLLECT ");
        Map<Integer, List<Integer>> mapa = list.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.print(mapa);
        System.out.println(" ");

    }

    private static void printList(List<?> list) {
        list.forEach(e -> System.out.print(e + " "));
    }
}
