package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link MonthSorter}.
 */

public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        January(31), 
        February(28),
        March(31),
        April(30),
        May(31),
        June(30),
        July(31),
        August(31),
        September(30),
        October(31),
        November(   30),
        December(31);

        private int numberOfDays;
        
        private Month(final int numberOfDays){
            this.numberOfDays = numberOfDays;
        }

        static Month fromString(String name){
            List<Month> query = new ArrayList<Month>();
            for(Month month : Month.values()){
                if(month.toString().toLowerCase().startsWith(name.toLowerCase())){
                    query.add(month);
                }
            }
            if(query.size() > 1 || query.isEmpty()){
                throw new IllegalArgumentException("No such month exists or the search has reported multiple queries");
            }
            return query.get(0);
        }
    }
    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>(){
            public int compare(String a, String b){
                return Integer.compare(Month.fromString(a).numberOfDays, Month.fromString(b).numberOfDays);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>(){
            public int compare(String a, String b){
                return Month.fromString(a).compareTo(Month.fromString(b));
            }
        };
    }
}
