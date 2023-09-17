package temp.exam;

import java.util.*;

public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        List<String>result=new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String temp=in.nextLine();
            result.add(temp);
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] t1 = s1.split(":");
                String[] t2 = s2.split(":");
                for (int i = 0; i < 3; i++) {
                    char[] c1 = t1[i].toCharArray();
                    if(c1[0]=='0'&&t1[i].length()>1){
                        t1[i]=c1[1]+"";
                    }
                    char[] c2 = t2[i].toCharArray();
                    if(c2[0]=='0'&& t2[i].length()>1){
                        t2[i]=c2[1]+"";
                    }
                    int number1=Integer.parseInt(t1[i]);
                    int number2=Integer.parseInt(t2[i]);
                    if(number1!=number2)
                        return (number1-number2)>0?1:-1;
                }
                return  0;
            }
        });
        for(String s :result){
            System.out.println(s);
        }


/*
2
01:41:8.9
1:1:09.211
 */

    }
}
