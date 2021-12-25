package interview.mayi.strategy;

import interview.mayi.TablePrivilegeGrantor;

/**
 * @author zengjia
 * @date 2021-12-06 21:00:40
 */
public interface GrantStrategy {
    /**
     * 执行授权
     *
     * @param application
     */
    void doGrant(TablePrivilegeGrantor.PrivilegeApplication application);
}
