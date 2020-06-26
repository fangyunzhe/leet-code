package in_action.byte_dance;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/23 10:58
 **/
public class Q2_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if ("".equals(prefix)) {
                return "";
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(), str.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }
        return prefix.substring(0, index);
    }


}
