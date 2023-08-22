package feng.R_Enumerted.H_常量相关;

import java.util.Random;

/**
 * 状态机
 * enum类型很适合用于状态机，类型确定，也可以提前定义错误输出
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        public int amount(){
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{
        public int amount(){
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    Input(int value ){this.value=value;}
    Input(){}
    int amount(){return value;}
    static Random rand =new Random(47);
    public static Input randomSelection(){
        return values()[rand.nextInt(values().length-1)];
    }
}
