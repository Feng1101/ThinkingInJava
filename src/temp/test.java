package temp;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {
    static Integer []num ={5,9,18,54,108,540,90,180,360,720};


    public static void main(String[] args) {
        List<Integer> nums = Arrays.stream(num).collect(Collectors.toList());
        Boolean one=false;
        Collections.sort(nums);
        List<Integer> end=new ArrayList<>();
        if(nums.get(0)==1){
            nums.remove(0);
            one =true;
        }
        List<Integer> go = go(new ArrayList<>(nums));
        nums.remove(0);
        end=go(nums);
        if(end.size()<go.size())
            end=go;
        if(one){
            end.add(1);
            Collections.sort(end);
        }
        System.out.println(end);

    }
    private static List<Integer> go(List<Integer> nums){
        System.out.println(nums);
        List<Integer> end=new ArrayList<>();

        while(nums.size()!=0){
            Iterator<Integer> it = nums.iterator();
            List<Integer> temp=new ArrayList<>();
            while(it.hasNext()){
                Integer val = it.next();
                if(temp.size()==0){
                    temp.add(val);
                    it.remove();
                    continue;
                }
                if(val%temp.get(temp.size()-1)==0){
                    temp.add(val);
                    it.remove();
                }
            }
            if(end.size()<temp.size())
                end=temp;
        }
        return end;

    }
}
