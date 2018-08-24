package pl.springBoot.dao;

import org.springframework.stereotype.Component;
import pl.springBoot.domain.User;

@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

}
