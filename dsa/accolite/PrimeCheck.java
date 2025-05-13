package dsa.accolite;

public class PrimeCheck {
    public static void main(String[] args) {
        int number = 1229;
        if (isPrime(number)) {
            System.out.println("Number is Prime");
        } else {
            System.out.println(" Number is not prime");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i+=6) {
            if (number % i == 0 || number % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }
}
