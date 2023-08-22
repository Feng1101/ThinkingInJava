package feng.O_Generics.bean.I_边界;

import java.awt.*;

/**
 * 可以看到泛型类继承 和  java普通继承的关系
 * 泛型类继承 指 边界,即该类需要具备的继承关系
 */
interface HasColor{java.awt.Color getColor();}

class Colored<T extends HasColor>{
    T item;
    Colored (T item){this.item=item;}
    java.awt.Color color(){return  item.getColor();}
}

class Dimension {public int x,y,z; }

//泛型类继承时先具体类，后接口
class ColoredDimension <T extends Dimension & HasColor>{
    T item;
    ColoredDimension (T item){this.item=item;}
    T getItem (){return  item;}
    java.awt.Color color(){return item.getColor();}
    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}

interface Weight{int weight();}

class Solid <T extends Dimension & Weight & HasColor> {
    T item;
    Solid (T item){this.item=item;}
    T getItem (){return  item;}
    java.awt.Color color(){return item.getColor();}
    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
    int weight(){return item.weight();}
}

class Bounded extends Dimension implements HasColor,Weight{
    public java.awt.Color getColor(){return null;}
    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid=new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }

}
