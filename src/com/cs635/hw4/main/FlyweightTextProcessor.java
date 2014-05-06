package com.cs635.hw4.main;

import java.util.ArrayList;

import com.cs635.hw4.CharacterFlyweightFactory;
import com.cs635.hw4.FontFlyweightFactory;
import com.cs635.hw4.NewRunArray;
import com.cs635.hw4.RunArray;
import com.cs635.hw4.SampleText;
import com.cs635.hw4.CharacterFlyweight;

public class FlyweightTextProcessor {

	private CharacterFlyweightFactory charFactory;
	private FontFlyweightFactory fontFactory;

	public FlyweightTextProcessor() {
		charFactory = CharacterFlyweightFactory.instance();
		fontFactory = FontFlyweightFactory.instance();
	}

	CharacterFlyweight[] savedText;

	public void storeSampleText() {
		savedText = new CharacterFlyweight[SampleText.TEXT.length()];

		NewRunArray runArray = new NewRunArray();
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
}
