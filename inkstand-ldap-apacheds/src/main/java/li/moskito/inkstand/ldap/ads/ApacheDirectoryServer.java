package li.moskito.inkstand.ldap.ads;

import javax.inject.Inject;

import li.moskito.inkstand.InkstandRuntimeException;
import li.moskito.inkstand.MicroService;

import org.apache.directory.server.core.api.DirectoryService;

public class ApacheDirectoryServer implements MicroService {

    @Inject
    private DirectoryService service;

    @Override
    public void start() {
        try {
            service.startup();
        } catch (final Exception e) {
            throw new InkstandRuntimeException("Error starting LDAP Service", e);
        }

    }

    @Override
    public void stop() {
        try {
            service.shutdown();
        } catch (final Exception e) {
            throw new InkstandRuntimeException("Error stopping LDAP Service", e);
        }

    }
}
