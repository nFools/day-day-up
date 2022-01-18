package org.nfools.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17 {
    static Map<String, String[]> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();

    static {
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        String[][] sss = new String[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            sss[i] = map.get(digits.substring(i, i + 1));
        }
        if (sss.length > 0) {
            m(sss, 0);
        }
        return list;
    }

    /**
     * @param sss
     * @param n   0
     * @return
     */
    public void m(String[][] sss, int n) {
        for (String s : sss[n]) {
            sb.replace(n, n + 1, s);
            if (n == sss.length - 1) {
                list.add(sb.toString());
            } else {
                int np = n + 1;
                m(sss, np);
            }
            if (n == 0) {
                sb = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("234"));
    }
}