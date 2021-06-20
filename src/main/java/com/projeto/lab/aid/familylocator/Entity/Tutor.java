/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.lab.aid.familylocator.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Cams
 */
@Entity
@Table(name = "tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findById", query = "SELECT t FROM Tutor t WHERE t.id = :id"),
    @NamedQuery(name = "Tutor.findByName", query = "SELECT t FROM Tutor t WHERE t.name = :name"),
    @NamedQuery(name = "Tutor.findByLastname", query = "SELECT t FROM Tutor t WHERE t.lastname = :lastname"),
    @NamedQuery(name = "Tutor.findByEmail", query = "SELECT t FROM Tutor t WHERE t.email = :email"),
    @NamedQuery(name = "Tutor.findByPhone", query = "SELECT t FROM Tutor t WHERE t.phone = :phone"),
    @NamedQuery(name = "Tutor.findByGenre", query = "SELECT t FROM Tutor t WHERE t.genre = :genre"),
    @NamedQuery(name = "Tutor.findByAge", query = "SELECT t FROM Tutor t WHERE t.age = :age")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "genre")
    private String genre;
    @Column(name = "age")
    private Integer age;
     @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorId",fetch=FetchType.LAZY)
    private Collection<TStutela> tStutelaCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public Tutor() {
    }

    public Tutor(Integer id) {
        this.id = id;
    }

    public Tutor(Integer id, String name, String lastname, String email, String genre) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.genre = genre;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlTransient
    public Collection<TStutela> getTStutelaCollection() {
        return tStutelaCollection;
    }

    public void setTStutelaCollection(Collection<TStutela> tStutelaCollection) {
        this.tStutelaCollection = tStutelaCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projeto.lab.aid.familylocator.Entity.Tutor[ id=" + id + " ]";
    }
    
}
