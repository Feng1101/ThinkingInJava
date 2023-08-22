package feng.R_Enumerted.I_多路分发;

import static feng.R_Enumerted.I_多路分发.Outcome.*;

public interface Item {
    Outcome compete(Item it);
    Outcome eval(Paper it);
    Outcome eval(Scissors it);
    Outcome eval(Rock r);
}

class Paper implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors it) {
        return LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }
    public String toString(){return "Paper";}
}

class Scissors implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return WIN;
    }

    @Override
    public Outcome eval(Scissors it) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return LOSE;
    }
    public String toString(){return "Scissors";}
}

class Rock implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper it) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors it) {
        return LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }
    public String toString(){return "Rock";}
}
