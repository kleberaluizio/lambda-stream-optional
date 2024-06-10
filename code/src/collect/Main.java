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
	}
}
