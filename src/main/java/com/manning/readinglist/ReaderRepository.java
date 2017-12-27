package com.manning.readinglist;

/**
 * @author SungHoon, Park
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {

}
