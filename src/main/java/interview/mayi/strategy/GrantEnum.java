package interview.mayi.strategy;

import interview.mayi.TablePrivilegeGrantor;

/**
 * @author zengjia
 * @date 2021-12-07 10:34:07
 */
public enum GrantEnum {
    ACL() {
        @Override
        public void doGrant(TablePrivilegeGrantor.PrivilegeApplication application) {
            System.out.println("使用ACL赋权给"
                    + "账号" + application.getPrincipalAccount()
                    + "表" + application.getTableName() + "的权限");
        }
    };


    public abstract void doGrant(TablePrivilegeGrantor.PrivilegeApplication application);
}
