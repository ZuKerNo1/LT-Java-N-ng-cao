package Service;
import dao.UserDao;
import java.sql.SQLException;
import model.User;
import java.util.List;

/**
 *
 * @author tuanta
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public  List<User> getAllUers() throws SQLException{
        return userDao.getAllUsers();
    }
}