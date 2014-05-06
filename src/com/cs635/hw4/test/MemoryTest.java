package com.cs635.hw4.test;

import java.awt.Font;
import java.io.IOException;
import java.util.BitSet;

import com.cs635.hw4.SampleText;
import com.cs635.hw4.main.FlyweightTextProcessor;
import com.cs635.hw4.main.NormalTextProcessor;

import junit.framework.TestCase;

public class MemoryTest extends TestCase {

	public void test() {
		assertEquals(4.0, new SizeofUtil() {
			int[] array;

			@Override
			protected int create() {
				array = new int[1024];
				return array.length;
			}
		}.averageBytes(), 0.02);

		assertEquals(1.0 / 8, new SizeofUtil() {
			BitSet bits;

			@Override
			protected int create() {
				bits = new BitSet(1024 * 1024);
				return bits.size();
			}
		}.averageBytes(), 1e-4);
	}

	public void testNormal() {
		System.out.println(new SizeofUtil() {
			@Override
			protected int create() {
				NormalTextProcessor processor = new NormalTextProcessor();
				processor.storeSampleText();
				return SampleText.TEXT.length();
			}
		}.averageBytes());

		System.out.println(new SizeofUtil() {
			@Override
			protected int create() {
				FlyweightTextProcessor processor = new FlyweightTextProcessor();
				processor.storeSampleText();
				return SampleText.TEXT.length();
			}
		}.averageBytes());
	}
}
