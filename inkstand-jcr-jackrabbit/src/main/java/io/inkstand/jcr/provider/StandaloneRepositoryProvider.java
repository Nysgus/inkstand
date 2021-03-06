/*
 * Copyright 2015 Gerald Muecke, gerald.muecke@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.inkstand.jcr.provider;

import java.io.File;

import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;

import io.inkstand.jcr.StandaloneRepository;
import io.inkstand.jcr.RepositoryProvider;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.apache.jackrabbit.core.RepositoryImpl;
import org.apache.jackrabbit.core.config.RepositoryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provider for a JCR {@link Repository} that uses a local repository configuration. The repository home directory is
 * configured using the {@code inque.jcr.home} property, either defined in the inque.properties file or via JVM
 * argument.
 *
 * @author <a href="mailto:gerald@inkstand.io">Gerald M&uuml;cke</a>
 */
@Priority(2)
public class StandaloneRepositoryProvider implements RepositoryProvider {

    /**
     * SLF4J Logger for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(StandaloneRepositoryProvider.class);

    @Inject
    @ConfigProperty(name = "inkstand.jcr.home")
    private String repositoryHome;

    @Inject
    @ConfigProperty(name = "inkstand.jcr.config")
    private String configFile;

    private RepositoryImpl repository;

    @Override
    @Produces
    @StandaloneRepository
    public Repository getRepository() throws RepositoryException {
        if (repository == null) {
            LOG.info("Connecting to local repository at {}", repositoryHome);
            final RepositoryConfig config = RepositoryConfig.create(new File(configFile), new File(repositoryHome));
            repository = RepositoryImpl.create(config);
        }
        return repository;
    }

    @PreDestroy
    public void close(@Disposes final Repository repository) {
        if (repository instanceof RepositoryImpl) {
            ((RepositoryImpl) repository).shutdown();
        }
    }
}
