package interview.mayi.handler;

import interview.mayi.TablePrivilegeGrantor;
import interview.mayi.strategy.GrantEnum;
import interview.mayi.strategy.GrantStrategy;
import interview.mayi.strategy.impl.PackageV3Strategy;

/**
 * @author zengjia
 * @date 2021-12-07 10:19:23
 */
public class PackageV3Handler implements Handler {
    TablePrivilegeGrantor.MetaService metaService;

    @Override
    public GrantStrategy handle(TablePrivilegeGrantor.PrivilegeApplication application) {
        if (!metaService.isAntProject(application.getExecuteProject())) {
            GrantEnum.ACL.doGrant(application);
            return new PackageV3Strategy();
        }
        return null;
    }
}
