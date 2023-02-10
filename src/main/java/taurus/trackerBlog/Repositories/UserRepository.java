package taurus.trackerBlog.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import taurus.trackerBlog.Models.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{

}