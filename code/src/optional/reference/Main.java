package optional.reference;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.print("GET ");
        String s = "12";
        Optional<Integer> number = convertToOptionalNumber(s);
        System.out.print(number.get());
        System.out.println(" ");

        System.out.print("ifPresent() ");
        String s1 = "a";
        Optional<Integer> number1 = convertToOptionalNumber(s1);
        number1.ifPresent(a -> System.out.println(a));
        System.out.println(" ");

        System.out.print("ifPresent() ");
        String s2 = "120";
        convertToOptionalNumber(s2).ifPresent(System.out::print);
        System.out.println(" ");

        System.out.print("orElse() ");
        String s3 = "a";
        Integer number2 = convertToOptionalNumber(s3).orElse(3);
        System.out.print(number2);
        System.out.println(" ");

        System.out.print("orElseGet() ");
        String s4 = "a";
        Integer number4 = convertToOptionalNumber(s4)
                .orElseGet(() -> {
                    //Permite criar um função lambda mais complexa
                    int number12 = 12;
                    return lazyOperation(number12);
                });
        System.out.print(number4);
        System.out.println(" ");

        System.out.print("orElseThrow() ");
        String s6 = "134";
        Integer number6 = convertToOptionalNumber(s6)
                .orElseThrow(() -> new NumberFormatException("Value is not a number"));
        System.out.print(number6);
        System.out.println(" ");

        System.out.print("orElseThrow() ");
        String s8 = "25";
        Integer number8 = convertToOptionalNumber(s8)
                .orElseThrow(NumberFormatException::new);
        System.out.print(number8);
        System.out.println(" ");

    }
    public static Integer convertToNumber(String number) {
        return Integer.valueOf(number);
    }

    public static Integer lazyOperation(int number) {
        return number*2;
    }

    public static Optional<Integer> convertToOptionalNumber(String s) {
        try{
            Integer number = Integer.valueOf(s);
            return Optional.of(number);
        }catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
