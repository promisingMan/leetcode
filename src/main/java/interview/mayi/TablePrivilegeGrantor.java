package interview.mayi;

import interview.mayi.handler.Handler;
import interview.mayi.strategy.GrantStrategy;
import interview.mayi.strategy.impl.*;

import java.util.List;

/**
 * @author zengjia
 * @date 2021-12-06 19:41:46
 */
// 题目3
// 用户要使用数据仓库中的表需要先申请权限，当权限申请通过后，系统会根据审批单中的信息选择最终的赋权方式（ACL赋权、Policy赋权、Package赋权（多个版本））。现有如下模拟赋权行为的代码，完成以下要求：
// 选择合适的设计模式（可以结合多种）重构TablePrivilegeGrantor的grant方法；
// 增加一种新的赋权方式（V3的Package赋权），采用这种赋权方式的前提是“申请单中的执行项目是非蚂蚁项目”。
// 提示：赋权部分的输出语句为简化的业务逻辑，实际上各种赋权方式依赖的服务和实现逻辑有很大区别。
public class TablePrivilegeGrantor {
    // 元数据服务
    private MetaService metaService = new MetaService();

    // 账号服务
    private AccountService accountService = new AccountService();

    // 获取策略责任链列表
    List<Handler> handlerList;

    // 根据申请单给账号赋权
    public void grant(PrivilegeApplication application) {
        GrantStrategy grantStrategy = null;
        for (Handler handler : handlerList) {
            grantStrategy = handler.handle(application);
            if (grantStrategy != null) {
                break;
            }
        }
        if (grantStrategy == null) {
            // throw exception
            return;
        }
        grantStrategy.doGrant(application);
    }

    public GrantStrategy createGrant(PrivilegeApplication application) {
        if (!metaService.isAntProject(application.getExecuteProject())) {
            return new PackageV3Strategy();
        }
        if (metaService.isProtectedProject(application.getExecuteProject())) {
            if (!application.getExecuteProject().equals(application.getApplyProject())
                    && !metaService.isMutualTrust(application.getExecuteProject(), application.getApplyProject())) {
                if (metaService.isPrivacyProject(application.getExecuteProject())) {
                    return new PackageV2Strategy();
                } else {
                    return new PackageV1Strategy();
                }
            }
        }
        if (accountService.isPublicAccount(application.getPrincipalAccount())) {
            return new PolicyStrategy();
        } else {
            if (metaService.isProduct(application.getTableName())) {
                return new ACLStrategy();
            } else {
                return new PolicyStrategy();
            }
        }
    }

    public static class MetaService {
        // 是否是蚂蚁项目
        public boolean isAntProject(String projectName) {
            return projectName.startsWith("ant_");
        }

        // 是否是保护项目
        public boolean isProtectedProject(String projectName) {
            return projectName.endsWith("_protect");
        }

        // 两个项目是否互信
        public boolean isMutualTrust(String projectA, String projectB) {
            return projectA.contains("trust") && projectB.contains("trust");
        }

        // 是否是隐私项目
        public boolean isPrivacyProject(String projectName) {
            return projectName.contains("privacy");
        }

        // 是否是生产表
        public boolean isProduct(String tableName) {
            return !tableName.endsWith("_dev");
        }
    }

    public static class AccountService {
        // 是否是公共账号
        public boolean isPublicAccount(String accountName) {
            return accountName.startsWith("public_");
        }
    }

    public static class PrivilegeApplication {
        // 执行项目
        private final String executeProject;

        // 申请项目
        private final String applyProject;

        // 申请的表
        private final String tableName;

        // 使用账号
        private final String principalAccount;

        public PrivilegeApplication(String executeProject, String applyProject, String tableName, String principalAccount) {
            this.executeProject = executeProject;
            this.applyProject = applyProject;
            this.tableName = tableName;
            this.principalAccount = principalAccount;
        }

        public String getExecuteProject() {
            return executeProject;
        }

        public String getApplyProject() {
            return applyProject;
        }

        public String getTableName() {
            return tableName;
        }

        public String getPrincipalAccount() {
            return principalAccount;
        }
    }
}