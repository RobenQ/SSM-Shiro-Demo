package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    public User selectUserByUserName(@Param("userName") String userName);
    public User selectAll();
    public String selectPermsByUserName(@Param("userName") String userName);
}
