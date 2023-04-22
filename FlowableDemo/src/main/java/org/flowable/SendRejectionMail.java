package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;


/*
波哥flowable教程，没完成，因为后面是eclipse插件暂时没看完
https://www.bilibili.com/video/BV1gG4y1o7MC/?p=12&spm_id_from=pageDriver&vd_source=3d275c15df5bb27a0e7c2d0667ad260d
* */

public class SendRejectionMail implements JavaDelegate {
    /**
     * 这个一个Flowable中的触发器
     * @param execution
     */
    @Override
    public void execute(DelegateExecution execution) {
        // 触发执行的逻辑  按照我们在流程中的定义应该给被拒绝的员工发送通知的邮件
        System.out.println("不好意思，你的请假申请被拒绝了....安心工作");
    }
}
