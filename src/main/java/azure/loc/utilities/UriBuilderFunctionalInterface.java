package azure.loc.utilities;

import java.net.URI;

/*
returns specific URI which can be used in url to call the rest-api
 */
@FunctionalInterface
public interface UriBuilderFunctionalInterface {
    URI buildUri();
}
