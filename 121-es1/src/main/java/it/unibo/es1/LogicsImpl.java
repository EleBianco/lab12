package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LogicsImpl implements Logics {
	private List<Integer> values;

	public LogicsImpl(int size) {
		values = new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public List<Integer> values() {
		return values;
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream()
			.map(d -> d != values.size())
			.toList();
	}

	@Override
	public int hit(int elem) {
		if (this.enablings().get(elem)) {
			values.set(elem, values.get(elem) + 1);
		}
		return values.get(elem);
	}

	@Override
	public String result() {
		return values.stream()
			.map(t -> t.toString())
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return values.stream()
			.allMatch(d -> d == values.get(0));
	}
}
