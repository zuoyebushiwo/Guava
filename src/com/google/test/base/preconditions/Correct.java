package com.google.test.base.preconditions;

import java.util.List;

import com.google.common.base.Preconditions;

public class Correct {

	public void doSomething(List<Object> list) {
		Preconditions.checkArgument(list != null, "List must not be null");
		Preconditions.checkArgument(!list.isEmpty(), "List must not be empty");
		doSomethingMore(list);
	}

	private void doSomethingMore(List<Object> list) {
	}

}
