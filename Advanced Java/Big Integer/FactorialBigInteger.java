import java.math.BigInteger;

public class FactorialBigInteger{
    public static BigInteger factorial(int n){
        BigInteger x = new BigInteger("1");
        if(n==0 || n==1)
            return x;
        for(int i=2;i<=n;i++){
            x = x.multiply(BigInteger.valueOf(i));
        }
        return x;
    }

    public static void main(String[] args){
        int n = 5;
        System.out.println(factorial(n));
    }
}