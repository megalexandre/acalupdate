package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class UserPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Host")
    private String host;
    @Basic(optional = false)
    @Column(name = "User")
    private String user;

    public UserPK() {
    }

    public UserPK(String host, String user) {
        this.host = host;
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (host != null ? host.hashCode() : 0);
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPK)) {
            return false;
        }
        UserPK other = (UserPK) object;
        if ((this.host == null && other.host != null) || (this.host != null && !this.host.equals(other.host))) {
            return false;
        }
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UserPK[ host=" + host + ", user=" + user + " ]";
    }
    
}
