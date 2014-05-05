package com.cs635.hw4;

import java.awt.Font;
import java.util.LinkedList;

public class RunArray {
	private static LinkedList<Font> fontArray;
	private static LinkedList<Integer> runArray;
	
	public RunArray(){
		fontArray = new LinkedList<Font> ();
		runArray = new LinkedList<Integer> ();
	}
	
	public void addRun(int start, int length, Font font) {
		int end = start + length;
		Font startIndexFont = atRun(start);
		Font endIndexFont = atRun(end);
		
		if ((startIndexFont == font) && (endIndexFont == font)) {
			
		}
		else if ((startIndexFont == font) && (endIndexFont != font)) {
			
		}
		else if ((startIndexFont !=font) && (endIndexFont == font)) {
			
		}
		else {
			
		}
	}

	public Font atRun(int index) {
		int sum = 0;
		for (int i = 0; i< (runArray.size()-2); i++) {
			sum = sum + runArray.get(i);
			if((sum<index)&&(sum+runArray.get(i+1)>=index)) {
				return fontArray.get(i+1);
			}
		}
		return null;
	}

	public void appendRun(Font f, int length) {
		if(fontArray.get(runArray.size()) == f) {
			runArray.set(runArray.size(), runArray.get(runArray.size()) + length);
		}
		else {
			fontArray.add(f);
			runArray.add(length);
		}
	}
}
