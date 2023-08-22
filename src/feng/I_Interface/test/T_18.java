package feng.I_Interface.test;

import feng.I_Interface.bean.Bicycle;
import feng.I_Interface.bean.Cycle;
import feng.I_Interface.bean.factory.BicycleFactory;
import feng.I_Interface.bean.factory.CycleFactory;
import feng.I_Interface.bean.factory.UnicycleFactory;

public class T_18 {
    public static void showCycle(CycleFactory cycleFactory){
        Cycle cycle = cycleFactory.getCycle();
        cycle.move();
    }

    public static void main(String[] args) {
        showCycle(new BicycleFactory());
        showCycle(new UnicycleFactory());
    }
}
