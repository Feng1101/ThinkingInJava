package feng.I_Interface.bean.factory;

import feng.I_Interface.bean.Cycle;
import feng.I_Interface.bean.Unicycle;

public class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}
