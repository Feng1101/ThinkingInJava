package feng.I_Interface.bean.factory;

import feng.I_Interface.bean.Bicycle;
import feng.I_Interface.bean.Cycle;

public class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}
