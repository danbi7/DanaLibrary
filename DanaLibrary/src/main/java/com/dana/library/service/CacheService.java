package com.dana.library.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dana.library.domain.Book;

@Service
public class CacheService {

	private Map<String, List<Book>> cache;

	public CacheService() {
		this.cache = new HashMap<>();
	}

	public List<Book> get(String key) {
		return cache.get(key);
	}

	public void put(String key, List<Book> value) {
		cache.put(key, value);
	}

}
