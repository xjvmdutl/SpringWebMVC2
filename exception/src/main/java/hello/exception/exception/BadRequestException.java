package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") //400 코드로 변경
public class BadRequestException extends RuntimeException{
    //ResponseStatusResolver에서 잡아서 상태코드를 변경해 준다
    //내부적으로 response.sendError(code, reason)으로 호출뒤 정상 호출을 반환한다.
}
