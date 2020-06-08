package numbers;

/**
 * @Author fyz
 * @Date 2020/6/8 15:28
 **/
public class Q7_Reverse {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + (x % 10);
            x = x / 10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q7_Reverse().reverse(1234));
    }
}
