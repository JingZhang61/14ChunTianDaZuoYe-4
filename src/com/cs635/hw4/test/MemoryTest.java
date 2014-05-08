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

	public void testMemory() {
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
