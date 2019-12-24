package notes.mvc.web.controller;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.response.Code;
import notes.mvc.common.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/index")
    public ResponseResult index() {
        log.warn("开启springboot之旅");
        return ResponseResult.successResult(Code.CommonCode.SUCCESS);
    }
}
