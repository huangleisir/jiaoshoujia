package com.jst.demo.dao.test1;

import com.jst.demo.bean.User;
import com.jst.demo.dao.base.AbstractDao;
import com.jst.demo.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDao
  extends AbstractDao
{
  private final String MAPPER_NAMESPACE = "User.";
  
  public User selectAll()
  {
    return (User)this.baseDao1.getOne("User.".concat("selectAll"), "");
  }
}
