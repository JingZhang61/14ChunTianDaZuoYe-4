package com.cs635.hw4.textprocessor;

import java.awt.Font;

/**
 * Interface defines behaviors of a text processor
 * 
 * @author Shu Zhao
 */
public interface TextProcessor {

	/**
	 * Store the sample text
	 */
	public void storeSampleText();

	/**
	 * Returns the char value at the specified index. An index ranges from 0 to
	 * length() - 1. The first char value of the sequence is at index 0, the
	 * next at index 1, and so on, as for array indexing.
	 * 
	 * @param index
	 *            the index of the char value
	 * @return the char value at the specified index of this text processor. The
	 *         first char value is at index 0.
	 * @throws: IndexOutOfBoundsException - if the index argument is negative or
	 *          not less than the length of this text processor.
	 */
	public char charAt(int index) throws IndexOutOfBoundsException;

	/**
	 * Returns the Font object at the specified index. An index ranges from 0 to
	 * length() - 1. The first Font object of the sequence is at index 0, the
	 * next at index 1, and so on, as for array indexing.
	 * 
	 * @param index
	 *            the index of the Font object
	 * @return the Font object at the specified index of this text processor.
	 *         The first Font object is at index 0.
	 * @throws: IndexOutOfBoundsException - if the index argument is negative or
	 *          not less than the length of this text processor.
	 */
	public Font fontAt(int index) throws IndexOutOfBoundsException;
}
