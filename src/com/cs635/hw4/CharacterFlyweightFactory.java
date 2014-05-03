package com.cs635.hw4;

import java.util.HashMap;

public class CharacterFlyweightFactory {
	private HashMap<Character, CharacterFlyweight> pool;
	private static CharacterFlyweightFactory instance = null;
	
	private CharacterFlyweightFactory() {
		pool = new HashMap<Character, CharacterFlyweight>();
	}
	
	public CharacterFlyweight getCharacter(char c) {
		if (!pool.containsKey(c)) {
			pool.put(c, new CharacterFlyweight (c));
		}
		return pool.get(c);
	}
	
	public static CharacterFlyweightFactory instance() {
		if (instance == null) {
			instance = new CharacterFlyweightFactory();
		}
		return instance;
	}
}
