package mapper;

import bean.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {

    public List<Admin> selectAdmin();
}
