package com.cs635.hw4;

import java.awt.Font;
import java.util.HashMap;

/**
 * Flyweight Pattern factory to generate fonts. It follows Singleton pattern
 * 
 * @author Shu Zhao
 * 
 */
public class FontFlyweightFactory {
	private HashMap<String, Font> pool;
	private static FontFlyweightFactory instance = null;

	private FontFlyweightFactory() {
		pool = new HashMap<String, Font>();
	}

	/**
	 * Get the flyweight object for a specific font
	 * 
	 * @param name
	 *            the name of the font
	 * @param style
	 *            the style of the font
	 * @param size
	 *            the size of the font
	 * @return the font object
	 */
	public Font getFont(String name, int style, int size) {
		String key = name + style + size;
		if (!pool.containsKey(key)) {
			pool.put(key, new Font(name, style, size));
		}
		return pool.get(key);
	}

	/**
	 * Get the Singleton instance of the factory
	 * 
	 * @return the singleton instance
	 */
	public static FontFlyweightFactory instance() {
		if (instance == null) {
			instance = new FontFlyweightFactory();
		}
		return instance;
	}
}
