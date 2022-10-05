//package azure.loc.exception;
//
//
//import azure.loc.entity.ExceptionLogger;
//import azure.loc.repository.ExceptionLoggerRepository;
//import azure.loc.utilities.Utility;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.apache.logging.log4j.util.Strings;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Log4j2
//@Component
//@Service
//public class ExceptionHandler {
//
//    @Autowired
//    private ExceptionLoggerRepository exceptionLoggerRepository;
//
////    public ExceptionHandler(ExceptionLoggerRepository exceptionLoggerRepository) {
////        this.exceptionLoggerRepository = exceptionLoggerRepository;
////    }
//
//    /**
//     *
//     * @param input
//     * @param fileName
//     * @param throwable
//     * @param <T>
//     * @throws JsonProcessingException
//     */
//    @Async
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public <T> void logException(T input, String fileName, Throwable throwable) throws JsonProcessingException {
//        String errorMessage = null != throwable.getMessage() ? throwable.getMessage() : Strings.EMPTY;
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(stringWriter);
//        throwable.printStackTrace(printWriter);
//        String stackTrace = stringWriter.toString();
//        String inputJson = input != null ? Utility.convertObjectToJson(input) : Strings.EMPTY;
//
//        ExceptionLogger exceptionLogger = new ExceptionLogger();
//        exceptionLogger.setFileName(fileName);
//        exceptionLogger.setInput(inputJson);
//        exceptionLogger.setErrorMessage(errorMessage);
//        exceptionLogger.setStackTrace(stackTrace);
//
//        exceptionLoggerRepository.save(exceptionLogger);
//    }
//}
