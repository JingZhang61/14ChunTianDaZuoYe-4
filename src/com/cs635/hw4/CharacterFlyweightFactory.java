package com.cs635.hw4;

import java.util.HashMap;

/**
 * Flyweight Pattern factory to generate characters. It follows Singleton
 * pattern
 * 
 * @author Shu Zhao
 * 
 */
public class CharacterFlyweightFactory {
	private HashMap<Character, CharacterFlyweight> pool;
	private static CharacterFlyweightFactory instance = null;

	private CharacterFlyweightFactory() {
		pool = new HashMap<Character, CharacterFlyweight>();
	}

	/**
	 * Get the Flyweight object of a character
	 * 
	 * @param c
	 *            the character to retrieve
	 * @return the flyweight object representing this character
	 */
	public CharacterFlyweight getCharacter(char c) {
		if (!pool.containsKey(c)) {
			pool.put(c, new CharacterFlyweight(c));
		}
		return pool.get(c);
	}

	/**
	 * Get the Singleton instance of the factory
	 * 
	 * @return the singleton instance
	 */
	public static CharacterFlyweightFactory instance() {
		if (instance == null) {
			instance = new CharacterFlyweightFactory();
		}
		return instance;
	}
}
