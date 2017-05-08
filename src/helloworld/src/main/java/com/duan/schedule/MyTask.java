package com.duan.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.duan.schedule.taskThread.SessionProblem;

/**
 * @author ddp
 * 2017年5月2日 16:11:20
 * 定时器任务管理类
 */
@Component
public class MyTask {

	/**
	 * 关于定时处理多余的HttpSession的线程处理方法入口
	 */
	@Scheduled(cron = "0 0/30 * * * ?")
	public void handleSessionProblem(){
		SessionProblem t=new SessionProblem();
		t.start();
	}
	
}
