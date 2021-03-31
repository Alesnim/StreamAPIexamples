package ru.itcube;

import ru.itcube.DataSource.Cats;
import ru.itcube.DataSource.Generators.CatsGenerator;
import ru.itcube.DataSource.Generators.HouseGenerator;
import ru.itcube.DataSource.Generators.UserGenerator;
import ru.itcube.DataSource.House;
import ru.itcube.DataSource.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> l = List.of(2, 1, 3, 44, 31, 11, 1, 5, 8);
        // стандартный стрим коллекции


        int arr[] = {2, 1, 3, 44, 31, 11, 1, 5, 8};
        // стандартный стрим из массива

        // строки файла
        /*try {
            Files.lines(Paths.get("example.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // IntStream


        // генерация значений
        // Stream.generate(UserGenerator::getOneUser)


        List<Cats> cats = CatsGenerator.getCats(10);


        // Фильтруем котов старше 5
        List<Cats> catsOld = cats
                .stream()
                .filter(cats1 -> cats1.getOld() > 5)
                .collect(Collectors.toList());


        // System.out.println(catsOld);


        // Фильтруем всех котов которые рыжие и задать им любимую еду
        List<Cats> catsRedFood = cats
                .stream()
                .filter(cats1 -> cats1.getFurColor().equals("red"))
                .map(cats1 -> {
                    cats1.setFavoriteFood("Колбаса");
                    return cats1;
                })
                .collect(Collectors.toList());

        // System.out.println(catsRedFood);


        // Фильтруем всех котов и смотрим на них
        /*cats.stream()
                .filter(cats1 -> cats1.getOld() > 5)
                .peek(System.out::println)
                .findFirst();*/


        // Ограничимся пятью первыми котами
        List<Cats> catFive = cats
                .stream()
                .limit(5)
                .collect(Collectors.toList());

        // System.out.println(catFive.size());

        // Удалим дубли из ряда цифр
        long c = IntStream.of(1, 2, 1, 2, 1, 3, 4, 2, 1, 2, 3)
                .distinct()
                .count();

        // System.out.println(c);

        // Отсортируем котов

        List<Cats> catSorted = cats
                .stream()
                .sorted()
                .collect(Collectors.toList());

        // System.out.println(catSorted);

        // Отсортируем ряд случайных чисел
        long r = new Random().ints().limit(15).sorted().count();

        // Преобразуем и обработаем два список списков

        List<List<User>> userList = new ArrayList<>();
        userList.add(UserGenerator.getUsers(10));
        userList.add(UserGenerator.getUsers(4));

        long userListz = userList
                .stream()
                .flatMap(Collection::stream)
                .count();




        // Отберем только достаточно длинные коллекции

        long zz = userList
                .stream()
                .takeWhile(users -> users.size() > 4)
                .flatMap(Collection::stream)
                .count();

        // System.out.println(zz);


        // соберем всех котов по цветам
        HashMap<String, List<Cats>> mapCats = cats
                .stream()
                .collect(HashMap::new,
                        (map, value) -> map.merge(value.getFurColor(),
                                Collections.singletonList(value),
                                (v1, v2) -> {
                                    List<Cats> cat = new ArrayList<>(v1);
                                    cat.addAll(v2);
                                    return cat;
                                }),
                        HashMap::putAll);

        // mapCats.forEach((k, v) -> System.out.printf("K:%s \n V:%s \n", k, v));


        // тоже самое но через коллектор

        Map<String, List<Cats>> colorCats = cats
                .stream()
                .collect(Collectors.groupingBy(Cats::getFurColor));

        /*colorCats.entrySet().forEach((k) -> {
            System.out.println(k.getKey() + k.getValue());
        });*/


        // Соберем имена пользователей мужчин с возрастом больше 6

        List<User> users = UserGenerator.getUsers(25);

        users
                .stream()
                .filter(User::isSex)
                .filter((x) -> x.getOld() > 6)
                .collect(Collectors
                        .groupingBy(User::getName));
        // .forEach((key, value) -> System.out.println(key + value));


        // Посчитаем сколько людей любят какие цвета

        users
                .stream()
                .collect(Collectors
                        .groupingBy(User::getFavoriteColor,
                                Collectors.counting()));
        // .forEach((k, v) -> System.out.println(k + " " + v));


        // Сгруппируем дома по районам и улицам, потом их пронумеруем
        List<House> houses = HouseGenerator.getHouses(10);
        Map<String, Map<String, List<House>>> numberedHouses = houses
                .stream()
                .collect(Collectors.groupingBy(House::getDistrict,
                         Collectors.groupingBy(House::getStreet)
                        )
                );

        numberedHouses.forEach((key, value) -> value
                .forEach((key1, value1) -> {
                    setNumbersHouse(value1);
                }));


        /*numberedHouses.values()
                .stream()
                .flatMap(x -> x.values().stream())
                .flatMap(List::stream)
                .forEach(x -> System.out.println(x.getNumber()));*/




        // Поселим в дом кота и пользователя если у них совпадают цвета
        numberedHouses.values()
                .stream()
                .flatMap(x -> x.values().stream())
                .flatMap(Collection::stream)
                .forEach(house -> {
                    String colorHouse = house.getColor();
                    users.stream()
                            .filter(user -> user.getFavoriteColor().equals(colorHouse))
                            .forEach(house::addUser);
                    cats.stream().filter(cat -> cat.getFurColor().equals(colorHouse))
                            .forEach(house::addCat);
                });

        // Параллельные операции

        long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .parallel()
                .filter(Main::isPrime)
                .count();
        System.out.println(count);





    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    private static void setNumbersHouse(List<House> value1) {
        AtomicInteger count = new AtomicInteger(1);

        for (House h : value1) {
            h.setNumber(count.getAndIncrement());
        }
    }
}
