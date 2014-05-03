package com.cs635.hw4;

import java.awt.Font;
import java.util.HashMap;

public class FontFlyweightFactory {
	private HashMap<String, Font> pool;
	private static FontFlyweightFactory instance = null;

	private FontFlyweightFactory() {
		pool = new HashMap<String, Font>();
	}

	public Font getFont(String name, int style, int size) {
		String key = name + style + size;
		if (!pool.containsKey(key)) {
			pool.put(key, new Font(name, style, size));
		}
		return pool.get(key);
	}

	public static FontFlyweightFactory instance() {
		if (instance == null) {
			instance = new FontFlyweightFactory();
		}
		return instance;
	}
}
