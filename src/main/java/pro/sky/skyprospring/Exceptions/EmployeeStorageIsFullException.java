package pro.sky.skyprospring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeStorageIsFullException extends RuntimeException{
}
