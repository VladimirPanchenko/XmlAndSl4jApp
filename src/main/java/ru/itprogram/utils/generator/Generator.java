package ru.itprogram.utils.generator;

import java.util.Random;

public abstract class Generator {
    private static final int LEFT_LIMIT = 97;
    private static final int RIGHT_LIMIT = 122;
    private static final int MAX_NUMBER = 3500;

    protected static String getRandomString(int stringLength) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = LEFT_LIMIT + (int)
                    (random.nextFloat() * (RIGHT_LIMIT - LEFT_LIMIT + 1));
            builder.append((char) randomLimitedInt);
        }
        return builder.toString();
    }

    protected static int getRandomInt() {
        return (int) ((Math.random() * MAX_NUMBER) + 1);
    }
}
