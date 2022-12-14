package pl.wojtek.rsa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

class RSA {
    public static void main(String args[])
    {
        int p, q, n, z, d = 0, e, i;
        Random rand = new Random();
        int msg = rand.nextInt(50);
        System.out.println("[msg] wynosi: " + msg);
        double c;
        BigInteger msgback;
 
        p = 3;
 
        q = 11;
        n = p * q;
        z = (p - 1) * (q - 1);
 
        for (e = 2; e < z; e++) {
 
            if (gcd(e, z) == 1) {
                break;
            }
        }
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
 
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        c = (Math.pow(msg, e)) % n;
 
        //No message Attack
        double s = (Math.pow(msg,d))%n;
        System.out.println("[s] wynosi: " +s);
        double m = (Math.pow(s,e)%n);
        System.out.println("[m']" + m);
 
 
        System.out.println("Zaszyfrowane: " + c);
        BigInteger N = BigInteger.valueOf(n);
 
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Odszyfrowane: "
                + msgback);
    }
 
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
 
 
}