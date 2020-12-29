package com.test.zipcode.range;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ZipCodeServiceTest {

	// To identify 94200-94299 94201-94399
	@Test
	public void testFo94200_94299And94201_94399() {
		ZipCodeService service = new ZipCodeService();

		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		ZipCodeRange range2 = new ZipCodeRange(94201, 94399);
		zipCodeRanges.add(range1);
		zipCodeRanges.add(range2);

		List<ZipCodeRange> evaluateIntervals = service.evaluateIntervals(zipCodeRanges);
		assertEquals(1, evaluateIntervals.size());
		assertEquals(94399, evaluateIntervals.get(0).getMax());
	}

	// To identify 94200-94299 94226-94399
	@Test
	public void testFo94200_94299And94226_94399() {
		ZipCodeService service = new ZipCodeService();

		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		ZipCodeRange range2 = new ZipCodeRange(94226, 94399);
		zipCodeRanges.add(range1);
		zipCodeRanges.add(range2);

		List<ZipCodeRange> evaluateIntervals = service.evaluateIntervals(zipCodeRanges);
		assertEquals(1, evaluateIntervals.size());
		assertEquals(94399, evaluateIntervals.get(0).getMax());
	}

	// To identify 94200-94299 94226-94399
	@Test
	public void testFo94200_94299And94301_94399() {
		ZipCodeService service = new ZipCodeService();

		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		ZipCodeRange range2 = new ZipCodeRange(94301, 94399);
		zipCodeRanges.add(range1);
		zipCodeRanges.add(range2);

		List<ZipCodeRange> evaluateIntervals = service.evaluateIntervals(zipCodeRanges);
		assertEquals(2, evaluateIntervals.size());
		assertEquals(94299, evaluateIntervals.get(0).getMax());
		assertEquals(94399, evaluateIntervals.get(1).getMax());
	}
	
	@Test
	public void testValidZipCodeToShip() {
		ZipCodeService service = new ZipCodeService();

		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		ZipCodeRange range2 = new ZipCodeRange(94301, 94399);
		zipCodeRanges.add(range1);
		zipCodeRanges.add(range2);
		
		assertTrue(service.validZipCode(94300, zipCodeRanges));
	}
	
	@Test
	public void testInValidZipCodeToShip() {
		ZipCodeService service = new ZipCodeService();

		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		ZipCodeRange range2 = new ZipCodeRange(94301, 94399);
		zipCodeRanges.add(range1);
		zipCodeRanges.add(range2);
		
		assertFalse(service.validZipCode(94200, zipCodeRanges));
		assertFalse(service.validZipCode(94299, zipCodeRanges));
		assertFalse(service.validZipCode(94250, zipCodeRanges));
		assertFalse(service.validZipCode(94399, zipCodeRanges));
	}

}
