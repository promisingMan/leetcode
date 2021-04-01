package arr_str;

/**
 * @author zengjia
 * @date 2021-03-30 11:55:24
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return i == 0 ? "" : strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
