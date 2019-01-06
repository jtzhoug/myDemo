package com.zjt.config;


import com.zjt.model.MyUserInfo;
import com.zjt.model.SysPermission;
import com.zjt.model.SysRole;
import com.zjt.service.UserInfoService;
import com.zjt.sys.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhou.jingtao
 * @date created in 13:11 2018/9/18
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;



    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从凭证中获取用户名
        System.out.println("开始权限配置");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        MyUserInfo userInfo = (MyUserInfo) principals.getPrimaryPrincipal();

        for (SysRole role: userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p: role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }

        return authorizationInfo;
    }

    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        MyUserInfo userInfo = userInfoService.findByUserName(username);
        // String passworaaa= new Md5Hash("123456",userInfo.getCredentialsSalt(),2).toHex();
        // System.out.println(passworaaa);
        if (userInfo == null) {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes("YWRtaW4=");
        System.out.println(credentialsSalt);
        System.out.println(ByteSource.Util.bytes("YWRtaW4="));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户信息
                userInfo.getPassword(), //密码
                credentialsSalt,
                getName() //realm name
        );
        // authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getCredentialsSalt())); //设置盐

        return authenticationInfo;
    }
}
