package temp;

import java.util.*;

public class test2 {
    private static  Random random=new Random();
    public static void main(String[] args) {
        long e=Long.valueOf("5");
        System.out.println(e);
        System.out.println(e/10);
        char[] a={'a','b','c'},b={'c','a','b','d'};
        test2 test2 = new test2();
        List<List<String>> lists = test2.groupAnagrams(new String[]{"abc", "cba", "aa", "aa"});
        System.out.println(lists);
        Set<Character> chars = new HashSet<>();
        chars.add('a');
        if(chars.contains('a')){
            chars.remove('a');
            System.out.println(chars.size());
        }
    }

    public void sort(int[] nums){
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
