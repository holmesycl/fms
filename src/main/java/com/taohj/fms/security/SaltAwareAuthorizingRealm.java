package com.taohj.fms.security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.model.RolePermission;
import com.taohj.fms.model.User;
import com.taohj.fms.model.UserPwdSalt;
import com.taohj.fms.model.UserRole;
import com.taohj.fms.service.RolePermissionService;
import com.taohj.fms.service.UserPwdSaltService;
import com.taohj.fms.service.UserRoleService;
import com.taohj.fms.service.UserService;

public class SaltAwareAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private UserPwdSaltService userPwdSaltService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RolePermissionService rolePermissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获取用户角色
		List<UserRole> userRoles = userRoleService.selectRoleByUsername(username);
		if (!CollectionUtils.isEmpty(userRoles)) {
			for (UserRole userRole : userRoles) {
				String roleCode = userRole.getRoleCode();
				info.addRole(roleCode);
				// 获取用户权限
				List<RolePermission> rolePermissions = rolePermissionService.selectPermissionByRole(roleCode);
				if (!CollectionUtils.isEmpty(rolePermissions)) {
					for (RolePermission rolePermission : rolePermissions) {
						info.addStringPermission(rolePermission.getPermissionCode());
					}
				}
			}
		}
		return info;
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
