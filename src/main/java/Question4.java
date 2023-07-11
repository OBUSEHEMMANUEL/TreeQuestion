import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the value of N: ");
        int N = Integer.parseInt(reader.readLine());

        BigInteger factorial = calculateFactorial(N);

        System.out.println("The factorial of " + N + " is: " + factorial);
    }

    public static BigInteger calculateFactorial(int N) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
