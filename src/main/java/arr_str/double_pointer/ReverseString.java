package arr_str.double_pointer;

/**
 * @author zengjia
 * @date 2021-04-04 12:58:38
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char temp;
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
