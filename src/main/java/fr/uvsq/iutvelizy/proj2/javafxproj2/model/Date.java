package src.fr.uvsq.iut_velizy.date;

import src.fr.uvsq.iut_velizy.utils.*;

public class Date {
    protected int day;
    protected int month;
    protected int year;


    /**
     * Create new Date with
     * @param pDay --> Day of the Date
     * @param pMonth --> Month of the Date
     * @param pYear --> Year of the Date
     */
    public Date (int pDay, int pMonth, int pYear){
        day = pDay;
        month = pMonth;
        year = pYear;
    }

    public Date (){

    }

    public String toString(){
        return "" + day + "/" + month + "/" + year;
    }


    /**
     * Set if the year of the date is a leap year
     * @param pYear
     */
    private static Boolean isLeap(int pYear){
        return (pYear%4 == 0 && pYear%100 != 0) || pYear%400 == 0;
    }

    /**
     * Compare if this is begin before or after pDate
     * @param pDate --> Date to compare
     * @return -1 if date start before pDate <br/>
     *          1 if date slot start after pDate <br/>
     *          0 if date slot start in same time of pDate 
     */
    public int compareTo(Date pDate){
        if (year < pDate.year){
            return -1;
        }
        else if (year > pDate.year){
           return 1;
        }
        else {
            if (month < pDate.month){
            return -1;
            }
            else if (month > pDate.month){
                return 1;
            }
            else {
                if (day < pDate.day){
                    return -1;
                }
                if (day > pDate.day){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    }


    /**
     * Return the last day of pMonth in function of pYear for febuary
     * @param pMonth
     * @param pYear
     */
    private static int lastDayMonth(int pMonth,int pYear){
        switch(pMonth){
            case 2 :
                if (isLeap(pYear)) return 29;
                else return 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default :
                return 31;
        }
    }


    /**
     * Check if the date is valid
     */
    public boolean isValid(){
        if (year >= 1583){
            if (1 <= month  && month <= 12){
                if(1 <= day && day <= lastDayMonth(month, year)){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }    
        else {
            return false;
        }
    }

    public int readDate(){
        System.out.print("1: Jour 2: Mois 3: Année : ");
        switch(KeyBoard.readInt()){
            case 1 : 
                return day;
            case 2:
                return month;
            case 3: 
                return year;
        }

        return day;
    }

    public Date tomorrowDate(){
        int lNextDay = day;
        int lNextMonth = month ;
        int lNextYear = year;

        if (day == lastDayMonth(month, year)){
            lNextDay = 1;
            lNextMonth++; 

            if (month == 12){
                lNextMonth = 1;
                lNextYear++;
            }
        }
        else{
            lNextDay++;
        }

        return new Date(lNextDay, lNextMonth, lNextYear);
    }

    public Date yesterDate(){
        int lPrevDay = day;
        int lPrevMonth = month;
        int lPrevYear = year;

        if(day == 1){
            lPrevMonth--;
            lPrevDay = lastDayMonth(lPrevMonth, year);
            
            if(month == 1){
                lPrevMonth = 12;
                lPrevDay = 31;
                lPrevYear--;
            }
        }
        else {
            lPrevDay --;
        }
        
        return new Date(lPrevDay , lPrevMonth, lPrevYear);
    }
}

