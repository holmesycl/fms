package com.taohj.fms.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.taohj.fms.model.User;
import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserService;

public class SaltAwareAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private UserPwdSaltService userPwdSaltService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		User user = userService.selectByUsername(username);
		if (user == null) {
			throw new AuthenticationException("用户不存在.");
		}
		String password = user.getPassword();

		UserPwdSalt userPwdSalt = userPwdSaltService.selectByUsername(username);
		if (userPwdSalt == null) {
			throw new AuthenticationException("用户不存在.");
		}
		String salt = userPwdSalt.getSalt();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(salt));

		return info;
	}

}
