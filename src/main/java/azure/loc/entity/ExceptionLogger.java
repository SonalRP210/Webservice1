package azure.loc.entity;

import azure.loc.utilities.Utility;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static azure.loc.contants.Constants.SYSTEM_USER;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Exception_Logger")
public class ExceptionLogger implements Serializable {

    private static final long serialVersionUID = -8188628842274378677L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Exception_Id")
    private int id;

    @Column(name = "File_Name")
    private String fileName;

    @Column(name = "Input")
    private String input;

    @Column(name = "Error_Message")
    private String errorMessage;

    @Column(name = "StackTrace")
    private String stackTrace;

    @Column(name = "Updated_By")
    private String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updated_Date")
    private ZonedDateTime updatedDate;

    /*
    Following fields will be initialized whenever a record is inserted
     */
    @PrePersist
    public void prePersist(){
        updatedBy = SYSTEM_USER;
        updatedDate = Utility.getZonedDateTime();
    }
}
