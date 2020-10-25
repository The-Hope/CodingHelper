package cn.xunyard.idea.coding.doc.action;

import cn.xunyard.idea.coding.doc.DocumentBuilderSettings;
import cn.xunyard.idea.coding.doc.dialog.BuilderDialogWrapper;
import cn.xunyard.idea.coding.doc.logic.DocumentBuilderConfiguration;
import cn.xunyard.idea.coding.doc.logic.DocumentBuildingService;
import cn.xunyard.idea.coding.util.ProjectUtils;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

/**
 * desc：
 * 文档生成功能入口
 *
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @author <a herf="mailto:wangxi@terminus.io>Sivin</a>
 * @date 2019-12-15
 */
public class DocumentBuildingAction extends AnAction {
    private DocumentBuilderConfiguration documentBuilderConfiguration = DocumentBuilderSettings.getInstance().getState();

    /**
     * 事件处理器
     *
     * @param event 行为事件
     */
    @Override
    public void actionPerformed(AnActionEvent event) {
        // 从上下文中获取配置信息
        final Project project = event.getProject();
        ProjectUtils.switchProject(project);
        if (documentBuilderConfiguration == null) {
            documentBuilderConfiguration = new DocumentBuilderConfiguration();
            DocumentBuilderSettings.getInstance().loadState(documentBuilderConfiguration);
        }

        // 对话框存在时，再触发后续处理
        BuilderDialogWrapper dialogWrapper = new BuilderDialogWrapper(project, documentBuilderConfiguration);
        if (!dialogWrapper.showAndGet()) {
            return;
        }

        // 执行文档生成行为
        process(documentBuilderConfiguration);
    }

    /**
     * 生成文档
     *
     * @param configuration 文档生成配置
     */
    private void process(DocumentBuilderConfiguration configuration) {
        DocumentBuildingService service = new DocumentBuildingService(configuration);
        service.run();
    }
}
