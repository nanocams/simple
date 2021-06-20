/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.lab.aid.familylocator.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cams
 */
@Entity
@Table(name = "t_stutela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TStutela.findAll", query = "SELECT t FROM TStutela t"),
    @NamedQuery(name = "TStutela.findById", query = "SELECT t FROM TStutela t WHERE t.id = :id"),
    @NamedQuery(name = "TStutela.findByDateIn", query = "SELECT t FROM TStutela t WHERE t.dateIn = :dateIn")})
public class TStutela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_in")
    @Temporal(TemporalType.DATE)
     @JsonbTransient
    private Date dateIn;
    @JoinColumn(name = "sub_tutela_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubTutela subTutelaId;
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tutor tutorId;

    public TStutela() {
    }

    public TStutela(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public SubTutela getSubTutelaId() {
        return subTutelaId;
    }

    public void setSubTutelaId(SubTutela subTutelaId) {
        this.subTutelaId = subTutelaId;
    }

    public Tutor getTutorId() {
        return tutorId;
    }

    public void setTutorId(Tutor tutorId) {
        this.tutorId = tutorId;
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
        if (!(object instanceof TStutela)) {
            return false;
        }
        TStutela other = (TStutela) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projeto.lab.aid.familylocator.Entity.TStutela[ id=" + id + " ]";
    }
    
}
