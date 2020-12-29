package com.test.zipcode.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZipCodeService {
	/*
	 * This method will consolidate ranges as per the requirement
	 */
	List<ZipCodeRange> evaluateIntervals(List<ZipCodeRange> rangeList) {
		int rangeListSize = rangeList.size();

		List<ZipCodeRange> finalList = new ArrayList<>();
		if (rangeListSize > 0) {
			Collections.sort(rangeList);
			ZipCodeRange firstRange = rangeList.get(0);
			for (int i = 1; i < rangeListSize; i++) {
				ZipCodeRange currRange = rangeList.get(i);

				// To evaluate 94200-94299 94201-94399
				boolean firstRangeMaxEqualToCurrentMin = firstRange.getMax() + 1 == currRange.getMin();
				boolean firstRangeMaxGreater = firstRange.getMax() >= currRange.getMin();

				// To evaluate 94200-94299 94226-94399
				boolean currentMinIsBetweenFirstMinMax = firstRange.getMin() <= currRange.getMin()
						&& currRange.getMin() <= firstRange.getMax();
				if ((firstRangeMaxEqualToCurrentMin && firstRangeMaxGreater)
						|| firstRange.getMax() < currRange.getMax() && currentMinIsBetweenFirstMinMax) {
					firstRange.setMax(currRange.getMax());
					firstRange.setMax(currRange.getMax());
				} else {
					finalList.add(firstRange);
					firstRange = rangeList.get(i);
				}
			}
			finalList.add(firstRange);
		}

		return finalList;
	}

	/*
	 * This method will validates the zipcode and will let know it is valid zip
	 * code.
	 */
	public boolean validZipCode(int zipCode, List<ZipCodeRange> finalRanges) {
		for (ZipCodeRange range : finalRanges) {
			if (zipCode >= range.getMin() && zipCode <= range.getMax()) {
				return false;
			}
		}

		return true;
	}
}
