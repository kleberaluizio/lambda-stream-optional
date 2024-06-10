package collect;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Fornecedor - Função acumulação - Função de Combinação. Versão mais crua
		//list.stream().collect(supplier, accumulator, combiner)
		ArrayList<Object> collect = list.stream().collect(()-> new ArrayList<>(), (l,e) -> l.add(e), (l1,l2)->l1.addAll(l2));
		//ArrayList<Object> collect1 = list.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


		//Collector -toList
		//List<Integer> toList =  list.stream().toList();
		List<Integer> toList =  list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(toList);

		//Collector -toSet
		Set<Integer> toSet =  list.stream().filter(e -> e % 2 != 0).collect(Collectors.toSet());
		System.out.println(toSet);

		//Collector -toLinkedList ou outra collection "especial"
		List<Integer> toLinkedList =  list.stream().filter(e -> e % 2 == 0).collect(Collectors.toCollection(
			LinkedList::new));
		System.out.println(toLinkedList);

		//Collector - joining - Agrupa em uma única String - Internamente usa String Builder
		String joining =  list.stream().map(Object::toString).collect(Collectors.joining(";"));
		System.out.println(joining);

		//Collector - Averaging - Versão para int, double e long
		Double media =  list.stream().collect(Collectors.averagingInt(n -> n.intValue()));
		System.out.println(media);

		//Collector - Summing - Versão para int, double e long
		Integer sum =  list.stream().collect(Collectors.summingInt(n -> n.intValue()));
		System.out.println(sum);

		//Collector - Summarizing
		System.out.println("---------------------------");
		IntSummaryStatistics summary =  list.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("summary.getAverage() " + summary.getAverage());
		System.out.println("summary.getCount() " + summary.getCount());
		System.out.println("summary.getMax() " + summary.getMax());
		System.out.println("summary.getMin() " + summary.getMin());
		System.out.println("summary.getSum() " + summary.getSum());

		//Collector - PartioningBy - sempre retorne uma chave true que atende a condição e false nao atende
		// Excelente para filtrar dados, exemplo: clientes que atendam uma condição
		System.out.println("PartioningBy");
		Map<Boolean, List<Integer>> partioning =  list.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
		System.out.println(partioning);

		//Collector - toMap - Recebe duas expressões lambdas, uma para definir como é a chave e outra como é o valor
		Map<Integer, Integer> toMap =  list.stream().collect(Collectors.toMap(n -> n, n-> n*2));
		System.out.println(toMap);


	}
}
