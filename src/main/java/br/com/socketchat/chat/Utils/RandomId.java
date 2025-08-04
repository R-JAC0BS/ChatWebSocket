package br.com.socketchat.chat.Utils;

import java.util.Random;

public class RandomId {
    private static final Integer MIN_VALUE = 100000;
    private static final Integer MAX_VALUE = 999999;
    public static Long generateRandom() throws Exception{

        var i = true;
        Random randomNumberGenerator = new Random();
        Long randomLong = randomNumberGenerator.nextLong(MIN_VALUE + MAX_VALUE) + MIN_VALUE;
        return randomLong;
    };

}
