package src.fr.uvsq.iut_velizy.date;

import java.util.Calendar;

public class DateCalendar extends Date
    implements Comparable <Date>, ConstantCalendar{
    private int dayOfWeek;

    public DateCalendar(){
        Calendar today = Calendar.getInstance();
        year =  today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH) + 1;
        day = today.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = today.get(Calendar.DAY_OF_WEEK);

        dayOfWeek--;

        if(dayOfWeek == -1){
            dayOfWeek = 6;
        }
    }

    

    public DateCalendar(int pDay, int pMonth, int pYear){
        
        Calendar date = Calendar.getInstance();

        date.set(pYear, pMonth - 1, pDay);

        year =  date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH) + 1;
        day = date.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

        dayOfWeek--;

        if(dayOfWeek == -1){
            dayOfWeek = 6;
        }
    }

    public String toString(){
        return super.toString() + " " +  DAY_WEEK[dayOfWeek - 1];
    }
    
    public DateCalendar tommorowDate(){
        Date date = super.tomorrowDate();
        return new DateCalendar(date.day, date.month, date.year);
    }

    public DateCalendar yesterdate(){
        Date date = super.yesterDate();
        return new DateCalendar(date.day, date.month, date.year);
    }

}
