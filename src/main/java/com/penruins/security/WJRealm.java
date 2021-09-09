package com.penruins.security;

import com.penruins.community.entity.PO.UserPO;
import com.penruins.community.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class WJRealm extends AuthorizingRealm {
  @Autowired
  private UserService userService;
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
    return s;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    String username = authenticationToken.getPrincipal().toString();
    UserPO userPO = userService.findByUsername(username);
    String passwordInDB = userPO.getPassword();
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,passwordInDB,getName());
    return authenticationInfo;
  }
}
