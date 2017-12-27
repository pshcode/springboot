package com.manning.readinglist;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import groovy.util.logging.Slf4j;

/**
 * @author SungHoon, Park
 */
@Controller
@RequestMapping("/sample")
@Slf4j
public class ReadingListController {
	Logger log = LoggerFactory.getLogger(ReadingListController.class);

	private ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String readersBooks(Reader reader, Model model) {
		log.debug("debug입니다");
		log.info("info입니다");
		log.error("error입니다");

		List<Book> readingList = readingListRepository.findByReader(reader);

		if (readingList != null) {
			model.addAttribute("books", readingList);
			model.addAttribute("reader", reader);
		}

		return "readingList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToReadingList(Reader reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);

		return "redirect:/";
	}
}
