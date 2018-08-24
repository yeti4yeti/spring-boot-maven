package pl.springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springBoot.dao.BookDao;
import pl.springBoot.domain.Book;

@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/getbook")
    @ResponseBody
    public Book getBook(@RequestParam("id") long id) {
        Book book = bookDao.find(id);
        return book;
    }
}
