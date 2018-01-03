package com.manning.readinglist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SungHoon, Park
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
