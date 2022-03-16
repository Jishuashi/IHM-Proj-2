package fr.uvsq.iutvelizy.proj2.javafxproj2.model;

import java.util.TreeSet;
import java.util.Collection;

public class DateCalendarMonth {

    private int month;
    private int year;
    private Collection <DateCalendar> treeSetDate;

    public DateCalendarMonth ( int month, int year) {
        this.month = month;
        this.year = year;
        treeSetDate = new TreeSet <DateCalendar>();
        DateCalendar date = new DateCalendar (1,month,year);
        int indexDay = date.getDay() ;
        for (int x = indexDay ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.yesterdate();
        }
        date = new DateCalendar (2,month,year);
        indexDay = indexDay % 7 ;
        while (date.getMonth() == month) {
            while(indexDay<7) {
                treeSetDate.add(date);
                date = date.tommorowDate();
                indexDay++ ;
            }
            indexDay=0;
        }
    }

    public Collection <DateCalendar> getDates() {
        return treeSetDate;
    }

    public String toString () {
        return treeSetDate.size() + " " + treeSetDate.toString();
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year ;
    }

}