package notes.mvc.web.resolver;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.response.Code;
import notes.mvc.common.response.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zzy520git
 * @date 2018/7/2.
 * Controller统一异常处理
 */
@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception ex) {
        log.error("GlobalExceptionHandler.error", ex);
        return ResponseResult.errorCodeMsg(Code.CommonCode.Failure, "统一异常处理");
    }
}