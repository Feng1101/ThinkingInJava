package feng.N_TypeInfo.bean.packageaccess;

import feng.N_TypeInfo.bean.interfaces.A;

public class HiddenC {
    public static A makeA(){
        return new C();
    }

}
