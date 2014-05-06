package com.cs635.hw4;

import java.awt.Font;

public class SampleText {

	public static final String TEXT = String
			.format("CS 635 Advanced Object-Oriented Design & Programming\n"
					+ "Spring Semester, 2014\n"
					+ "Doc 19 Facade & Mediator\n"
					+ "April 24, 2014\n"
					+ "Copyright ©, All rights reserved. 2014 SDSU & Roger Whitney, "
					+ "5500 Campanile Drive, San Diego, CA 92182-7700 USA. OpenContent "
					+ "(http://www.opencontent.org/opl.shtml) license "
					+ "defines the copyright on this document.");
	
	public static final Font FONT_A = new Font("Courier", Font.BOLD, 12);
	public static final Font FONT_B = new Font("TimesRoman", Font.PLAIN, 10);
	
	public static final String FONT_A_NAME = "Courier";
	public static final int FONT_A_STYLE = Font.BOLD;
	public static final int FONT_A_SIZE = 12;
	
	public static final String FONT_B_NAME = "TimesRoman";
	public static final int FONT_B_STYLE = Font.PLAIN;
	public static final int FONT_B_SIZE = 10;
	
	public static final int FIRST_RUN = 115;
	public static final int SECOND_RUN = 211;
}
