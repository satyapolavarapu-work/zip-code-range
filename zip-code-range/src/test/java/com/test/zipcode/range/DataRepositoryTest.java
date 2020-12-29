package com.test.zipcode.range;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DataRepositoryTest {

	@Test
	public void testNonEmptyZipCodeRanges() throws MinRangeException {
		DataRepository helper = new DataRepository();
		List<ZipCodeRange> zipCodeRangesFromFile = helper.getZipCodeRangesFromFile("input.txt");
		Assert.assertNotNull(zipCodeRangesFromFile);
		Assert.assertTrue(zipCodeRangesFromFile.size() > 0);
	}
	
	@Test(expected = MinRangeException.class)
	public void testForWrongInputFile() throws MinRangeException {
		DataRepository helper = new DataRepository();
		helper.getZipCodeRangesFromFile("input1.txt");
	}
	
	@Test(expected = MinRangeException.class)
	public void testForWrongInputFileContent() throws MinRangeException {
		DataRepository helper = new DataRepository();
		helper.getZipCodeRangesFromFile("errorInput.txt");
	}
	
	@Test(expected = MinRangeException.class)
	public void testForInvalidZipCodes() throws MinRangeException {
		DataRepository helper = new DataRepository();
		helper.getZipCodeRangesFromFile("invalidZipCodes.txt");
	}
	
	@Test
	public void testWritingToOutputFile() throws MinRangeException {
		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange range1 = new ZipCodeRange(94200, 94299);
		zipCodeRanges.add(range1);
		DataRepository helper = new DataRepository();
		Assert.assertNotNull(helper.writeConsolidatedRangeToFile(zipCodeRanges));
	}

}
