package temp.exam;

import java.util.*;

public class two2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        List<String> result=new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String temp=in.nextLine();
            System.out.println(temp);
            if(temp.equals("c"))
                break;
            result.add(temp);
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] t1=new String[4];
                getNums(t1,s1.split(":"));
                String[] t2 = new String[4];
                getNums(t2,s2.split(":"));
                for (int i = 0; i < 4; i++) {
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




    }
    public static void getNums(String[] t1,String[] temp){
        t1[0]=temp[0];
        t1[1]=temp[1];
        String[] split = temp[2].split("\\.");
        t1[2]=split[0];
        t1[3]=split[1];
    }
}
