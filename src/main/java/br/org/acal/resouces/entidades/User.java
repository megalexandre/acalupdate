/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "user")

public class User implements Serializable {
    @Basic(optional = false)
    @Column(name = "Select_priv")
    private String selectpriv;
    @Basic(optional = false)
    @Column(name = "Insert_priv")
    private String insertpriv;
    @Basic(optional = false)
    @Column(name = "Update_priv")
    private String updatepriv;
    @Basic(optional = false)
    @Column(name = "Delete_priv")
    private String deletepriv;
    @Basic(optional = false)
    @Column(name = "Create_priv")
    private String createpriv;
    @Basic(optional = false)
    @Column(name = "Drop_priv")
    private String droppriv;
    @Basic(optional = false)
    @Column(name = "Reload_priv")
    private String reloadpriv;
    @Basic(optional = false)
    @Column(name = "Shutdown_priv")
    private String shutdownpriv;
    @Basic(optional = false)
    @Column(name = "Process_priv")
    private String processpriv;
    @Basic(optional = false)
    @Column(name = "File_priv")
    private String filepriv;
    @Basic(optional = false)
    @Column(name = "Grant_priv")
    private String grantpriv;
    @Basic(optional = false)
    @Column(name = "References_priv")
    private String referencespriv;
    @Basic(optional = false)
    @Column(name = "Index_priv")
    private String indexpriv;
    @Basic(optional = false)
    @Column(name = "Alter_priv")
    private String alterpriv;
    @Basic(optional = false)
    @Column(name = "Show_db_priv")
    private String showdbpriv;
    @Basic(optional = false)
    @Column(name = "Super_priv")
    private String superpriv;
    @Basic(optional = false)
    @Column(name = "Create_tmp_table_priv")
    private String createtmptablepriv;
    @Basic(optional = false)
    @Column(name = "Lock_tables_priv")
    private String locktablespriv;
    @Basic(optional = false)
    @Column(name = "Execute_priv")
    private String executepriv;
    @Basic(optional = false)
    @Column(name = "Repl_slave_priv")
    private String replslavepriv;
    @Basic(optional = false)
    @Column(name = "Repl_client_priv")
    private String replclientpriv;
    @Basic(optional = false)
    @Column(name = "Create_view_priv")
    private String createviewpriv;
    @Basic(optional = false)
    @Column(name = "Show_view_priv")
    private String showviewpriv;
    @Basic(optional = false)
    @Column(name = "Create_routine_priv")
    private String createroutinepriv;
    @Basic(optional = false)
    @Column(name = "Alter_routine_priv")
    private String alterroutinepriv;
    @Basic(optional = false)
    @Column(name = "Create_user_priv")
    private String createuserpriv;
    @Basic(optional = false)
    @Column(name = "Event_priv")
    private String eventpriv;
    @Basic(optional = false)
    @Column(name = "Trigger_priv")
    private String triggerpriv;
    @Basic(optional = false)
    @Column(name = "Create_tablespace_priv")
    private String createtablespacepriv;
    @Basic(optional = false)
    @Column(name = "ssl_type")
    private String sslType;
    @Basic(optional = false)
    @Column(name = "ssl_cipher")
    private byte[] sslCipher;
    @Basic(optional = false)
    @Column(name = "x509_issuer")
    private byte[] x509Issuer;
    @Basic(optional = false)
    @Column(name = "x509_subject")
    private byte[] x509Subject;
    @Basic(optional = false)
    @Column(name = "max_questions")
    private int maxQuestions;
    @Basic(optional = false)
    @Column(name = "max_updates")
    private int maxUpdates;
    @Basic(optional = false)
    @Column(name = "max_connections")
    private int maxConnections;
    @Basic(optional = false)
    @Column(name = "max_user_connections")
    private int maxUserConnections;
    @Column(name = "plugin")
    private String plugin;
    @Column(name = "authentication_string")
    private String authenticationString;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
 

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    
    public User(String host, String user) {
        this.userPK = new UserPK(host, user);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectpriv() {
        return selectpriv;
    }

    public void setSelectpriv(String selectpriv) {
        this.selectpriv = selectpriv;
    }

    public String getInsertpriv() {
        return insertpriv;
    }

    public void setInsertpriv(String insertpriv) {
        this.insertpriv = insertpriv;
    }

    public String getUpdatepriv() {
        return updatepriv;
    }

    public void setUpdatepriv(String updatepriv) {
        this.updatepriv = updatepriv;
    }

    public String getDeletepriv() {
        return deletepriv;
    }

    public void setDeletepriv(String deletepriv) {
        this.deletepriv = deletepriv;
    }

    public String getCreatepriv() {
        return createpriv;
    }

    public void setCreatepriv(String createpriv) {
        this.createpriv = createpriv;
    }

    public String getDroppriv() {
        return droppriv;
    }

    public void setDroppriv(String droppriv) {
        this.droppriv = droppriv;
    }

    public String getReloadpriv() {
        return reloadpriv;
    }

    public void setReloadpriv(String reloadpriv) {
        this.reloadpriv = reloadpriv;
    }

    public String getShutdownpriv() {
        return shutdownpriv;
    }

    public void setShutdownpriv(String shutdownpriv) {
        this.shutdownpriv = shutdownpriv;
    }

    public String getProcesspriv() {
        return processpriv;
    }

    public void setProcesspriv(String processpriv) {
        this.processpriv = processpriv;
    }

    public String getFilepriv() {
        return filepriv;
    }

    public void setFilepriv(String filepriv) {
        this.filepriv = filepriv;
    }

    public String getGrantpriv() {
        return grantpriv;
    }

    public void setGrantpriv(String grantpriv) {
        this.grantpriv = grantpriv;
    }

    public String getReferencespriv() {
        return referencespriv;
    }

    public void setReferencespriv(String referencespriv) {
        this.referencespriv = referencespriv;
    }

    public String getIndexpriv() {
        return indexpriv;
    }

    public void setIndexpriv(String indexpriv) {
        this.indexpriv = indexpriv;
    }

    public String getAlterpriv() {
        return alterpriv;
    }

    public void setAlterpriv(String alterpriv) {
        this.alterpriv = alterpriv;
    }

    public String getShowdbpriv() {
        return showdbpriv;
    }

    public void setShowdbpriv(String showdbpriv) {
        this.showdbpriv = showdbpriv;
    }

    public String getSuperpriv() {
        return superpriv;
    }

    public void setSuperpriv(String superpriv) {
        this.superpriv = superpriv;
    }

    public String getCreatetmptablepriv() {
        return createtmptablepriv;
    }

    public void setCreatetmptablepriv(String createtmptablepriv) {
        this.createtmptablepriv = createtmptablepriv;
    }

    public String getLocktablespriv() {
        return locktablespriv;
    }

    public void setLocktablespriv(String locktablespriv) {
        this.locktablespriv = locktablespriv;
    }

    public String getExecutepriv() {
        return executepriv;
    }

    public void setExecutepriv(String executepriv) {
        this.executepriv = executepriv;
    }

    public String getReplslavepriv() {
        return replslavepriv;
    }

    public void setReplslavepriv(String replslavepriv) {
        this.replslavepriv = replslavepriv;
    }

    public String getReplclientpriv() {
        return replclientpriv;
    }

    public void setReplclientpriv(String replclientpriv) {
        this.replclientpriv = replclientpriv;
    }

    public String getCreateviewpriv() {
        return createviewpriv;
    }

    public void setCreateviewpriv(String createviewpriv) {
        this.createviewpriv = createviewpriv;
    }

    public String getShowviewpriv() {
        return showviewpriv;
    }

    public void setShowviewpriv(String showviewpriv) {
        this.showviewpriv = showviewpriv;
    }

    public String getCreateroutinepriv() {
        return createroutinepriv;
    }

    public void setCreateroutinepriv(String createroutinepriv) {
        this.createroutinepriv = createroutinepriv;
    }

    public String getAlterroutinepriv() {
        return alterroutinepriv;
    }

    public void setAlterroutinepriv(String alterroutinepriv) {
        this.alterroutinepriv = alterroutinepriv;
    }

    public String getCreateuserpriv() {
        return createuserpriv;
    }

    public void setCreateuserpriv(String createuserpriv) {
        this.createuserpriv = createuserpriv;
    }

    public String getEventpriv() {
        return eventpriv;
    }

    public void setEventpriv(String eventpriv) {
        this.eventpriv = eventpriv;
    }

    public String getTriggerpriv() {
        return triggerpriv;
    }

    public void setTriggerpriv(String triggerpriv) {
        this.triggerpriv = triggerpriv;
    }

    public String getCreatetablespacepriv() {
        return createtablespacepriv;
    }

    public void setCreatetablespacepriv(String createtablespacepriv) {
        this.createtablespacepriv = createtablespacepriv;
    }

    public String getSslType() {
        return sslType;
    }

    public void setSslType(String sslType) {
        this.sslType = sslType;
    }

    public byte[] getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public byte[] getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public int getMaxUpdates() {
        return maxUpdates;
    }

    public void setMaxUpdates(int maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMaxUserConnections() {
        return maxUserConnections;
    }

    public void setMaxUserConnections(int maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }

}