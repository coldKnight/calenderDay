/*
 * Author: Vatsal Srivastava
 * Usage: Gives the day of the week for a given date.
 * The Date has to be given in the following format in the main method (Day[1:31], Month[1:12], Year)
 */

package calenderDay;

public class calenderDay {

	/*
	 * Get the code of the year 
	 */
	public int getYearCode(int year) {
		int yearCode = 0;

		while (year >= 2100 || year <= 1700) {
			if (year >= 2100) {
				year = year - 400;
			} else if (year <= 1700) {
				year = year + 400;
			}

		}

		if (year >= 1700 && year <= 1799) {
			yearCode = (year % 100) / 4 + (year % 100) + 5;
		} else if (year >= 1800 && year <= 1899) {
			yearCode = (year % 100) / 4 + (year % 100) + 3;
		} else if (year >= 1900 && year <= 1999) {
			yearCode = (year % 100) / 4 + (year % 100) + 1;
		} else if (year >= 2000 && year <= 2099) {
			yearCode = (year % 100) / 4 + (year % 100);
		}

		return (yearCode % 7);
	}

	/*
	 * Get the code of the month
	 */
	public int getMonthCode(int month, int year) {
		int monthCode = 0;
		int leap = 0;
		int[] monthArray = { 6, 2, 2, 4, 0, 3, 5, 1, 4, 6, 2, 4 };

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leap = 1;
				} else {
					leap = 0;
				}
			} else {
				leap = 1;
			}
		}

		if (leap == 0) {
			monthCode = monthArray[month - 1];
		} else {
			if (month == 1 || month == 2) {
				monthCode = monthArray[month - 1] - 1;
			} else {
				monthCode = monthArray[month - 1];
			}
		}

		return monthCode;
	}

	/*
	 * Get the code of the Day
	 */
	public String getDay(int date, int month, int year) {
		String[] dayArray = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		int totalCode = getYearCode(year) + getMonthCode(month, year) + date;
		int dayCode = totalCode % 7;
		String doomsDay = dayArray[dayCode];
		// System.out.println(doomsDay);
		return doomsDay;
	}

	/*
	 * Main program. Enter the dates below.
	 */
	public static void main(String[] args) {
		calenderDay calender = new calenderDay();
		/*
		 * Enter date in the following format below (Day[1:31], Month[1:12], Year)
		 */
		System.out.println(calender.getDay(20, 1, 2016));
	}
}