package hello.exception.exhandler.advice;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "hello.exception.api")
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST) //해당 어노테이션을 붙여서 상태코드를 원하는 값으로 반환해 줄수 있다
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalException(IllegalArgumentException e) {
        //ExceptionHandlerExceptionResolver가 컨트롤러를 뒤져 해당 어노테이션이 있는지를 찾아서 해당 메소드를 호출해 준다.
        log.error("[exceptionHandler] ex", e);
        //해당 흐름을 찾아 정상 흐름으로 반환해 준다 -> 200 이 반환 된다.
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) { //똑같을 경우 어노테이션 속성값 생략가능
        log.error("[exceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(
        Exception e) {  //자식 에외를 모두 잡기 때문에 Exception을 잡게된다면 잡지않은 공통의 예외를 모두 잡아준다
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }
}
