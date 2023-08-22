package temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class calander {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH,1);
        long time1 = cal.getTimeInMillis();
//        cal.set(Calendar.MONTH,cal.getActualMaximum(Calendar.MONTH));
        Date time = cal.getTime();
        System.out.println(df.format(time));
        TimeZone time2 = cal.getTimeZone();
        System.out.println(time);
        System.out.println("first of Month: "+time1);
        System.out.println("End of Month: "+time2);
    }
}
