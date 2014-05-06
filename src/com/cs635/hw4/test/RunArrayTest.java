package com.cs635.hw4.test;

import java.awt.Font;
import com.cs635.hw4.NewRunArray;

import junit.framework.TestCase;

public class RunArrayTest extends TestCase {

	final Font fontA = new Font("Courier", Font.BOLD, 12);
	final Font fontB = new Font("TimesRoman", Font.PLAIN, 10);
	final Font fontC = new Font("TimesRoman", Font.ITALIC, 14);

	public void testAppend() {
		NewRunArray runArray = new NewRunArray();

		// Empty runArray
		assertNull(runArray.atRun(0));

		// Append three fonts respectively
		// 0-9 is fontA, 10-19 is fontB, 20-39 is font C
		assertEquals(0, runArray.appendRun(fontA, 10));
		assertEquals(1, runArray.appendRun(fontB, 10));
		assertEquals(2, runArray.appendRun(fontC, 20));

		// Verify font
		for (int i = 0; i < 10; i++) {
			assertEquals(fontA, runArray.atRun(i));
		}
		for (int i = 10; i < 20; i++) {
			assertEquals(fontB, runArray.atRun(i));
		}
		for (int i = 20; i < 30; i++) {
			assertEquals(fontC, runArray.atRun(i));
		}
	}

	public void testAdd() {
		NewRunArray runArray = new NewRunArray();

		// First add fontC for characters 200-259
		assertEquals(0, runArray.addRun(200, 60, fontC));
		// Verify font
		for (int i = 200; i < 260; i++) {
			assertEquals(fontC, runArray.atRun(i));
		}

		// Add fontA for characters 0-99
		assertEquals(0, runArray.addRun(0, 100, fontA));
		// Verify font
		for (int i = 0; i < 100; i++) {
			assertEquals(fontA, runArray.atRun(i));
		}
		for (int i = 200; i < 260; i++) {
			assertEquals(fontC, runArray.atRun(i));
		}

		// Add fontB for characters 50-249. It should be after fontA
		assertEquals(1, runArray.addRun(50, 200, fontB));
		// Verify font, 0-49 is fontA, 50-249 is fontB, 250-259 is fontC
		for (int i = 0; i < 50; i++) {
			assertEquals(fontA, runArray.atRun(i));
		}
		for (int i = 50; i < 250; i++) {
			assertEquals(fontB, runArray.atRun(i));
		}
		for (int i = 250; i < 260; i++) {
			assertEquals(fontC, runArray.atRun(i));
		}
	}

	public void testAdd2() {
		NewRunArray runArray = new NewRunArray();
		int i;
		// Add 10 fonts for first 100 characters
		for (i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				assertEquals(i, runArray.addRun(i * 10, 10, fontA));
			} else {
				assertEquals(i, runArray.addRun(i * 10, 10, fontB));
			}
		}
		// Verify fonts
		for (i = 0; i < 100; i++) {
			if ((i / 10) % 2 == 0) {
				assertEquals(fontA, runArray.atRun(i));
			} else {
				assertEquals(fontB, runArray.atRun(i));
			}
		}

		// Add fontC for characters 15-84, it should be after 0-10 and 10-14
		assertEquals(2, runArray.addRun(15, 70, fontC));
		// Verify fonts, 0-9 fontA, 10-14 fontB, 15-84 fontC, 85-90 fontA, 90-99
		// fontB
		for (i = 0; i < 10; i++) {
			assertEquals(fontA, runArray.atRun(i));
		}
		for (i = 10; i < 15; i++) {
			assertEquals(fontB, runArray.atRun(i));
		}
		for (i = 15; i < 85; i++) {
			assertEquals(fontC, runArray.atRun(i));
		}
		for (i = 85; i < 90; i++) {
			assertEquals(fontA, runArray.atRun(i));
		}
		for (i = 90; i < 100; i++) {
			assertEquals(fontB, runArray.atRun(i));
		}
	}
}
