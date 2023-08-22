package feng.K_HoldingObjects.beans;

public class Mouse {
    private  int number;
    public Mouse(int key){
        this.number=++key;
    }
    public void hop(){
        System.out.println("the mouse of "+number+" is hopping now!!");
    }
    public  String toString(){
        return "the mouse is "+number;
    }
}
