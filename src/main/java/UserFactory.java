import models.UserOnline;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class UserFactory {
	private static final Random RAND = new Random();
	static final int STARTYEAR = 1000;
	static final int ENDYEAR = 2021;

	public static UserOnline generateUser() {
		int randomYearStart = RAND.nextInt(STARTYEAR, ENDYEAR);
		int randomMonthStart = RAND.nextInt(1, 12);
		int randomDayStart = RAND.nextInt(1, Month.of(randomMonthStart).maxLength());
		int randomYearEnd = RAND.nextInt(STARTYEAR, ENDYEAR);
		int randomMonthEnd = RAND.nextInt(1, 12);
		int randomDayEnd = RAND.nextInt(1, Month.of(randomMonthEnd).maxLength());

		LocalDate startUserOnline = LocalDate.of(randomYearStart, randomMonthStart, randomDayStart);
		LocalDate endUserOnline = LocalDate.of(randomYearEnd, randomMonthEnd, randomDayEnd);

		if (startUserOnline.isAfter(endUserOnline)) {
			LocalDate temp = startUserOnline;
			startUserOnline = endUserOnline;
			endUserOnline = temp;
		}

		return new UserOnline(startUserOnline, endUserOnline);
	}
	private UserFactory(){}
}

