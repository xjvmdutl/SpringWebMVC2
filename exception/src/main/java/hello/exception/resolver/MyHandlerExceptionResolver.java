package hello.exception.resolver;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) {
        try {
            if(ex instanceof  IllegalArgumentException){
                log.info("IllegalArgumentException resolver to 400"); //500에러가 아닌 400에러들 보낸다.
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); //에러를 여기 서 먹구 400에러로 보낸다,
                return new ModelAndView(); //정상적 흐름으로 리턴이 된다.(예외를 먹어버린다)
            }
        }catch (IOException e){
            log.error("resolver ex", e);
        }

        return null;
    }
}
