package com.cs635.hw4;

import java.util.LinkedList;
import java.util.List;

/**
 * RunArray class used to keep track of runs in a sequence
 * 
 * @author Shu Zhao
 * 
 */
public class RunArray<T> {

	/**
	 * Inner class to represent a RunArray element
	 */
	private class RunArrayEntry {
		int startIdx;
		int endIdx;
		T font;

		public RunArrayEntry(int start, int end, T f) {
			this.startIdx = start;
			this.endIdx = end;
			this.font = f;
		}

		public void setStartIdx(int start) {
			this.startIdx = start;
		}

		public void setEndIdx(int end) {
			this.endIdx = end;
		}
	}

	private List<RunArrayEntry> runArray;

	public RunArray() {
		runArray = new LinkedList<RunArrayEntry>();
	}

	/**
	 * Get the object at a specific location
	 * 
	 * @param index
	 *            the index to look for
	 * @return the object at index, or null if index is out of bounds
	 */
	public T atRun(int index) {
		RunArrayEntry entry;
		for (int i = 0; i < runArray.size(); i++) {
			entry = runArray.get(i);
			if (index >= entry.startIdx && index <= entry.endIdx) {
				return entry.font;
			}
		}
		return null;
	}

	/**
	 * Append a new font run to the end of RunArray
	 * 
	 * @param font
	 *            the object to append
	 * @param length
	 *            the length of this run
	 * @return the index of the new font run
	 */
	public int appendRun(T font, int length) {
		if (runArray.size() == 0) {
			// First element
			runArray.add(0, new RunArrayEntry(0, length - 1, font));
		} else {
			// Append new font at the end of the list
			RunArrayEntry lastEntry = runArray.get(runArray.size() - 1);
			RunArrayEntry newEntry = new RunArrayEntry(lastEntry.endIdx + 1,
					lastEntry.endIdx + length, font);
			runArray.add(newEntry);
		}
		return runArray.size() - 1;
	}

	/**
	 * Add a new font run into the RunArray
	 * 
	 * @param start
	 *            the start position
	 * @param length
	 *            the lenght of this run
	 * @param font
	 *            the object to add
	 * @return the index of the start of the new font run
	 */
	public int addRun(int start, int length, T font) {
		int end = start + length - 1;
		RunArrayEntry newEntry = new RunArrayEntry(start, end, font);

		if (runArray.size() == 0) {
			// Empty runArray
			runArray.add(newEntry);
			return 0;
		}

		// Find position of new entry
		int previousEntryIdx = -1;
		int nextEntryIdx = -1;
		List<Integer> toDeleteList = new LinkedList<Integer>();
		for (int i = 0; i < runArray.size(); i++) {
			if (runArray.get(i).startIdx < start) {
				// New entry start index falls into the existing entry. Record
				// this entry
				previousEntryIdx = i;
			} else if (runArray.get(i).endIdx <= end) {
				// Entry within start and end range will be overwritten
				toDeleteList.add(i);
			}
			if (runArray.get(i).endIdx > end) {
				// New entry end index falls into the existing entry. Record
				// this entry
				nextEntryIdx = i;
				break;
			}
		}

		if (previousEntryIdx != -1) {
			// Previous entry's end index needs update
			runArray.get(previousEntryIdx).setEndIdx(start - 1);
		}

		if (nextEntryIdx != -1) {
			// Next entry's start index needs update
			runArray.get(nextEntryIdx).setStartIdx(end + 1);
		}

		for (int i = toDeleteList.size() - 1; i >= 0; i--) {
			runArray.remove(toDeleteList.get(i));
		}

		// Insert new entry behind previous entry
		runArray.add(previousEntryIdx + 1, newEntry);
		return previousEntryIdx + 1;

	}
}
