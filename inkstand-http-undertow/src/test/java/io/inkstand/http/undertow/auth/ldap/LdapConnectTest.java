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

package io.inkstand.http.undertow.auth.ldap;

import static org.junit.Assert.fail;

import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.junit.Ignore;
import org.junit.Test;

public class LdapConnectTest {

    @Test
    @Ignore
    public void test() throws Exception {

        final LdapConnection connection = new LdapNetworkConnection("localhost", 10389);
        connection.bind("uid=admin,ou=system", "secret");

        final EntryCursor result = connection.search("ou=users,ou=system", "(uid=user1)", SearchScope.SUBTREE);

        if (result.next()) {
            final Entry user = result.get();
            System.out.println(user);
        } else {
            fail("User not found");

        }

        connection.unBind();
        connection.close();

    }

}
