package notes.mvc.web.controller;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.response.Code;
import notes.mvc.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/24 20:05
 * @ see
 * @since
 */
@Slf4j
@RestController
public class IndexController {
    @Value("${env.profile}")
    private String env;

    @RequestMapping("/index")
    public ResponseResult index(HttpServletRequest request, HttpServletResponse response) {
        log.warn("开启springboot之旅, env={},login={}", env, request.getParameter("login"));
        return ResponseResult.successResult(Code.CommonCode.SUCCESS);
    }
}
