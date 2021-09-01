package arr_str.double_pointer;

/**
 * @author zengjia
 * @date 2021-09-01 20:19:02
 */
public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int i = 0, j = 0, count1 = 0, count2 = 0;
        StringBuilder v1 = new StringBuilder("0");
        StringBuilder v2 = new StringBuilder("0");
        int len1 = chars1.length;
        int len2 = chars2.length;
        while (i <= len1 || j <= len2) {
            if (count1 == count2 && count1 != 0) {
                int compare = Integer.compare(Integer.parseInt(v1.toString()), Integer.parseInt(v2.toString()));
                count1 = 0;
                count2 = 0;
                i++;
                j++;
                v1 = new StringBuilder("0");
                v2 = new StringBuilder("0");
                if (compare != 0) {
                    return compare;
                }
            }
            if (i < len1 && chars1[i] != '.') {
                if (i == len1 - 1) {
                    count1 = 1;
                }
                v1.append(chars1[i++]);
            } else {
                count1 = 1;
            }
            if (j < len2 && chars2[j] != '.') {
                if (j == len2 - 1) {
                    count2 = 1;
                }
                v2.append(chars2[j++]);
            } else {
                count2 = 1;
            }
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            int x = 0;
            for (; i < len1 && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < len2 && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new CompareVersionNumbers_165().compareVersion("1.0.1", "1");
    }
}
