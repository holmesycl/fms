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

public class SaltAwareAuthorizingRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		String password = "L43lTuXVXrksx1pvTArLDPyqG0aC7RDTdBqmQJ2e++w=";
		String salt = "1490093510324";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(salt));
		return info;
	}

}
