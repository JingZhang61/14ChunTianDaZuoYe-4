package com.cs635.hw4;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewRunArray {

	private class RunArrayEntry {
		int startIdx;
		int endIdx;
		Font font;

		public RunArrayEntry(int start, int end, Font f) {
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

		@Override
		public String toString() {
			return String.format("From %d to %d is Font", startIdx, endIdx,
					font.getName());
		}
	}

	public List<RunArrayEntry> runArray;

	public NewRunArray() {
		runArray = new LinkedList<RunArrayEntry>();
	}

	public Font atRun(int index) {
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
	 * @param length
	 * @return the index of the new font run
	 */
	public int appendRun(Font font, int length) {
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
	 * @param length
	 * @param font
	 * @return the index of the new font run
	 */
	public int addRun(int start, int length, Font font) {
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
		
		for (int i = toDeleteList.size() - 1; i >=0; i--) {
			runArray.remove(toDeleteList.get(i));
		}
		
		// Insert new entry behind previous entry
		runArray.add(previousEntryIdx + 1, newEntry);
		return previousEntryIdx + 1;

	}
}
