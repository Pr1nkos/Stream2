import models.UserOnline;


import java.util.*;
import java.util.stream.Stream;

import static utils.PrintMethods.*;

public class Runner {

	private static final Random RAND = new Random();

	public static void main(String[] args) {
		List<UserOnline> onlineList = generateRandomOnlineUsers();
		printOnlineUsers(onlineList);
		printMaxOnline(onlineList);
		printMaxOnlineDate(onlineList);
		printMaxOnlineDateRange(onlineList);
	}


	private static List<UserOnline> generateRandomOnlineUsers() {
		int i = RAND.nextInt(1, 50);
		return Stream.generate(UserFactory::generateUser)
				.limit(i)
				.toList();
	}






}
