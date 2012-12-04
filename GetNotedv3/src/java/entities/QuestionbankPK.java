/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jonathan
 */
@Embeddable
public class QuestionbankPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "questionOwner")
    private String questionOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question")
    private String question;

    public QuestionbankPK() {
    }

    public QuestionbankPK(String questionOwner, String question) {
        this.questionOwner = questionOwner;
        this.question = question;
    }

    public String getQuestionOwner() {
        return questionOwner;
    }

    public void setQuestionOwner(String questionOwner) {
        this.questionOwner = questionOwner;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionOwner != null ? questionOwner.hashCode() : 0);
        hash += (question != null ? question.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionbankPK)) {
            return false;
        }
        QuestionbankPK other = (QuestionbankPK) object;
        if ((this.questionOwner == null && other.questionOwner != null) || (this.questionOwner != null && !this.questionOwner.equals(other.questionOwner))) {
            return false;
        }
        if ((this.question == null && other.question != null) || (this.question != null && !this.question.equals(other.question))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionbankPK[ questionOwner=" + questionOwner + ", question=" + question + " ]";
    }
    
}
