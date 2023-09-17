package temp.exam;

import java.util.*;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：

输入：s = '()'
输出：true
示例 2：

输入：s = '()[]{}'
输出：true
示例 3：

输入：s = '(]'
输出：false
示例 4：

输入：s = '([)]'
输出：false
示例 5：

输入：s = '({[]})'
输出：true
 */
public class HWT2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("()","()[]{}","(]","([)]","({[]})");
        for(int i=0;i<strings.size();i++){
            String temp=strings.get(i);
            System.out.println("第"+(i+1)+"个实例  "+temp+"  的结果为: "+getString(temp));
        }

    }
    public static Boolean getString(String s){
        Stack<Character> stack = new Stack<>();
        Set<Character> lefts = new HashSet<>();
        lefts.add('(');
        lefts.add('[');
        lefts.add('{');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(lefts.contains(chars[i])){
                stack.push(chars[i]);
                continue;
            }
            int key=stack.pop()-chars[i];
            if(key<-2 || key>-1)
                return false;
        }

        return true;
    }
    
}
