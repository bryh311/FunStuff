package c134_ulamspiral;

import java.util.stream.IntStream;

public class Spiral {
    private int length;
    private int[] primeList;

    public int[] getPrimeList() { return primeList; }


    public Spiral(int length) {
        this.length = length;
        this.primeList = IntStream.range(1, length+1).toArray();
        primeList = setPrimesAndZeroes(primeList);
    }

    public boolean isPrime(int i) {
        int[] divisors = IntStream.range(2, i).toArray();
        for(int divisor: divisors)
            if(i % divisor == 0 && i != 1 && i != 2)
                return false;
        return true;
    }

    public int[] setPrimesAndZeroes(int[] numArray) {
        int[] primeZeroList = new int[numArray.length];
        for(int i = 0; i < primeZeroList.length; i++) {
            if(isPrime(numArray[i]))
                primeZeroList[i] = numArray[i];
            else
                primeZeroList[i] = 0;
        }
        return primeZeroList;
    }



}
