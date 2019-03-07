package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface AlbumDirectory extends CrudRepository<Album, Long> {
}
