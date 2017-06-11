package org.gohome.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by sunpeng on 2017/6/6.
 */
public class NumberUtil {

    public static double calculate(String mode) {
        double result = 0.0;
        List<Double> numbers = new ArrayList<>();
        List<Character> calcs = new ArrayList<>();
        int index = 0;
        if (getCacluIndex(mode) == Integer.MAX_VALUE) {
            return Double.valueOf(mode);
        }
        while (mode.length() > 0) {
            index = getCacluIndex(mode);

            if (index != Integer.MAX_VALUE) {

                numbers.add(Double.valueOf(mode.substring(0, index)));
//                if (index == mode.length() - 1) {
//                    continue;
//                }
                calcs.add(mode.charAt(index));
                mode = mode.substring(index + 1, mode.length());
            } else {
                numbers.add(Double.valueOf(mode));
                mode = "";
            }
        }
        double temp;
        boolean flag = true;
        while (calcs.size() != 0 && flag) {
            for (int i = 0; i < calcs.size(); i++) {
                if (calcs.get(i) == '*') {
                    temp = numbers.get(i) * numbers.get(i + 1);
                    numbers.set(i, temp);
                    numbers.remove(i + 1);
                    calcs.remove(i);
                    continue;

                }
                if (calcs.get(i) == '/') {
                    temp = numbers.get(i) / numbers.get(i + 1);
                    numbers.set(i, temp);
                    numbers.remove(i + 1);
                    calcs.remove(i);
                    continue;
                }
                flag = false;
            }
        }
        int i=0;
        while (calcs.size() != 0) {
                if (calcs.get(i) == '+') {
                    temp = numbers.get(i) + numbers.get(i + 1);
                    numbers.set(i, temp);
                    numbers.remove(i + 1);
                    calcs.remove(i);
                }
                if (calcs.get(i) == '-') {
                    temp = numbers.get(i) - numbers.get(i + 1);
                    numbers.set(i, temp);
                    numbers.remove(i + 1);
                    calcs.remove(i);
                }
        }
        result = numbers.get(0);
        return result;
    }

    private static int getCacluIndex(String model) {
        int index = Integer.MAX_VALUE;
        if (index > model.indexOf("+") && model.indexOf("+") != -1) {
            index = model.indexOf("+");
        }
        if (index > model.indexOf("-") && model.indexOf("-") != -1) {
            index = model.indexOf("-");
        }
        if (index > model.indexOf("*") && model.indexOf("*") != -1) {
            index = model.indexOf("*");
        }
        if (index > model.indexOf("/") && model.indexOf("/") != -1) {
            index = model.indexOf("/");
        }
        return index;

    }

    @Test
    public void test() {
        System.out.println(calculate("1*2*3*4-6"));
    }


    @Test
    public void test1(){
        System.out.println(UUID.randomUUID());
    }
}
