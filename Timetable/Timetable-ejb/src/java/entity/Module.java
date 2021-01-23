/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nurul
 */
@Entity
@Table(name = "MODULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findById", query = "SELECT m FROM Module m WHERE m.id = :id"),
    @NamedQuery(name = "Module.findByName", query = "SELECT m FROM Module m WHERE m.name = :name"),
    @NamedQuery(name = "Module.findByLevel", query = "SELECT m FROM Module m WHERE m.level = :level"),
    @NamedQuery(name = "Module.findBySemester", query = "SELECT m FROM Module m WHERE m.semester = :semester")})

@NamedNativeQueries(
        {
            @NamedNativeQuery(name = "Module.findUnregisteredModules", query = "SELECT * FROM Module WHERE id NOT IN (SELECT moduleid FROM Student_Module WHERE studentid = ?1)", resultClass = Module.class),
            @NamedNativeQuery(name = "Module.findRegisteredModules", query = "SELECT * FROM Module WHERE id IN (SELECT moduleid FROM Student_Module WHERE studentid = ?1)", resultClass = Module.class)
        })
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEVEL")
    private int level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEMESTER")
    private int semester;
    @ManyToMany(mappedBy = "moduleCollection")
    private Collection<Student> studentCollection;
    @ManyToMany(mappedBy = "moduleCollection")
    private Collection<Teacher> teacherCollection;
    @OneToMany(mappedBy = "moduleid")
    private Collection<Class> classCollection;

    public Module() {
    }

    public Module(Integer id) {
        this.id = id;
    }

    public Module(Integer id, String name, int level, int semester) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.semester = semester;
    }

    public void registerStudent(Student s) {
        studentCollection.add(s);
        s.addRegistration(this);
    }

    public void unregisterStudent(Student s) {
        studentCollection.remove(s);
        s.removeRegistration(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<Class> getClassCollection() {
        return classCollection;
    }

    public void setClassCollection(Collection<Class> classCollection) {
        this.classCollection = classCollection;
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
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Module[ id=" + id + " ]";
    }

}
