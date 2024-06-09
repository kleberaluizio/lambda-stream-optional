package reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Main
{
	public static void main(String[] args)
	{

		//REDUCE
		// Transforma todos os elementos de um stream em uma coisa só.

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		//FUNÇÃO DE ACUMULAÇÃO
		//Optional<Integer> reduce2 = list.stream().reduce(;
		Optional<Integer> soma = list.stream().reduce(Integer::sum);

		soma.ifPresent(System.out::println);

		//FUNÇÃO DE MULTIPLICAÇÃO

		Optional<Integer> multiplicacao = list.stream().reduce((n1,n2)-> n1 * n2);

		multiplicacao.ifPresent(System.out::println);

		//CONCATENAÇÃO
		String s = "Estou revendo os conceitos de reduce";
		String[] arrayStr = s.split(" ");
		List<String> listStr = Arrays.asList(arrayStr);

		//Optional<String> concatenacao = listStr.stream().reduce((s1, s2) -> s1.concat(s2));
		Optional<String> concatenacao = listStr.stream().reduce(String::concat);
		concatenacao.ifPresent(System.out::println);

		System.out.println("--------------- VALOR DE IDENTIDADE ---------------");
		// Ao passar o valor identidade como n1 e qualquer outro valor como n2, o resultado da operação é
		// sempre n2
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		//reduce - SOMA
		Integer sum = list1.stream().reduce(0,(n1,n2)-> n1 + n2);
		System.out.println(sum);

		//reduce - MULTIPLICACAO
		Integer produto = list1.stream().reduce(1,(n1,n2)-> n1 * n2);
		System.out.println(produto);

		//reduce - CONCATENACAO
		String s2 = "Estou revendo os conceitos de reduce";
		String[] arrayStr2 = s.split(" ");
		List<String> listStr2 = Arrays.asList(arrayStr2);
		String string = listStr2.stream().reduce("",(n1,n2)-> n1.concat(n2));
		System.out.println(string);

		//reduce - Menor valor
		double doubleReduce = DoubleStream.of(1.5, 2.9, 6.7)
			.reduce(Double.POSITIVE_INFINITY,Math::min);
		System.out.println(doubleReduce);


	}
}
