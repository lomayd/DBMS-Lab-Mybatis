package lomayd.DBMSLabMybatis.api.domain.user.repository;

import lomayd.DBMSLabMybatis.api.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void save(User user);

    User findById(String id);

    void deleteById(String id);
}
