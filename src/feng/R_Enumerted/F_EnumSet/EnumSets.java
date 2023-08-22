package feng.R_Enumerted.F_EnumSet;

import java.util.EnumSet;
import static feng.R_Enumerted.F_EnumSet.AlarmPoints.*;

/**
 * 比HashSet 快很多，但元素只能来自于Enum
 * 具备enum中的顺序性
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);
        points=EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        System.out.println(points);
        //反转
        points=EnumSet.complementOf(points);
        System.out.println(points);
    }
}
