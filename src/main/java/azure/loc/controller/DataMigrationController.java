package azure.loc.controller;


import azure.loc.contants.UserRoles;
import azure.loc.processor.DataMigrationProcessor;
import azure.loc.response.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import static azure.loc.contants.ResponseMessage.MIGRATION_SUCCESFUL;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@Log4j2
@RequestMapping
public class DataMigrationController {

    @Autowired
    private DataMigrationProcessor dataMigrationProcessor;

    //@PreAuthorize("hasAnyRole('"+ UserRoles.SUPPORT +"')")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<ServiceResponse> loadData(MultipartFile[] files) throws IOException{
        dataMigrationProcessor.loadData(files);
        return new ResponseEntity<>(new ServiceResponse(MIGRATION_SUCCESFUL), HttpStatus.OK);
    }
}
