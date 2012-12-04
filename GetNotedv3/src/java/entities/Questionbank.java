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
@Table(name = "questionbank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionbank.findAll", query = "SELECT q FROM Questionbank q"),
    @NamedQuery(name = "Questionbank.findByQuestionOwner", query = "SELECT q FROM Questionbank q WHERE q.questionbankPK.questionOwner = :questionOwner"),
    @NamedQuery(name = "Questionbank.findByQuestion", query = "SELECT q FROM Questionbank q WHERE q.questionbankPK.question = :question"),
    @NamedQuery(name = "Questionbank.findByCorrectAnswer", query = "SELECT q FROM Questionbank q WHERE q.correctAnswer = :correctAnswer"),
    @NamedQuery(name = "Questionbank.findByTopic", query = "SELECT q FROM Questionbank q WHERE q.topic = :topic"),
    @NamedQuery(name = "Questionbank.findByRating", query = "SELECT q FROM Questionbank q WHERE q.rating = :rating")})
public class Questionbank implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionbankPK questionbankPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "correctAnswer")
    private String correctAnswer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "topic")
    private String topic;
    @Size(max = 20)
    @Column(name = "rating")
    private String rating;

    public Questionbank() {
    }

    public Questionbank(QuestionbankPK questionbankPK) {
        this.questionbankPK = questionbankPK;
    }

    public Questionbank(QuestionbankPK questionbankPK, String correctAnswer, String topic) {
        this.questionbankPK = questionbankPK;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
    }

    public Questionbank(String questionOwner, String question) {
        this.questionbankPK = new QuestionbankPK(questionOwner, question);
    }

    public QuestionbankPK getQuestionbankPK() {
        return questionbankPK;
    }

    public void setQuestionbankPK(QuestionbankPK questionbankPK) {
        this.questionbankPK = questionbankPK;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionbankPK != null ? questionbankPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionbank)) {
            return false;
        }
        Questionbank other = (Questionbank) object;
        if ((this.questionbankPK == null && other.questionbankPK != null) || (this.questionbankPK != null && !this.questionbankPK.equals(other.questionbankPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Questionbank[ questionbankPK=" + questionbankPK + " ]";
    }
    
}
