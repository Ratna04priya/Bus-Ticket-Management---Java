/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.mananagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author ratna
 */
@Entity
@Table(name = "user_booking", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "UserBooking.findAll", query = "SELECT u FROM UserBooking u")
    , @NamedQuery(name = "UserBooking.findById", query = "SELECT u FROM UserBooking u WHERE u.id = :id")
    , @NamedQuery(name = "UserBooking.findByUsername", query = "SELECT u FROM UserBooking u WHERE u.username = :username")
    , @NamedQuery(name = "UserBooking.findBySource", query = "SELECT u FROM UserBooking u WHERE u.source = :source")
    , @NamedQuery(name = "UserBooking.findByDestination", query = "SELECT u FROM UserBooking u WHERE u.destination = :destination")
    , @NamedQuery(name = "UserBooking.findByFromdate", query = "SELECT u FROM UserBooking u WHERE u.fromdate = :fromdate")
    , @NamedQuery(name = "UserBooking.findByTodate", query = "SELECT u FROM UserBooking u WHERE u.todate = :todate")})
public class UserBooking implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "source")
    private String source;
    @Basic(optional = false)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @Column(name = "fromdate")
    @Temporal(TemporalType.DATE)
    private Date fromdate;
    @Basic(optional = false)
    @Column(name = "todate")
    @Temporal(TemporalType.DATE)
    private Date todate;

    public UserBooking() {
    }

    public UserBooking(Integer id) {
        this.id = id;
    }

    public UserBooking(Integer id, String username, String source, String destination, Date fromdate, Date todate) {
        this.id = id;
        this.username = username;
        this.source = source;
        this.destination = destination;
        this.fromdate = fromdate;
        this.todate = todate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        String oldSource = this.source;
        this.source = source;
        changeSupport.firePropertyChange("source", oldSource, source);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        String oldDestination = this.destination;
        this.destination = destination;
        changeSupport.firePropertyChange("destination", oldDestination, destination);
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        Date oldFromdate = this.fromdate;
        this.fromdate = fromdate;
        changeSupport.firePropertyChange("fromdate", oldFromdate, fromdate);
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        Date oldTodate = this.todate;
        this.todate = todate;
        changeSupport.firePropertyChange("todate", oldTodate, todate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBooking)) {
            return false;
        }
        UserBooking other = (UserBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bus.mananagement.UserBooking[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
