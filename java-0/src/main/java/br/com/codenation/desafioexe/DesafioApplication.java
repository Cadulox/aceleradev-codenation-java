package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);

		int number = 1;

		while (number <= 350) {
			number += list.get(list.size() - 2);
			list.add(number);
		}

		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}