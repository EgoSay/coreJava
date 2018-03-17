package eighth;

import java.time.LocalDate;

/**
 * @author codeAC
 * @date 2018/3/17 12:57
 */
public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second) {}

//    public void setSecond(Object second){
//        setSecond((Date) second);
//    }


    @Override
    public LocalDate getSecond() {
        return (LocalDate)super.getSecond();
    }
    public static void main(String[] args) {
        DateInterval interval = new DateInterval();
        Pair<LocalDate> pair = interval;
        pair.setSecond(LocalDate.now());
        System.out.println(pair.getSecond());
    }

}
