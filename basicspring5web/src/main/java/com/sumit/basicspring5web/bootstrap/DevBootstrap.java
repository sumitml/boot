package com.sumit.basicspring5web.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sumit.basicspring5web.model.Author;
import com.sumit.basicspring5web.model.Book;
import com.sumit.basicspring5web.model.Publisher;
import com.sumit.basicspring5web.repositories.AuthorRepository;
import com.sumit.basicspring5web.repositories.BookRepository;
import com.sumit.basicspring5web.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
	//	super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
		
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("Wrox");
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design","1234",publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2ee","23444",publisher);
		rod.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

}
