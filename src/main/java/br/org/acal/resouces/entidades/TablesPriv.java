/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aliss_000
 */
@Entity
@Table(name = "tables_priv")
@NamedQueries({
    @NamedQuery(name = "TablesPriv.findAll", query = "SELECT t FROM TablesPriv t")})
public class TablesPriv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TablesPrivPK tablesPrivPK;
    @Basic(optional = false)
    @Column(name = "Grantor")
    private String grantor;
    @Basic(optional = false)
    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "Table_priv")
    private String tablepriv;
    @Basic(optional = false)
    @Column(name = "Column_priv")
    private String columnpriv;

    public TablesPriv() {
    }

    public TablesPriv(TablesPrivPK tablesPrivPK) {
        this.tablesPrivPK = tablesPrivPK;
    }

    public TablesPriv(TablesPrivPK tablesPrivPK, String grantor, Date timestamp, String tablepriv, String columnpriv) {
        this.tablesPrivPK = tablesPrivPK;
        this.grantor = grantor;
        this.timestamp = timestamp;
        this.tablepriv = tablepriv;
        this.columnpriv = columnpriv;
    }

    public TablesPriv(String host, String db, String user, String tablename) {
        this.tablesPrivPK = new TablesPrivPK(host, db, user, tablename);
    }

    public TablesPrivPK getTablesPrivPK() {
        return tablesPrivPK;
    }

    public void setTablesPrivPK(TablesPrivPK tablesPrivPK) {
        this.tablesPrivPK = tablesPrivPK;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTablepriv() {
        return tablepriv;
    }

    public void setTablepriv(String tablepriv) {
        this.tablepriv = tablepriv;
    }

    public String getColumnpriv() {
        return columnpriv;
    }

    public void setColumnpriv(String columnpriv) {
        this.columnpriv = columnpriv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablesPrivPK != null ? tablesPrivPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablesPriv)) {
            return false;
        }
        TablesPriv other = (TablesPriv) object;
        if ((this.tablesPrivPK == null && other.tablesPrivPK != null) || (this.tablesPrivPK != null && !this.tablesPrivPK.equals(other.tablesPrivPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TablesPriv[ tablesPrivPK=" + tablesPrivPK + " ]";
    }
    
}
