package li.moskito.inkstand.ldap.ads;

import javax.enterprise.inject.Produces;

import org.apache.directory.server.core.api.DirectoryService;

public class ApacheDirectoryServerProvider {

    @Produces
    public DirectoryService getDirectoryService() {
        return null;
    }
}
