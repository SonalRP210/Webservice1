//package stub;
//
//import com.microsoft.azure.spring.autoconfigure.aad.UserPrincipal;
//import org.mockito.Mockito;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.mockito.Mockito.when;
//
//public class UserRoleHelper {
//    public static void stubUserRole(String user, String role){
//        Authentication authentication = Mockito.mock(Authentication.class);
//        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
//        UserPrincipal userPrincipal = Mockito.mock(UserPrincipal.class);
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("preferred_username", user);
//        claims.put("roles", Arrays.asList(role));
//        when(securityContext.getAuthentication()).thenReturn(authentication);
//        when(authentication.getPrincipal()).thenReturn(userPrincipal);
//        when(userPrincipal.getClaims()).thenReturn(claims);
//        SecurityContextHolder.setContext(securityContext);
//
//    }
//}
