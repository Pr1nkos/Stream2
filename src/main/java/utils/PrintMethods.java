package utils;

import models.UserOnline;

import java.time.LocalDate;
import java.util.List;

import static utils.MaxOnlineMethods.*;

public class PrintMethods {
	public static void printOnlineUsers(List<UserOnline> onlineList) {
		System.out.println(ConsoleColors.ANSI_BLUE + "Online Users:" + ConsoleColors.ANSI_RESET);
		onlineList.forEach(System.out::println);
	}

	public static void printMaxOnline(List<UserOnline> onlineList) {
		System.out.println(ConsoleColors.ANSI_GREEN + "Max Online: " + findMaxOnline(makeMapOfOnline(onlineList)) + ConsoleColors.ANSI_RESET);
	}

	public static void printMaxOnlineDate(List<UserOnline> onlineList) {
		System.out.println(ConsoleColors.ANSI_YELLOW + "Max Online Date: " + findMaxOnlineDate(onlineList) + ConsoleColors.ANSI_RESET);
	}

	public static void printMaxOnlineDateRange(List<UserOnline> onlineList) {
		System.out.println(ConsoleColors.ANSI_BLUE + "Max Online Date Range:" + ConsoleColors.ANSI_RESET);
		for (LocalDate[] dates : findMaxOnlineDateRange(onlineList)) {
			System.out.println("Start Date: " + dates[0] + ", End Date: " + dates[1]);
		}
	}

	private PrintMethods(){}
}
