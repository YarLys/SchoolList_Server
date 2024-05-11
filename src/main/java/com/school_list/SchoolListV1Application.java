package com.school_list;

import com.school_list.repository.TeacherRepository;
import com.school_list.rest_controllers.RegisterApiController;
import com.school_list.services.TeacherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolListV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SchoolListV1Application.class, args);
	}

}
