package com.cs635.hw4.test;

import com.cs635.hw4.SampleText;
import com.cs635.hw4.textprocessor.FlyweightTextProcessor;
import com.cs635.hw4.textprocessor.NormalTextProcessor;
import com.cs635.hw4.textprocessor.TextProcessor;

import junit.framework.TestCase;

/**
 * Compare memory use between normal text processor and flyweight processor
 * 
 * @author Shu Zhao
 * 
 */
public class MemoryTest extends TestCase {

	/**
	 * Test using SizeOfUtil tool, to calculate average memory cost for each
	 * character
	 */
	public void testWithSizeOfUtil() {
		System.out.println("In normal text processor, Each character costs "
				+ new SizeofUtil() {

					@Override
					protected int create() {
						TextProcessor processor = new NormalTextProcessor();
						processor.storeSampleText();
						return SampleText.TEXT.length();
					}
				}.averageBytes() + " bytes");

		System.out.println("In normal text processor, Each character costs "
				+ new SizeofUtil() {
					@Override
					protected int create() {
						TextProcessor processor = new FlyweightTextProcessor();
						processor.storeSampleText();
						return SampleText.TEXT.length();
					}
				}.averageBytes() + " bytes");
	}

	/**
	 * Test total memory cost by directly reading memory cost in JVM
	 */
	public void testTotalMemory() {
		final Runtime runtime = Runtime.getRuntime();
		long startMemory, endMemory, normalMemory, flyweightMemory;
		TextProcessor normalProcessor, flyweightProcessor;

		// Normal Processor memory
		startMemory = runtime.totalMemory() - runtime.freeMemory();
		normalProcessor = new NormalTextProcessor();
		normalProcessor.storeSampleText();
		endMemory = runtime.totalMemory() - runtime.freeMemory();
		normalMemory = endMemory - startMemory;

		System.out.println("Normal Memory: " + normalMemory);

		// Flyweight Processor memory
		startMemory = runtime.totalMemory() - runtime.freeMemory();
		flyweightProcessor = new FlyweightTextProcessor();
		flyweightProcessor.storeSampleText();
		endMemory = runtime.totalMemory() - runtime.freeMemory();
		flyweightMemory = endMemory - startMemory;

		System.out.println("Flyweight Memory: " + flyweightMemory);

		// Verify two processor store same text, i.e character and font are same
		for (int i = 0; i < SampleText.TEXT.length(); i++) {
			assertEquals(normalProcessor.charAt(i),
					flyweightProcessor.charAt(i));
			assertTrue(normalProcessor.fontAt(i).equals(
					flyweightProcessor.fontAt(i)));
		}
	}
}
