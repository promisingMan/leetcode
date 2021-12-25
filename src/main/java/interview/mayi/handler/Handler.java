package interview.mayi.handler;

import interview.mayi.TablePrivilegeGrantor;
import interview.mayi.strategy.GrantStrategy;

/**
 * @author zengjia
 * @date 2021-12-07 09:54:36
 */
public interface Handler {
    /**
     * 获取授权策略
     *
     * @param application
     * @return null:当前处理器不能获取到授权策略，转交给下一个处理器处理
     */
    GrantStrategy handle(TablePrivilegeGrantor.PrivilegeApplication application);
}
