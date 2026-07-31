public class Enumrationn {
    void main(){
        WeekDays [] weekDay = WeekDays.values();
        for(WeekDays wk : weekDay ){
            System.out.println(wk.name());
        }

        System.out.println( " ::::::: :::::: ::::::");
        WeekDays wK = WeekDays.valueOf("SATURDAY");
        System.out.println(wK);

    }

}
enum WeekDays{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}