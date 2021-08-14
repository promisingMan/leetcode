package binary_search;

/**
 * @author zengjia
 * @date 2021-04-01 08:47:23
 */
public class SqrtX_69 {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
//
//        while (low <= high) {
//            long mid = low + (high - low) / 2;
//            long r = mid * mid;
//            if (r > x) high = mid - 1;
//            else if (r < x) low = mid + 1;
//            else return (int) mid;
//        }
//        return (int) low - 1;

//        // 左中位数
//        while (low < high) {
//            long mid = low + (high - low) / 2;
//            long r = mid * mid;
//            if (r > x) high = mid;
//            else if (r < x) low = mid + 1;
//            else return (int) mid;
//        }
//        return (int) low - 1;

        // 右中位数
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            long r = mid * mid;
            if (r > x) high = mid - 1;
            else if (r < x) low = mid;
            else return (int) mid;
        }
        return (int) low;
    }
}
