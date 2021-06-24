package yxy.tom.yang;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("294558318881405180764747479252007358319960875235150893513057100495960335262381639732" +
                "393624382991877148611640594583065379669231891214833093801938123911763243718214043283" +
                "060093720669049649181956712189051916260382176617240174711734510352477962712574583690" +
                "779486253846522009126482319144984230256476305809392243435136726060071627481596350642" +
                "241513558954925792693196456498326057846493955255568347280893811272095586783577349445" +
                "131066561096635908313303089526419052508796347391313473326110069433039169945763380273" +
                "958809155750154147725521635748917952339066093424140296680685333565455781078703656353" +
                "98276428848740477292742280559");
        BigInteger g = new BigInteger("5");

        int numBits = 2046;

        Random rand = new Random();
        BigInteger a = new BigInteger(numBits, rand);

        BigInteger b = new BigInteger(numBits, rand);

        BigInteger A = g.modPow(a, p);

        BigInteger B = g.modPow(b, p);

        BigInteger s1 = A.modPow(b, p);

        BigInteger s2 = B.modPow(a, p);

        System.out.println(s1);

        System.out.println(s2);

    }
}
