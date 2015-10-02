package com.example.siah;

import java.util.Comparator;

public class priceCompare implements Comparator<Data> {

	@Override
	public int compare(Data lhs, Data rhs) {
		return (lhs.getPrice()).compareTo(rhs.getPrice());
	}

}
