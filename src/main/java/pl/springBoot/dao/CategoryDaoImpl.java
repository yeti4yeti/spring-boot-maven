package pl.springBoot.dao;

import org.springframework.stereotype.Component;
import pl.springBoot.domain.Category;

@Component("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
}
