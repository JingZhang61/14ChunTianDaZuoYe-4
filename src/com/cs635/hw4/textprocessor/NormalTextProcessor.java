package com.cs635.hw4.textprocessor;

import java.awt.Font;
import com.cs635.hw4.SampleText;

/**
 * A normal text processor: all character objects are stored with all their
 * state (intrinsic and extrinsic)
 */
public class NormalTextProcessor implements TextProcessor {
	NormalTextCharacter[] savedText;

	private class NormalTextCharacter {
		char unicode;
		Font font;

		NormalTextCharacter(char c, Font f) {
			this.unicode = c;
			this.font = f;
		}
	}

	@Override
	public void storeSampleText() {
		this.savedText = new NormalTextCharacter[SampleText.TEXT.length()];
		for (int i = 0; i < SampleText.TEXT.length(); i++) {
			if (i < SampleText.FIRST_RUN) {
				this.savedText[i] = new NormalTextCharacter(
						SampleText.TEXT.charAt(i),
						new Font(SampleText.FONT_A_NAME,
								SampleText.FONT_A_STYLE, SampleText.FONT_A_SIZE));
			} else {
				this.savedText[i] = new NormalTextCharacter(
						SampleText.TEXT.charAt(i),
						new Font(SampleText.FONT_B_NAME,
								SampleText.FONT_B_STYLE, SampleText.FONT_B_SIZE));
			}
		}
	}

	@Override
	public char charAt(int index) throws IndexOutOfBoundsException {
		if (savedText == null)
			throw new IndexOutOfBoundsException("No saved text");
		if (index < 0 || index >= savedText.length)
			throw new IndexOutOfBoundsException("Invalid Index:" + index);
		return savedText[index].unicode;

	}

	@Override
	public Font fontAt(int index) throws IndexOutOfBoundsException {
		if (savedText == null)
			throw new IndexOutOfBoundsException("No saved text");
		if (index < 0 || index >= savedText.length)
			throw new IndexOutOfBoundsException("Invalid Index:" + index);
		return savedText[index].font;
	}
}
