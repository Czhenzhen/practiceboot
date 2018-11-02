package com.wisely.highlight_springmvc4;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 定时任务
 *
 * @author changzhenzhen
 * @date 2018-11-02
 */
@Service
public class PushService {

    //DeferredResult在没有得到返回数据之前，
    // DispatcherServlet和所有Filter就会退出Servlet容器线程，
    // 但响应保持打开状态，一旦返回数据有了，
    // 这个DispatcherServlet就会被再次调用并且处理，以异步产生的方式，向请求端返回值。
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    //通过@Scheduled 定时更新DeferredResult
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
