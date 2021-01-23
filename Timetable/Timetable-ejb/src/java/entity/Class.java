/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nurul
 */
@Entity
@Table(name = "CLASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c"),
    @NamedQuery(name = "Class.findById", query = "SELECT c FROM Class c WHERE c.id = :id"),
    @NamedQuery(name = "Class.findByModuleId", query = "SELECT c FROM Class c WHERE c.moduleid = :id"),
    @NamedQuery(name = "Class.findByDate", query = "SELECT c FROM Class c WHERE c.date = :date"),
    @NamedQuery(name = "Class.findByStarttime", query = "SELECT c FROM Class c WHERE c.starttime = :starttime"),
    @NamedQuery(name = "Class.findByEndtime", query = "SELECT c FROM Class c WHERE c.endtime = :endtime")})
@NamedNativeQueries(
        {
            @NamedNativeQuery(name = "Class.findTimetable", query = "SELECT * FROM Class WHERE moduleid IN (SELECT moduleid FROM Student_Module WHERE studentid = ?1)", resultClass = Class.class)
        })
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @JoinColumn(name = "MODULEID", referencedColumnName = "ID")
    @ManyToOne
    private Module moduleid;
    @JoinColumn(name = "ROOMID", referencedColumnName = "ID")
    @ManyToOne
    private Room roomid;

    public Class() {
    }

    public Class(Integer id) {
        this.id = id;
    }

    public Class(Integer id, Date date, Date starttime, Date endtime) {
        this.id = id;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Module getModuleid() {
        return moduleid;
    }

    public void setModuleid(Module moduleid) {
        this.moduleid = moduleid;
    }

    public Room getRoomid() {
        return roomid;
    }

    public void setRoomid(Room roomid) {
        this.roomid = roomid;
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
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Class[ id=" + id + " ]";
    }

}
