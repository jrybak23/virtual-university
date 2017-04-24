package ua.km.khnu.virtual.university.model;

import ua.km.khnu.virtual.university.model.converters.HoursDurationConverter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Igor Rybak
 */
@Entity
@Table(name = "subject_instance")
public class SubjectInstance {
    private Integer id;
    private String controlType;
    private String subjectType;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Duration hours;
    private Subject subject;
    private Group group;

    public SubjectInstance() {
    }

    public SubjectInstance(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "control_type")
    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controllType) {
        this.controlType = controllType;
    }

    @Column(name = "subject_type")
    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    @Column(name = "date_begin", columnDefinition = "DATE")
    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateStart) {
        this.dateBegin = dateStart;
    }

    @Column(name = "date_end", columnDefinition = "DATE")
    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateFinish) {
        this.dateEnd = dateFinish;
    }

    @Column(name = "hours")
    @Convert(converter = HoursDurationConverter.class)
    public Duration getHours() {
        return hours;
    }

    public void setHours(Duration hours) {
        this.hours = hours;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
