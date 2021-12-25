package interview.mayi.strategy.impl;

import interview.mayi.TablePrivilegeGrantor;
import interview.mayi.strategy.GrantStrategy;

/**
 * @author zengjia
 * @date 2021-12-06 21:05:46
 */
public class ACLStrategy implements GrantStrategy {
    @Override
    public void doGrant(TablePrivilegeGrantor.PrivilegeApplication application) {
        System.out.println("使用ACL赋权给"
                + "账号" + application.getPrincipalAccount()
                + "表" + application.getTableName() + "的权限");
    }
}
