package optional.primitive;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.print("Int ");
        Stream.of(1,2,3)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.print("Int ");
        int numero = convertToOptionalNumber("a").orElse(2);
        System.out.println(numero);
    }

    public static OptionalInt convertToOptionalNumber(String s) {
        try{
            int number = Integer.parseInt(s);
            return OptionalInt.of(number);
        }catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }
}
