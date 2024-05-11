package com.school_list;

import com.school_list.models.Teacher;
import com.school_list.services.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SchoolListV1ApplicationTests {

	@Autowired
	private TeacherService teacherService;

	@Test
	void addTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setFirst_name("Yaroslav");
		teacher.setSurname("Admin");
		teacher.setLast_name("Anatolievich");
		teacher.setPhone("+79975532244");
		teacher.setEmail("NEyaroslav2@mail.ru");
		teacher.setPassword("rootadmin");
		teacherService.save(teacher);
	}

	@Test
	void getAllTeachers() {
		List<Teacher> teacherList = teacherService.getAllTeachers();
		System.out.println(teacherList);
	}

	@Test
	void getAllTeachersAndDeleteThem() {
		List<Teacher> teacherList = teacherService.getAllTeachers();
		for (Teacher teacher : teacherList) {
			teacherService.delete(teacher);
		}
	}

}
