package utils;

import models.UserOnline;

import java.time.LocalDate;
import java.util.*;

public class MaxOnlineMethods {
	public static int findMaxOnline(Map<UserOnline, Integer> mapOfMaxOnline) {
		return mapOfMaxOnline.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getValue)
				.orElse(0);
	}


	public static Map<UserOnline, Integer> makeMapOfOnline(List<UserOnline> onlineList) {
		Map<UserOnline, Integer> mapOfMaxOnline = new HashMap<>();
		for (int i = 0; i < onlineList.size(); i++) {
			int count = 1;
			for (int j = 0; j < onlineList.size() - 1; j++) {
				if ((onlineList.get(i).getStartSession().isAfter(onlineList.get(j).getStartSession()))
						&& (onlineList.get(i).getStartSession().isBefore(onlineList.get(j).getEndSession()))
						|| (onlineList.get(i).getEndSession().isBefore(onlineList.get(j).getEndSession())
						&& (onlineList.get(i).getEndSession().isAfter(onlineList.get(j).getStartSession())))) {
					count++;
				}
			}
			mapOfMaxOnline.put(onlineList.get(i), count);
		}
		return mapOfMaxOnline;
	}


	public static LocalDate findMaxOnlineDate(List<UserOnline> onlineList) {
		Map<UserOnline, Integer> mapOfOnline = makeMapOfOnline(onlineList);
		Optional<Map.Entry<UserOnline, Integer>> maxEntry = mapOfOnline.entrySet().stream()
				.min(Map.Entry.<UserOnline, Integer>comparingByValue().reversed()
						.thenComparing(Map.Entry.comparingByKey(Comparator.comparing(UserOnline::getStartSession).reversed())));
		return maxEntry.map(entry -> entry.getKey().getStartSession()).orElse(null);
	}

	public static List<LocalDate[]> findMaxOnlineDateRange(List<UserOnline> onlineList) {
		Map<UserOnline, Integer> mapOfOnline = makeMapOfOnline(onlineList);
		Optional<Map.Entry<UserOnline, Integer>> maxEntryMax = mapOfOnline.entrySet().stream()
				.min(Map.Entry.comparingByValue());
		LocalDate startDate = findMaxOnlineDate(onlineList);
		LocalDate endDate = maxEntryMax.map(entry -> entry.getKey().getEndSession()).orElse(null);
		List<LocalDate[]> dateRange = new ArrayList<>();
		dateRange.add(new LocalDate[]{startDate, endDate});

		return dateRange;
	}


	private MaxOnlineMethods() {}

}
