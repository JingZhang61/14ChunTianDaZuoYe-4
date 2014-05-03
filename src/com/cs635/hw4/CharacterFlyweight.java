package com.cs635.hw4;

import java.awt.Font;

public class CharacterFlyweight implements FlyweightInterface {

	private char character;

	public CharacterFlyweight(Character c) {
		character = c;
	}

	@Override
	public Character getCharacter() {
		// TODO Auto-generated method stub
		return character;
	}

	@Override
	public void write(Font f) {
		// TODO Auto-generated method stub
		
		
		

	}
}
