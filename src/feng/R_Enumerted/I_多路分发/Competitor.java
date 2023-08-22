package feng.R_Enumerted.I_多路分发;

public interface Competitor <T extends Competitor<T>>{
    Outcome compete(T competitor);
}
