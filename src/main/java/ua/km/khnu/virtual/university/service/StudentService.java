package ua.km.khnu.virtual.university.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.km.khnu.virtual.university.model.Student;
import ua.km.khnu.virtual.university.transfare.CreateStudentForm;
import ua.km.khnu.virtual.university.transfare.EnableStudentForm;

/**
 * @author Igor Rybak
 */
public interface StudentService {
    Student create(CreateStudentForm form);

    Page<Student> getAll(Pageable pageable);

    Page<Student> getByGroup(int groupId, Pageable pageable);

    Student getByDocumentNumber(String documentNumber);

    Student update(int studentId, CreateStudentForm form);

    Student enableStudent(int studentId, EnableStudentForm form);

    void delete(int studentId);
}
