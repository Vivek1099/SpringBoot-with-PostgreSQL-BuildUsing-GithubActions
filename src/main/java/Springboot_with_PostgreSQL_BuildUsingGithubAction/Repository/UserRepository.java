package Springboot_with_PostgreSQL_BuildUsingGithubAction.Repository;

import Springboot_with_PostgreSQL_BuildUsingGithubAction.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("from User u where u.name=?1")
    User getByUserName(String name);

}
