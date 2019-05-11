/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.mananagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ratna
 */
@Entity
@Table(name = "employee_details", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "EmployeeDetails.findAll", query = "SELECT e FROM EmployeeDetails e")
    , @NamedQuery(name = "EmployeeDetails.findById", query = "SELECT e FROM EmployeeDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeDetails.findByFirstname", query = "SELECT e FROM EmployeeDetails e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "EmployeeDetails.findByLastname", query = "SELECT e FROM EmployeeDetails e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "EmployeeDetails.findByPhone1", query = "SELECT e FROM EmployeeDetails e WHERE e.phone1 = :phone1")
    , @NamedQuery(name = "EmployeeDetails.findByPhone2", query = "SELECT e FROM EmployeeDetails e WHERE e.phone2 = :phone2")})
public class EmployeeDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "phone1")
    private int phone1;
    @Basic(optional = false)
    @Column(name = "phone2")
    private int phone2;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer id) {
        this.id = id;
    }

    public EmployeeDetails(Integer id, String firstname, String lastname, int phone1, int phone2) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public int getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        int oldPhone1 = this.phone1;
        this.phone1 = phone1;
        changeSupport.firePropertyChange("phone1", oldPhone1, phone1);
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        int oldPhone2 = this.phone2;
        this.phone2 = phone2;
        changeSupport.firePropertyChange("phone2", oldPhone2, phone2);
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
        if (!(object instanceof EmployeeDetails)) {
            return false;
        }
        EmployeeDetails other = (EmployeeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bus.mananagement.EmployeeDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
