package com.test.service.impl;

/**
 * Created by Jes on 09/28/2018.
 */
public class MathServiceImpl {

	public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
}
