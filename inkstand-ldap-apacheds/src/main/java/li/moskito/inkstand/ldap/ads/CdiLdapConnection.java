package li.moskito.inkstand.ldap.ads;

import java.io.IOException;
import java.util.List;

import org.apache.directory.api.asn1.util.Oid;
import org.apache.directory.api.ldap.codec.api.BinaryAttributeDetector;
import org.apache.directory.api.ldap.codec.api.LdapApiService;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Modification;
import org.apache.directory.api.ldap.model.entry.ModificationOperation;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.AbandonRequest;
import org.apache.directory.api.ldap.model.message.AddRequest;
import org.apache.directory.api.ldap.model.message.AddResponse;
import org.apache.directory.api.ldap.model.message.BindRequest;
import org.apache.directory.api.ldap.model.message.BindResponse;
import org.apache.directory.api.ldap.model.message.CompareRequest;
import org.apache.directory.api.ldap.model.message.CompareResponse;
import org.apache.directory.api.ldap.model.message.Control;
import org.apache.directory.api.ldap.model.message.DeleteRequest;
import org.apache.directory.api.ldap.model.message.DeleteResponse;
import org.apache.directory.api.ldap.model.message.ExtendedRequest;
import org.apache.directory.api.ldap.model.message.ExtendedResponse;
import org.apache.directory.api.ldap.model.message.ModifyDnRequest;
import org.apache.directory.api.ldap.model.message.ModifyDnResponse;
import org.apache.directory.api.ldap.model.message.ModifyRequest;
import org.apache.directory.api.ldap.model.message.ModifyResponse;
import org.apache.directory.api.ldap.model.message.SearchRequest;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.api.ldap.model.name.Rdn;
import org.apache.directory.api.ldap.model.schema.SchemaManager;
import org.apache.directory.ldap.client.api.LdapConnection;

public class CdiLdapConnection implements LdapConnection {

    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean connect() throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(Entry entry) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public AddResponse add(AddRequest addRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void abandon(int messageId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void abandon(AbandonRequest abandonRequest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void bind() throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void anonymousBind() throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void bind(String name) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void bind(String name, String credentials) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void bind(Dn name) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void bind(Dn name, String credentials) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public BindResponse bind(BindRequest bindRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntryCursor search(Dn baseDn, String filter, SearchScope scope, String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntryCursor search(String baseDn, String filter, SearchScope scope, String... attributes)
            throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchCursor search(SearchRequest searchRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unBind() throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTimeOut(long timeOut) {
        // TODO Auto-generated method stub

    }

    @Override
    public void modify(Dn dn, Modification... modifications) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void modify(String dn, Modification... modifications) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void modify(Entry entry, ModificationOperation modOp) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public ModifyResponse modify(ModifyRequest modRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void rename(String entryDn, String newRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void rename(Dn entryDn, Rdn newRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void rename(String entryDn, String newRdn, boolean deleteOldRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void rename(Dn entryDn, Rdn newRdn, boolean deleteOldRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void move(String entryDn, String newSuperiorDn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void move(Dn entryDn, Dn newSuperiorDn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveAndRename(Dn entryDn, Dn newDn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveAndRename(String entryDn, String newDn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveAndRename(Dn entryDn, Dn newDn, boolean deleteOldRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveAndRename(String entryDn, String newDn, boolean deleteOldRdn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public ModifyDnResponse modifyDn(ModifyDnRequest modDnRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String dn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Dn dn) throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public DeleteResponse delete(DeleteRequest deleteRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean compare(String dn, String attributeName, String value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean compare(String dn, String attributeName, byte[] value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean compare(String dn, String attributeName, Value<?> value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean compare(Dn dn, String attributeName, String value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean compare(Dn dn, String attributeName, byte[] value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean compare(Dn dn, String attributeName, Value<?> value) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public CompareResponse compare(CompareRequest compareRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExtendedResponse extended(String oid) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExtendedResponse extended(String oid, byte[] value) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExtendedResponse extended(Oid oid) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExtendedResponse extended(Oid oid, byte[] value) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExtendedResponse extended(ExtendedRequest extendedRequest) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(String dn) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean exists(Dn dn) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Entry getRootDse() throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry getRootDse(String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(Dn dn) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(String dn) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(Dn dn, String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(Dn dn, Control[] controls, String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(String dn, String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry lookup(String dn, Control[] controls, String... attributes) throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isControlSupported(String controlOID) throws LdapException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> getSupportedControls() throws LdapException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadSchema() throws LdapException {
        // TODO Auto-generated method stub

    }

    @Override
    public SchemaManager getSchemaManager() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LdapApiService getCodecService() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean doesFutureExistFor(int messageId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BinaryAttributeDetector getBinaryAttributeDetector() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBinaryAttributeDetector(BinaryAttributeDetector binaryAttributeDetecter) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSchemaManager(SchemaManager schemaManager) {
        // TODO Auto-generated method stub

    }

}
