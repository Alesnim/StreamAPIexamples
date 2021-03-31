package ru.itcube.DataSource.Generators;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import ru.itcube.DataSource.Cats;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CatsGenerator {

    static String[] colors = {"black", "red", "gray", "white"};

    public static List<Cats> getCats(int count) {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(5, 10);
        parameters.randomize(Integer.class, () -> {
            Random r = new Random();
            return r.nextInt(20);
        });
        parameters.randomize(FieldPredicates.named("furColor"), () -> {
            Random r = new Random();
            int rr = r.nextInt(colors.length);
            return colors[rr];
        });

        EasyRandom generator = new EasyRandom(parameters);


        return generator.objects(Cats.class, count).collect(Collectors.toList());

    }


}
