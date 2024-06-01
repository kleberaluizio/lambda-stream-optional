package stream.operacoes_intermediarias;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,8,9,1,4,6,6,9,9);

        //FOR EACH
        System.out.print("FOR EACH  ");
        printList(list);
        System.out.println(" ");

        //Operações Intermediárias
        //      Essas operações retornam sempre um novo stream

        //SKIP - Pula ou ignora os primeiros n "dados" do fluxo, retorna um stream sem esses dados
        System.out.print("SKIP  ");
        skipAndPrintList(list, 2);
        System.out.println(" ");

        //LIMIT - Separa/deixa passar os n "dados"" iniciais do fluxo, retorna um stream com apenas esses dados
        System.out.print("LIMIT  ");
        limitAndPrintList(list, 5);
        System.out.println(" ");

        //DISTINCT - Não permite ao stream processar elementos repetidos, develve um stream com dados únicos, exclui suas repetições
        //Usa a comparação do equals e do hashcode
        System.out.print("DISTINCT  ");
        distinctedPrintedList(list);
        System.out.println(" ");

        //FILTER - Mantém na stream apenas dados que respeitam a condicional
        System.out.print("FILTER ");
        list.stream()
                .filter(e -> e >= 5)
                .forEach(e -> System.out.print(e + " "));
        System.out.println(" ");

        //MAP - Permite fazer uma transformação nos dados da stream, lista original não é modificada
        System.out.print("MAP ");
        list.stream()
                .map(e -> e*e)
                .forEach(e -> System.out.print(e + " "));

        list.stream()
                .limit(3)
                .map(e -> e*e)
                .skip(2)
                .distinct()
                .forEach(e -> System.out.print(e + " "));

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

    private static void limitAndPrintList(List<Integer> list, int n) {
        list.stream()
                .limit(n)
                .forEach(e -> System.out.print(e + " "));
    }

    private static void distinctedPrintedList(List<Integer> list) {
        list.stream()
                .distinct()
                .forEach(e -> System.out.print(e + " "));
    }
}
