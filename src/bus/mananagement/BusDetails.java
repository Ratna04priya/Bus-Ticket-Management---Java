 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.mananagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bus_details", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "BusDetails.findAll", query = "SELECT b FROM BusDetails b")
    , @NamedQuery(name = "BusDetails.findById", query = "SELECT b FROM BusDetails b WHERE b.id = :id")
    , @NamedQuery(name = "BusDetails.findByBusNo", query = "SELECT b FROM BusDetails b WHERE b.busNo = :busNo")
    , @NamedQuery(name = "BusDetails.findByMovement", query = "SELECT b FROM BusDetails b WHERE b.movement = :movement")
    , @NamedQuery(name = "BusDetails.findByBusSource", query = "SELECT b FROM BusDetails b WHERE b.busSource = :busSource")
    , @NamedQuery(name = "BusDetails.findByBusDest", query = "SELECT b FROM BusDetails b WHERE b.busDest = :busDest")
    , @NamedQuery(name = "BusDetails.findByDepartDate", query = "SELECT b FROM BusDetails b WHERE b.departDate = :departDate")
    , @NamedQuery(name = "BusDetails.findByDepartTime", query = "SELECT b FROM BusDetails b WHERE b.departTime = :departTime")
    , @NamedQuery(name = "BusDetails.findByPrice", query = "SELECT b FROM BusDetails b WHERE b.price = :price")
    , @NamedQuery(name = "BusDetails.findByTotalSeat", query = "SELECT b FROM BusDetails b WHERE b.totalSeat = :totalSeat")})
public class BusDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bus_no")
    private String busNo;
    @Basic(optional = false)
    @Column(name = "movement")
    private String movement;
    @Basic(optional = false)
    @Column(name = "bus_source")
    private String busSource;
    @Basic(optional = false)
    @Column(name = "bus_dest")
    private String busDest;
    @Basic(optional = false)
    @Column(name = "depart_date")
    @Temporal(TemporalType.DATE)
    private Date departDate;
    @Basic(optional = false)
    @Column(name = "depart_time")
    @Temporal(TemporalType.TIME)
    private Date departTime;
    @Basic(optional = false)
    @Column(name = "price")
    private BigInteger price;
    @Basic(optional = false)
    @Column(name = "total_seat")
    private int totalSeat;

    public BusDetails() {
    }

    public BusDetails(Integer id) {
        this.id = id;
    }

    public BusDetails(Integer id, String busNo, String movement, String busSource, String busDest, Date departDate, Date departTime, BigInteger price, int totalSeat) {
        this.id = id;
        this.busNo = busNo;
        this.movement = movement;
        this.busSource = busSource;
        this.busDest = busDest;
        this.departDate = departDate;
        this.departTime = departTime;
        this.price = price;
        this.totalSeat = totalSeat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        String oldBusNo = this.busNo;
        this.busNo = busNo;
        changeSupport.firePropertyChange("busNo", oldBusNo, busNo);
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        String oldMovement = this.movement;
        this.movement = movement;
        changeSupport.firePropertyChange("movement", oldMovement, movement);
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        String oldBusSource = this.busSource;
        this.busSource = busSource;
        changeSupport.firePropertyChange("busSource", oldBusSource, busSource);
    }

    public String getBusDest() {
        return busDest;
    }

    public void setBusDest(String busDest) {
        String oldBusDest = this.busDest;
        this.busDest = busDest;
        changeSupport.firePropertyChange("busDest", oldBusDest, busDest);
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        Date oldDepartDate = this.departDate;
        this.departDate = departDate;
        changeSupport.firePropertyChange("departDate", oldDepartDate, departDate);
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        Date oldDepartTime = this.departTime;
        this.departTime = departTime;
        changeSupport.firePropertyChange("departTime", oldDepartTime, departTime);
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        BigInteger oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        int oldTotalSeat = this.totalSeat;
        this.totalSeat = totalSeat;
        changeSupport.firePropertyChange("totalSeat", oldTotalSeat, totalSeat);
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
        if (!(object instanceof BusDetails)) {
            return false;
        }
        BusDetails other = (BusDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bus.mananagement.BusDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
