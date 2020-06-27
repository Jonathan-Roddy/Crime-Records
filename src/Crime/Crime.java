/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crime;

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

/**
 *
 * @author Jonathan Roddy
 */
@Entity
@Table(name = "crime")
@NamedQueries({
    @NamedQuery(name = "Crime.findAll", query = "SELECT c FROM Crime c")})
public class Crime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Region")
    private String region;
    @Column(name = "GardaDivision")
    private String gardaDivision;
    @Column(name = "OffenceCode")
    private Integer offenceCode;
    @Column(name = "Offence")
    private String offence;
    @Column(name = "TypeOfOffence")
    private String typeOfOffence;
    @Column(name = "Q12003")
    private Integer q12003;
    @Column(name = "Q22003")
    private Integer q22003;
    @Column(name = "Q32003")
    private Integer q32003;
    @Column(name = "Q42003")
    private Integer q42003;
    @Column(name = "Q12004")
    private Integer q12004;
    @Column(name = "Q22004")
    private Integer q22004;
    @Column(name = "Q32004")
    private Integer q32004;
    @Column(name = "Q42004")
    private Integer q42004;
    @Column(name = "Q12005")
    private Integer q12005;
    @Column(name = "Q22005")
    private Integer q22005;
    @Column(name = "Q32005")
    private Integer q32005;
    @Column(name = "Q42005")
    private Integer q42005;
    @Column(name = "Q12006")
    private Integer q12006;
    @Column(name = "Q22006")
    private Integer q22006;
    @Column(name = "Q32006")
    private Integer q32006;
    @Column(name = "Q42006")
    private Integer q42006;
    @Column(name = "Q12007")
    private Integer q12007;
    @Column(name = "Q22007")
    private Integer q22007;
    @Column(name = "Q32007")
    private Integer q32007;
    @Column(name = "Q42007")
    private Integer q42007;
    @Column(name = "Q12008")
    private Integer q12008;
    @Column(name = "Q22008")
    private Integer q22008;
    @Column(name = "Q32008")
    private Integer q32008;
    @Column(name = "Q42008")
    private Integer q42008;
    @Column(name = "Q12009")
    private Integer q12009;
    @Column(name = "Q22009")
    private Integer q22009;
    @Column(name = "Q32009")
    private Integer q32009;
    @Column(name = "Q42009")
    private Integer q42009;
    @Column(name = "Q12010")
    private Integer q12010;
    @Column(name = "Q22010")
    private Integer q22010;
    @Column(name = "Q32010")
    private Integer q32010;
    @Column(name = "Q42010")
    private Integer q42010;
    @Column(name = "Q12011")
    private Integer q12011;
    @Column(name = "Q22011")
    private Integer q22011;
    @Column(name = "Q32011")
    private Integer q32011;
    @Column(name = "Q42011")
    private Integer q42011;
    @Column(name = "Q12012")
    private Integer q12012;
    @Column(name = "Q22012")
    private Integer q22012;
    @Column(name = "Q32012")
    private Integer q32012;
    @Column(name = "Q42012")
    private Integer q42012;
    @Column(name = "Q12013")
    private Integer q12013;
    @Column(name = "Q22013")
    private Integer q22013;
    @Column(name = "Q32013")
    private Integer q32013;
    @Column(name = "Q42013")
    private Integer q42013;
    @Column(name = "Q12014")
    private Integer q12014;
    @Column(name = "Q22014")
    private Integer q22014;
    @Column(name = "Q32014")
    private Integer q32014;
    @Column(name = "Q42014")
    private Integer q42014;
    @Column(name = "Q12015")
    private Integer q12015;
    @Column(name = "Q22015")
    private Integer q22015;
    @Column(name = "Q32015")
    private Integer q32015;
    @Column(name = "Q42015")
    private Integer q42015;
    @Column(name = "Q12016")
    private Integer q12016;
    @Column(name = "Q22016")
    private Integer q22016;
    @Column(name = "Q32016")
    private Integer q32016;
    @Column(name = "Q42016")
    private Integer q42016;
    @Column(name = "Q12017")
    private Integer q12017;
    @Column(name = "Q22017")
    private Integer q22017;
    @Column(name = "Q32017")
    private Integer q32017;
    @Column(name = "Q42017")
    private Integer q42017;
    @Column(name = "Q12018")
    private Integer q12018;
    @Column(name = "Q22018")
    private Integer q22018;
    @Column(name = "Q32018")
    private Integer q32018;
    @Column(name = "Q42018")
    private Integer q42018;
    @Column(name = "Q12019")
    private Integer q12019;
    @Column(name = "Q22019")
    private Integer q22019;
    @Column(name = "Q32019")
    private Integer q32019;

    public Crime() {
    }

    public Crime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGardaDivision() {
        return gardaDivision;
    }

    public void setGardaDivision(String gardaDivision) {
        this.gardaDivision = gardaDivision;
    }

    public Integer getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(Integer offenceCode) {
        this.offenceCode = offenceCode;
    }

    public String getOffence() {
        return offence;
    }

    public void setOffence(String offence) {
        this.offence = offence;
    }

    public String getTypeOfOffence() {
        return typeOfOffence;
    }

    public void setTypeOfOffence(String typeOfOffence) {
        this.typeOfOffence = typeOfOffence;
    }

    public Integer getQ12003() {
        return q12003;
    }

    public void setQ12003(Integer q12003) {
        this.q12003 = q12003;
    }

    public Integer getQ22003() {
        return q22003;
    }

    public void setQ22003(Integer q22003) {
        this.q22003 = q22003;
    }

    public Integer getQ32003() {
        return q32003;
    }

    public void setQ32003(Integer q32003) {
        this.q32003 = q32003;
    }

    public Integer getQ42003() {
        return q42003;
    }

    public void setQ42003(Integer q42003) {
        this.q42003 = q42003;
    }

    public Integer getQ12004() {
        return q12004;
    }

    public void setQ12004(Integer q12004) {
        this.q12004 = q12004;
    }

    public Integer getQ22004() {
        return q22004;
    }

    public void setQ22004(Integer q22004) {
        this.q22004 = q22004;
    }

    public Integer getQ32004() {
        return q32004;
    }

    public void setQ32004(Integer q32004) {
        this.q32004 = q32004;
    }

    public Integer getQ42004() {
        return q42004;
    }

    public void setQ42004(Integer q42004) {
        this.q42004 = q42004;
    }

    public Integer getQ12005() {
        return q12005;
    }

    public void setQ12005(Integer q12005) {
        this.q12005 = q12005;
    }

    public Integer getQ22005() {
        return q22005;
    }

    public void setQ22005(Integer q22005) {
        this.q22005 = q22005;
    }

    public Integer getQ32005() {
        return q32005;
    }

    public void setQ32005(Integer q32005) {
        this.q32005 = q32005;
    }

    public Integer getQ42005() {
        return q42005;
    }

    public void setQ42005(Integer q42005) {
        this.q42005 = q42005;
    }

    public Integer getQ12006() {
        return q12006;
    }

    public void setQ12006(Integer q12006) {
        this.q12006 = q12006;
    }

    public Integer getQ22006() {
        return q22006;
    }

    public void setQ22006(Integer q22006) {
        this.q22006 = q22006;
    }

    public Integer getQ32006() {
        return q32006;
    }

    public void setQ32006(Integer q32006) {
        this.q32006 = q32006;
    }

    public Integer getQ42006() {
        return q42006;
    }

    public void setQ42006(Integer q42006) {
        this.q42006 = q42006;
    }

    public Integer getQ12007() {
        return q12007;
    }

    public void setQ12007(Integer q12007) {
        this.q12007 = q12007;
    }

    public Integer getQ22007() {
        return q22007;
    }

    public void setQ22007(Integer q22007) {
        this.q22007 = q22007;
    }

    public Integer getQ32007() {
        return q32007;
    }

    public void setQ32007(Integer q32007) {
        this.q32007 = q32007;
    }

    public Integer getQ42007() {
        return q42007;
    }

    public void setQ42007(Integer q42007) {
        this.q42007 = q42007;
    }

    public Integer getQ12008() {
        return q12008;
    }

    public void setQ12008(Integer q12008) {
        this.q12008 = q12008;
    }

    public Integer getQ22008() {
        return q22008;
    }

    public void setQ22008(Integer q22008) {
        this.q22008 = q22008;
    }

    public Integer getQ32008() {
        return q32008;
    }

    public void setQ32008(Integer q32008) {
        this.q32008 = q32008;
    }

    public Integer getQ42008() {
        return q42008;
    }

    public void setQ42008(Integer q42008) {
        this.q42008 = q42008;
    }

    public Integer getQ12009() {
        return q12009;
    }

    public void setQ12009(Integer q12009) {
        this.q12009 = q12009;
    }

    public Integer getQ22009() {
        return q22009;
    }

    public void setQ22009(Integer q22009) {
        this.q22009 = q22009;
    }

    public Integer getQ32009() {
        return q32009;
    }

    public void setQ32009(Integer q32009) {
        this.q32009 = q32009;
    }

    public Integer getQ42009() {
        return q42009;
    }

    public void setQ42009(Integer q42009) {
        this.q42009 = q42009;
    }

    public Integer getQ12010() {
        return q12010;
    }

    public void setQ12010(Integer q12010) {
        this.q12010 = q12010;
    }

    public Integer getQ22010() {
        return q22010;
    }

    public void setQ22010(Integer q22010) {
        this.q22010 = q22010;
    }

    public Integer getQ32010() {
        return q32010;
    }

    public void setQ32010(Integer q32010) {
        this.q32010 = q32010;
    }

    public Integer getQ42010() {
        return q42010;
    }

    public void setQ42010(Integer q42010) {
        this.q42010 = q42010;
    }

    public Integer getQ12011() {
        return q12011;
    }

    public void setQ12011(Integer q12011) {
        this.q12011 = q12011;
    }

    public Integer getQ22011() {
        return q22011;
    }

    public void setQ22011(Integer q22011) {
        this.q22011 = q22011;
    }

    public Integer getQ32011() {
        return q32011;
    }

    public void setQ32011(Integer q32011) {
        this.q32011 = q32011;
    }

    public Integer getQ42011() {
        return q42011;
    }

    public void setQ42011(Integer q42011) {
        this.q42011 = q42011;
    }

    public Integer getQ12012() {
        return q12012;
    }

    public void setQ12012(Integer q12012) {
        this.q12012 = q12012;
    }

    public Integer getQ22012() {
        return q22012;
    }

    public void setQ22012(Integer q22012) {
        this.q22012 = q22012;
    }

    public Integer getQ32012() {
        return q32012;
    }

    public void setQ32012(Integer q32012) {
        this.q32012 = q32012;
    }

    public Integer getQ42012() {
        return q42012;
    }

    public void setQ42012(Integer q42012) {
        this.q42012 = q42012;
    }

    public Integer getQ12013() {
        return q12013;
    }

    public void setQ12013(Integer q12013) {
        this.q12013 = q12013;
    }

    public Integer getQ22013() {
        return q22013;
    }

    public void setQ22013(Integer q22013) {
        this.q22013 = q22013;
    }

    public Integer getQ32013() {
        return q32013;
    }

    public void setQ32013(Integer q32013) {
        this.q32013 = q32013;
    }

    public Integer getQ42013() {
        return q42013;
    }

    public void setQ42013(Integer q42013) {
        this.q42013 = q42013;
    }

    public Integer getQ12014() {
        return q12014;
    }

    public void setQ12014(Integer q12014) {
        this.q12014 = q12014;
    }

    public Integer getQ22014() {
        return q22014;
    }

    public void setQ22014(Integer q22014) {
        this.q22014 = q22014;
    }

    public Integer getQ32014() {
        return q32014;
    }

    public void setQ32014(Integer q32014) {
        this.q32014 = q32014;
    }

    public Integer getQ42014() {
        return q42014;
    }

    public void setQ42014(Integer q42014) {
        this.q42014 = q42014;
    }

    public Integer getQ12015() {
        return q12015;
    }

    public void setQ12015(Integer q12015) {
        this.q12015 = q12015;
    }

    public Integer getQ22015() {
        return q22015;
    }

    public void setQ22015(Integer q22015) {
        this.q22015 = q22015;
    }

    public Integer getQ32015() {
        return q32015;
    }

    public void setQ32015(Integer q32015) {
        this.q32015 = q32015;
    }

    public Integer getQ42015() {
        return q42015;
    }

    public void setQ42015(Integer q42015) {
        this.q42015 = q42015;
    }

    public Integer getQ12016() {
        return q12016;
    }

    public void setQ12016(Integer q12016) {
        this.q12016 = q12016;
    }

    public Integer getQ22016() {
        return q22016;
    }

    public void setQ22016(Integer q22016) {
        this.q22016 = q22016;
    }

    public Integer getQ32016() {
        return q32016;
    }

    public void setQ32016(Integer q32016) {
        this.q32016 = q32016;
    }

    public Integer getQ42016() {
        return q42016;
    }

    public void setQ42016(Integer q42016) {
        this.q42016 = q42016;
    }

    public Integer getQ12017() {
        return q12017;
    }

    public void setQ12017(Integer q12017) {
        this.q12017 = q12017;
    }

    public Integer getQ22017() {
        return q22017;
    }

    public void setQ22017(Integer q22017) {
        this.q22017 = q22017;
    }

    public Integer getQ32017() {
        return q32017;
    }

    public void setQ32017(Integer q32017) {
        this.q32017 = q32017;
    }

    public Integer getQ42017() {
        return q42017;
    }

    public void setQ42017(Integer q42017) {
        this.q42017 = q42017;
    }

    public Integer getQ12018() {
        return q12018;
    }

    public void setQ12018(Integer q12018) {
        this.q12018 = q12018;
    }

    public Integer getQ22018() {
        return q22018;
    }

    public void setQ22018(Integer q22018) {
        this.q22018 = q22018;
    }

    public Integer getQ32018() {
        return q32018;
    }

    public void setQ32018(Integer q32018) {
        this.q32018 = q32018;
    }

    public Integer getQ42018() {
        return q42018;
    }

    public void setQ42018(Integer q42018) {
        this.q42018 = q42018;
    }

    public Integer getQ12019() {
        return q12019;
    }

    public void setQ12019(Integer q12019) {
        this.q12019 = q12019;
    }

    public Integer getQ22019() {
        return q22019;
    }

    public void setQ22019(Integer q22019) {
        this.q22019 = q22019;
    }

    public Integer getQ32019() {
        return q32019;
    }

    public void setQ32019(Integer q32019) {
        this.q32019 = q32019;
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
        if (!(object instanceof Crime)) {
            return false;
        }
        Crime other = (Crime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        int total = 0 ;
        return "~Crime Record ~ "
                + "\n"
                + "\nID = " + id + "   Region = " + region
                + "\nGarda Division = " + gardaDivision + "   Offence Code = " + offenceCode 
                + "\nOffence = " + offence + "   Type Of Offence = " + typeOfOffence
                + "\nTotal = " + calculateTotal()
                + "\n"
                + " \n-------------------------------------------";
        //return "Crime[ id=" + id + " region= " + region+ "  + Total = " +" ]";
    }    
    public int calculateTotal()
    {
        int totalPerCrime = 0;
        totalPerCrime = this.q12003 + this.q22003 + this.q32003 + this.q42003;
        totalPerCrime += this.q12004 + this.q22004 + this.q32004 + this.q42004;
        totalPerCrime += this.q12005 + this.q22005 + this.q32005 + this.q42005;
        totalPerCrime += this.q12006 + this.q22006 + this.q32006 + this.q42006;
        totalPerCrime += this.q12007 + this.q22007 + this.q32007 + this.q42007;
        totalPerCrime += this.q12008 + this.q22008 + this.q32008 + this.q42008;
        totalPerCrime += this.q12009 + this.q22009 + this.q32009 + this.q42009;
        totalPerCrime += this.q12010 + this.q22010 + this.q32010 + this.q42010;
        totalPerCrime += this.q12011 + this.q22011 + this.q32011 + this.q42011;
        totalPerCrime += this.q12012 + this.q22012 + this.q32012 + this.q42012;
        totalPerCrime += this.q12013 + this.q22013 + this.q32013 + this.q42013;
        totalPerCrime += this.q12014 + this.q22014 + this.q32014 + this.q42014;
        totalPerCrime += this.q12015 + this.q22015 + this.q32015 + this.q42015;
        totalPerCrime += this.q12016 + this.q22016 + this.q32016 + this.q42016;
        totalPerCrime += this.q12017 + this.q22017 + this.q32017 + this.q42017;
        totalPerCrime += this.q12018 + this.q22018 + this.q32018 + this.q42018;
        totalPerCrime += this.q12019 + this.q22019 + this.q32019;
        
        
        
        return totalPerCrime;
    }
}
