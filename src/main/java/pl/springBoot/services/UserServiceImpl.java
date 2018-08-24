package pl.springBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.springBoot.dao.UserDao;
import pl.springBoot.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean deleteUser(long id) {
        User user = userDao.find(id);
        if (user != null) {
            userDao.delete(id);
            System.out.println("User: " + user.getName() + " with email: " + user.getEmail() + " deleted successfully");
            return true;
        }
        return false;
    }
}
