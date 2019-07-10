package beers;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class beers {
    public static void main(String[] args) {
        int i = 0;
        while (i < 100) {
            if (i < 99) {
                System.out.println((100 - i) + "bottles of beer on the wall," + (100 - i) + "bottles of beer.\nTake one down and pass it around," + ((100 - (i+1))) + " bottles of beer on the wall.");
                i ++;
            } else {
                System.out.println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall.");
                break;
            }
        }

        int max = 101;
        for(int iterator = 0; iterator < max; iterator++){
            if (iterator < 100) {
                System.out.println((100 - iterator) + " bottles of beer on the wall," + (100 - iterator) + " bottles of beer.\nTake one down and pass it around, " + ((100 - (iterator + 1))) + " bottles of beer on the wall.");
            } else {
                System.out.println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall.");
            }        }

        int[] a = IntStream.range(1, 101).toArray();
        for (Integer iterator : a) {
            if (iterator < 100) {
                System.out.println((100 - iterator) + " bottles of beer on the wall," + (100 - iterator) + " bottles of beer.\nTake one down and pass it around, " + ((100 - (iterator + 1))) + " bottles of beer on the wall.");
            } else {
                System.out.println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall.");
            }
        }
    }


}

