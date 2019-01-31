package com.zts.dao;

import com.zts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangtusheng
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
