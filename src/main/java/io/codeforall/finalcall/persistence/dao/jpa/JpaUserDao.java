package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.dao.UserDao;
import io.codeforall.finalcall.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao  extends GenericJpaDao<User, Integer> implements UserDao {

    public JpaUserDao() {
        super(User.class);
    }
}