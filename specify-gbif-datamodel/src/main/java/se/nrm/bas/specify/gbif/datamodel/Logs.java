package se.nrm.bas.specify.gbif.datamodel;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l"),
  @NamedQuery(name = "Logs.findById", query = "SELECT l FROM Logs l WHERE l.id = :id"),
  @NamedQuery(name = "Logs.findByTimestamp", query = "SELECT l FROM Logs l WHERE l.timestamp = :timestamp"),
  @NamedQuery(name = "Logs.findByTotalRecords", query = "SELECT l FROM Logs l WHERE l.totalRecords = :totalRecords")})
public class Logs implements Serializable {

  private static final long serialVersionUID = 1L;
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "totalRecords")
  private int totalRecords;

  public Logs() {
  }

  public Logs(Integer id) {
    this.id = id;
  }

  public Logs(Integer id, Date timestamp, int totalRecords) {
    this.id = id;
    this.timestamp = timestamp;
    this.totalRecords = totalRecords;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public int getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(int totalRecords) {
    this.totalRecords = totalRecords;
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
    if (!(object instanceof Logs)) {
      return false;
    }
    Logs other = (Logs) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.bas.specify.gbif.datamodel.Logs[ id=" + id + " ]";
  }
  
}
