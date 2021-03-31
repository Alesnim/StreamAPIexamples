package ru.itcube.DataSource.Generators;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.randomizers.text.StringRandomizer;
import ru.itcube.DataSource.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UserGenerator {
    static String[] colors = {"black", "red", "gray", "white"};

    public static List<User> getUsers(int count) {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(5, 20);
        Random r = new Random();
        parameters.randomize(Integer.class, () -> r.nextInt(60));
        parameters.randomize(FieldPredicates.named("favoriteColor"),
                () -> colors[r.nextInt(colors.length)]);

        parameters.randomize(FieldPredicates.named("fullname"),
                () -> {
                    StringRandomizer s = new StringRandomizer();
                    return s.getRandomValue() + " " + s.getRandomValue();
                });


        EasyRandom generator = new EasyRandom(parameters);
        return generator.objects(User.class, count)
                .collect(Collectors.toList());


    }

    public static User getOneUser() {


        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(5, 20);
        Random r = new Random();
        parameters.randomize(Integer.class, () -> r.nextInt(60));
        parameters.randomize(FieldPredicates.named("favoriteColor"),
                () -> colors[r.nextInt(colors.length)]);
        parameters.randomize(FieldPredicates.named("old"),
                () -> r.nextInt(80));
        parameters.randomize(FieldPredicates.named("fullname"),
                () -> {
                    StringRandomizer s = new StringRandomizer();
                    return s.getRandomValue() + " " + s.getRandomValue();
                });
        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(User.class);
    }
}
