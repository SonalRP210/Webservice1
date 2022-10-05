package azure.loc.entity;

import azure.loc.utilities.Utility;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static azure.loc.contants.Constants.SYSTEM_USER;

@Entity
@Audited
@Data
@NoArgsConstructor
@AllArgsConstructor
@OptimisticLocking(type = OptimisticLockType.VERSION)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 4218822717039194857L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Goods_Id")
    private int id;

    @NotNull
    @Column(name = "Goods_Code")
    private String goodsCode;

    @NotNull
    @Column(name = "Goods_Name")
    private String goodsName;

    @NotNull
    @Column(name = "Status")
    private String status;

    @NotNull
    @Column(name = "Comment")
    private String comment;

    @Version
    private long version;

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
        version = 1;
        updatedBy = SYSTEM_USER;
        updatedDate = Utility.getZonedDateTime();
    }
}
