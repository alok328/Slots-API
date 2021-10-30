package com.alok328.SpringAPI.service.helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalHelper {

  public static List<Interval> mergeIntervals(List<Interval> intervals){
    List<Interval> merged = new ArrayList<>();
    intervals.sort(Comparator.comparing(Interval::getStartDateTime));
    Interval prevInterval = intervals.get(0);
    for(int i=1; i<intervals.size(); i++){
      LocalDateTime prevStart = prevInterval.getStartDateTime();
      LocalDateTime prevEnd = prevInterval.getEndDateTime();
      LocalDateTime curStart = intervals.get(i).getStartDateTime();
      LocalDateTime curEnd = intervals.get(i).getEndDateTime();
      if((curStart.isEqual(prevStart) || curStart.isAfter(prevStart)) && (curStart.isEqual(prevEnd) || curStart.isBefore(prevEnd))){
        prevInterval.setEndDateTime(prevEnd.isAfter(curEnd) ? prevEnd : curEnd);
      }else{
        merged.add(prevInterval);
        prevInterval = intervals.get(i);
      }
    }
    merged.add(prevInterval);
    return merged;
  }

}
