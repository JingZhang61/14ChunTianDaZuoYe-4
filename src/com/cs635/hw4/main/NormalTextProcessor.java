package com.cs635.hw4.main;

import java.awt.Font;
import java.util.ArrayList;

import com.cs635.hw4.SampleText;

public class NormalTextProcessor {
	NormalTextCharacter[] savedText;

	private class NormalTextCharacter {
		char unicode;
		Font font;

		NormalTextCharacter(char c, Font f) {
			this.unicode = c;
			this.font = f;
		}
	}

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
}
