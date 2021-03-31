package ru.itcube.DataSource.Generators;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import ru.itcube.DataSource.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HouseGenerator {
    static String[] colors = {"black", "red", "gray", "white"};
    static String[] districts = {"One", "Two", "Three", "Four"};
    static String[] streets = {"Shaftesbury Avenue", "King's Road", "Abby Road", "Carnaby Street", "Oxford Street"};

    public static List<House> getHouses(int count) {

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(5, 15);
        Random r = new Random();
        parameters.randomize(FieldPredicates.named("color"),
                () -> colors[r.nextInt(colors.length)]);
        parameters.randomize(FieldPredicates.named("street"),
                () -> streets[r.nextInt(streets.length)]);
        parameters.randomize(ArrayList.class,
                ArrayList::new);
        parameters.randomize(FieldPredicates.named("district"),
                () -> districts[r.nextInt(districts.length)]);

        return new EasyRandom(parameters)
                .objects(House.class, count)
                .collect(Collectors.toList());
    }

}
