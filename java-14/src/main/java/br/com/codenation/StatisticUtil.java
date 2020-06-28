package br.com.codenation;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) IntStream
				.of(elements)
				.average()
				.getAsDouble();
	}

	public static int mode(int[] elements) {
		HashMap<Integer, Integer> numbersMap = new HashMap<>();

		for (int element : elements) {
			int count = numbersMap.getOrDefault(element, 0);
			numbersMap.put(element, count + 1);
		}

		return numbersMap.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(HashMap.Entry.comparingByValue()))
				.findFirst()
				.get()
				.getKey();
	}

	public static int median(int[] elements) {
		return (int) IntStream
				.of(elements)
				.sorted()
				.skip((elements.length - 1) / 2)
				.limit(2 - elements.length % 2)
				.average()
				.getAsDouble();
	}
}