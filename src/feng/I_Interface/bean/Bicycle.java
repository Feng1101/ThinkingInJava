package feng.I_Interface.bean;

import feng.I_Interface.bean.factory.BicycleFactory;
import feng.I_Interface.bean.factory.CycleFactory;

public class Bicycle implements Cycle{
    private String body ="碳合金";
    @Override
    public void move() {
        System.out.println("车身为: "+body);
    }

}
