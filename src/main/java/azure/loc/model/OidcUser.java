package azure.loc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OidcUser {

    private String email;
    private String givenName;
    private String familyName;

}
