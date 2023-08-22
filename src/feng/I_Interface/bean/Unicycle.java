package feng.I_Interface.bean;

public class Unicycle implements Cycle{
    private String body="铝合金";
    public void move(){
        System.out.println("车身为： "+body);
    }
}
