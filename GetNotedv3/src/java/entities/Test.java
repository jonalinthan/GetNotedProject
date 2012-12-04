/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByTestID", query = "SELECT t FROM Test t WHERE t.testID = :testID"),
    @NamedQuery(name = "Test.findByTestOwner", query = "SELECT t FROM Test t WHERE t.testOwner = :testOwner"),
    @NamedQuery(name = "Test.findByTestDate", query = "SELECT t FROM Test t WHERE t.testDate = :testDate"),
    @NamedQuery(name = "Test.findByTestSubject", query = "SELECT t FROM Test t WHERE t.testSubject = :testSubject"),
    @NamedQuery(name = "Test.findByDifficultyRating", query = "SELECT t FROM Test t WHERE t.difficultyRating = :difficultyRating"),
    @NamedQuery(name = "Test.findByAverageScore", query = "SELECT t FROM Test t WHERE t.averageScore = :averageScore"),
    @NamedQuery(name = "Test.findByNumberOfQuestions", query = "SELECT t FROM Test t WHERE t.numberOfQuestions = :numberOfQuestions")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "testID")
    private String testID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "testOwner")
    private String testOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "testDate")
    private String testDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "testSubject")
    private String testSubject;
    @Size(max = 20)
    @Column(name = "difficultyRating")
    private String difficultyRating;
    @Column(name = "averageScore")
    private Integer averageScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfQuestions")
    private int numberOfQuestions;

    public Test() {
    }

    public Test(String testID) {
        this.testID = testID;
    }

    public Test(String testID, String testOwner, String testDate, String testSubject, int numberOfQuestions) {
        this.testID = testID;
        this.testOwner = testOwner;
        this.testDate = testDate;
        this.testSubject = testSubject;
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getTestOwner() {
        return testOwner;
    }

    public void setTestOwner(String testOwner) {
        this.testOwner = testOwner;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getTestSubject() {
        return testSubject;
    }

    public void setTestSubject(String testSubject) {
        this.testSubject = testSubject;
    }

    public String getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(String difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testID != null ? testID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testID == null && other.testID != null) || (this.testID != null && !this.testID.equals(other.testID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Test[ testID=" + testID + " ]";
    }
    
}
