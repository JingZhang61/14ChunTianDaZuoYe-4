package com.cs635.hw4;

import java.awt.Font;

/**
 * Character flyweight pattern interface, defines the functions of a character
 * flyweight pattern
 * 
 * @author Shu Zhao
 * 
 */
public interface CharacterFlyweightInterface {
	/**
	 * Get the unicode of the flyweight
	 * 
	 * @return the char stored within this flyweight object
	 */
	public char getCharacter();

	/**
	 * Apply the extrinsic state to output this object
	 * 
	 * @param f
	 *            The font in which character is written
	 */
	public void write(Font f);

}
