package feng.O_Generics.bean;

import feng.util.javaUtil.Generator;

/**
 * 斐波那契数列 生成器
 */
public class Fibonacci implements Generator {
    private int count=0;

    private int fib(int n){
        if(n<2){
            return 1;
        }
        return fib(n-2)+fib(n-1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }
}
