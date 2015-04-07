package com.google.test.base.preconditions;

import java.util.List;

public class Test {

	public void doSomething(List<Object> list) {
		if (list == null) {
			throw new IllegalArgumentException("List must not be null");
		}
		if (list.isEmpty()) {
			throw new IllegalArgumentException("List must not be empty");
		}
		doSomethingMore(list);
	}

	private void doSomethingMore(List<Object> list) {

	}

}
