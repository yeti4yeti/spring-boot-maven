package pl.springBoot.dao;

import org.springframework.stereotype.Component;
import pl.springBoot.domain.Book;

@Component("bookDao")
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {

}
