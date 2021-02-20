package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.IsPrimeFast(Integer.MAX_VALUE));
    }

    @Test (enabled = false)
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.IsPrime(n));
    }

    @Test
    public void testNonPrime() {
        Assert.assertFalse(Primes.IsPrime(Integer.MAX_VALUE - 2));
    }
}
