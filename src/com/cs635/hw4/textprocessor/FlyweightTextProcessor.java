package com.cs635.hw4.textprocessor;

import java.awt.Font;

import com.cs635.hw4.CharacterFlyweightFactory;
import com.cs635.hw4.FontFlyweightFactory;
import com.cs635.hw4.RunArray;
import com.cs635.hw4.SampleText;
import com.cs635.hw4.CharacterFlyweight;

/**
 * A text processor implemented in Flyweight Pattern
 * 
 * @author Shu Zhao
 * 
 */
public class FlyweightTextProcessor implements TextProcessor {

	private CharacterFlyweightFactory charFactory;
	private FontFlyweightFactory fontFactory;
	private RunArray<Font> runArray;

	public FlyweightTextProcessor() {
		charFactory = CharacterFlyweightFactory.instance();
		fontFactory = FontFlyweightFactory.instance();
		runArray = new RunArray<Font>();
	}

	CharacterFlyweight[] savedText;

	@Override
	public void storeSampleText() {
		savedText = new CharacterFlyweight[SampleText.TEXT.length()];

		runArray.appendRun(fontFactory.getFont(SampleText.FONT_A_NAME,
				SampleText.FONT_A_STYLE, SampleText.FONT_A_SIZE),
				SampleText.FIRST_RUN);
		runArray.appendRun(fontFactory.getFont(SampleText.FONT_B_NAME,
				SampleText.FONT_B_STYLE, SampleText.FONT_B_SIZE),
				SampleText.SECOND_RUN);

		for (int i = 0; i < SampleText.TEXT.length(); i++) {
			savedText[i] = charFactory.getCharacter(SampleText.TEXT.charAt(i));
		}
	}

	@Override
	public char charAt(int index) throws IndexOutOfBoundsException {
		if (savedText == null)
			throw new IndexOutOfBoundsException("No saved text");
		if (index < 0 || index >= savedText.length)
			throw new IndexOutOfBoundsException("Invalid Index:" + index);
		return savedText[index].getCharacter();
	}

	@Override
	public Font fontAt(int index) throws IndexOutOfBoundsException {
		return runArray.atRun(index);
	}
}
