package com.test.zipcode.range;

import java.io.Serializable;

/*
 * 
 */
public class ZipCodeRange implements Comparable<ZipCodeRange>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3634151748385811219L;
	private int min;
	private int max;

	public ZipCodeRange(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	/*
	 * This method is used to compare max and min range of the given Zip codes for
	 * sorting out the given input array.
	 */
	public int compareTo(ZipCodeRange compareWith) {
		// primitive comparison
		int compare = (this.getMin() > compareWith.getMin()) ? 1 : 0;
		if (compare == 0) {
			compare = (this.getMin() == compareWith.getMin()) ? 0 : -1;
		}

		if (compare != 0) {
			return compare;
		} else {
			// comparison using Integer wrapper
			Integer maxValue1 = this.getMax();
			Integer maxValue2 = compareWith.getMax();
			return maxValue1.compareTo(maxValue2);
		}
	}

}
