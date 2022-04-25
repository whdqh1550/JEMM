package application.model;

import java.util.Comparator;

public class monComp implements Comparator<DayMonthYear>{

	@Override
	public int compare(DayMonthYear o1, DayMonthYear o2) {
		if(o1.getMonth() == o2.getMonth()) {
			return 0;
		}
		else if(o1.getMonth()>o2.getMonth()) {
			return 1;
			
		}
		else return -1;
	}

}
