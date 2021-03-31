package ru.itcube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FunctionalExample {

    @FunctionalInterface
    interface Function<F, T> {
        T apply(F from);
    }

    public static void main(String[] args) {
        // создаем новую функцию
        Function<Integer, String> a = (integer) -> integer.toString();

        Function<Integer, Integer> a2 = (integer) -> integer + 1;


        List<Integer> integerList = new ArrayList<>();
        integerList.add(42);
        integerList.add(24);
        integerList.add(2);


        // применяем функцию
        // System.out.println(a.apply(42));


        // применяем функцию на весь список
        // System.out.println(map(integerList, a2));

        // применим функцию для получения одного результата
        System.out.println(reduce(integerList, a2));

        // ссылка на метод
        Function<Integer, String> b = FunctionalExample::intToString;


    }


    public static <F, T> List<T> map(Collection<F> from, Function<? super F, ? extends T> transformer) {
        ArrayList<T> result = new ArrayList<T>();
        for (F element : from)
            result.add(transformer.apply(element));
        return result;
    }


    public static <F, T> String reduce(Collection<F> from, Function<? super F, ? extends T> reducer) {
        String result = "";
        for (F el : from) {
            result += reducer.apply(el);
        }

        return result;

    }


    public static String intToString(Integer i) {
        return String.valueOf(i);
    }
}


