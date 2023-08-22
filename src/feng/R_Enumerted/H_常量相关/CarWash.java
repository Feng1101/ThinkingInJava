package feng.R_Enumerted.H_常量相关;

import java.util.EnumSet;

/**
 * enumSet 会根据Enum中的创建顺序自动进行排序，注意输出的顺序
 */
public class CarWash {
    public enum Cycle{
        UNDERBODY{
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH{
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        BASIC{
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX{
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE{
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY{
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }


    //相当于初始化
    EnumSet<Cycle> cycles=EnumSet.of(Cycle.BASIC,Cycle.RINSE);
    public void add(Cycle cycle){cycles.add(cycle);}
    public void washCar(){
        for(Cycle cycle:cycles)
            cycle.action();
    }
    public String toString(){return cycles.toString();}

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }

}
