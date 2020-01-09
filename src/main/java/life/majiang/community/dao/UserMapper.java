package life.majiang.community.dao;

import life.majiang.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User userLogin(@Param("accountId")String accountId,@Param("userPassword")String userPassword);
}
