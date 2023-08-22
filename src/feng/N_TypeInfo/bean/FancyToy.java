package feng.N_TypeInfo.bean;

import feng.N_TypeInfo.bean.interfaces.HasBatteries;
import feng.N_TypeInfo.bean.interfaces.Shoots;
import feng.N_TypeInfo.bean.interfaces.Waterproof;

public class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
    public FancyToy (){super(1);}
}
