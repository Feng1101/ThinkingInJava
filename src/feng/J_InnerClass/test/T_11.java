package feng.J_InnerClass.test;

import feng.J_InnerClass.bean.Car;

public class T_11 {
    private class Private implements Car {
        private int a=1;
        public void show(){
            System.out.println("show: "+a);
        }
    }

    public Car getCar(){
        return new Private();
    }

    //比较诡异的一种写法。与上面两个合在一起相等
    public Car generateCar(){
        return new Car(){
            private int b=1;
            public void show(){
                System.out.println("show + : "+b);
            }
        };
    }

    public static void main(String[] args) {
        T_11 t11 = new T_11();
        Car pri=t11.getCar();
        pri.show();
        Car car = t11.generateCar();
        car.show();
    }
}
