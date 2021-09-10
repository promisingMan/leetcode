package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-09-10 01:40:41
 */
public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        List<String> tmp = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            if (len + word.length() >= maxWidth) {
                if (len + word.length() == maxWidth) {
                    tmp.add(word);
                }
                int strNum = tmp.size();
                int charNum = tmp.stream().mapToInt(String::length).sum();
                int spaceNum = maxWidth - charNum;
                int gap = strNum > 1 ? strNum - 1 : strNum;
                int gapSpaceNum = spaceNum / gap;
                int moreSpaceNum = spaceNum % gap;
                for (int i = 0; i < strNum; i++) {
                    StringBuilder space = new StringBuilder();
                    if (i != strNum - 1) {
                        for (int j = 0; j < gapSpaceNum; j++) {
                            space.append(" ");
                        }
                        if (moreSpaceNum-- > 0) {
                            space.append(" ");
                        }
                    }
                    sb.append(tmp.get(i)).append(space);
                }
                if (strNum == 1) {
                    StringBuilder space = new StringBuilder();
                    while (gapSpaceNum-- > 0) {
                        space.append(" ");
                    }
                    sb.append(space);
                }
                res.add(sb.toString());
                tmp.clear();
                sb = new StringBuilder();
                if (len + word.length() > maxWidth) {
                    k--;
                }
                len = 0;
            } else {
                len += word.length() + 1;
                tmp.add(word);
            }
        }

        int strNum = tmp.size();
        if (strNum != 0) {
            int charNum = tmp.stream().mapToInt(String::length).sum();
            int lastSpaceNum = maxWidth - charNum - strNum;

            for (String s : tmp) {
                sb.append(s).append(" ");
            }
            while (lastSpaceNum-- > 0) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        // handle the last
        return res;
    }
}
