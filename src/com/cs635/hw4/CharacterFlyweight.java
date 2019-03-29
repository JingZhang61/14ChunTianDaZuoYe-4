package com.cs635.hw4;

import java.awt.Font;

/**
 * Character Flyweight pattern implementation
 * 
 * @author Shu Zhao
 * 
 */
public class CharacterFlyweight implements CharacterFlyweightInterface {

	private char character;

	public CharacterFlyweight(Character c) {
		character = c;
	}

	@Override
	public char getCharacter() {
		// TODO Auto-generated method stub
		return character;
	}

	@Override
	public void write(Font f) {
		// TODO Auto-generated method stub
		
		
		

	}
}
