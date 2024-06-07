package reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main
{
	public static void main(String[] args)
	{

		//REDUCE
		// Transforma todos os elementos de um stream em uma coisa só.

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		//FUNÇÃO DE ACUMULAÇÃO
		//Optional<Integer> reduce2 = list.stream().reduce((n1,n2)-> n1 + n2);
		Optional<Integer> reduce = list.stream().reduce(Integer::sum);

		reduce.ifPresent(System.out::println);

		//FUNÇÃO DE MULTIPLICAÇÃO
		
	}
}
