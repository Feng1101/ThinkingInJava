package feng.P_Containers.F_散列码;

public class Groundhog2 extends Groundhog {
    public Groundhog2(int n){super(n);}
    public int hashCode(){return  number;}
    public boolean equals(Object o){
        return o instanceof Groundhog2 && (number==((Groundhog2) o).number);
    }
}
