package feng.R_Enumerted.C_Switch;
enum Signal{ GREEN, YELLOW, RED;}
public class TrafficLight {
    Signal color=Signal.RED;
    public void change(){
        switch (color){
            case RED : color=Signal.GREEN;
            break;
            case YELLOW: color=Signal.RED;
            break;
            case GREEN: color=Signal.YELLOW;
            break;
        }
    }
    public String toString (){
        return "The Traffic light is "+color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i=0; i<7;i++){
            System.out.println(t);
            t.change();
        }
    }
}
