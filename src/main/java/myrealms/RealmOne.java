package myrealms;

import bean.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import serviceImpl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RealmOne extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public String getName() {
        return "realmone";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权");
        String user = principals.getPrimaryPrincipal().toString();
        String perms = userService.selectPermsByUserName(user);
        List<String> permsList = new ArrayList<>();
        permsList.add(perms);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permsList);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        String userName = (String) token.getPrincipal();
        if(userName==null){
            return null;
        }
        User user = userService.selectUserByUserName(userName);
        if (user != null) {
            System.out.println(user.toString());
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),this.getName());
            return simpleAuthenticationInfo;
        }else
            return null;
    }
}
