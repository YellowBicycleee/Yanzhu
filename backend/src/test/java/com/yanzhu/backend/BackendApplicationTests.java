package com.yanzhu.backend;

import com.yanzhu.backend.contest.controller.ContestControllerTest;
import com.yanzhu.backend.contest.service.IContestServiceTest;
import com.yanzhu.backend.course.controller.CourseControllerTest;
import com.yanzhu.backend.course.service.ICourseServiceTest;
import com.yanzhu.backend.postgraduateRecommendation.controller.PostgraduateRecommendationTest;
import com.yanzhu.backend.postgraduateRecommendation.service.IPostgraduateRecommendationService;
import com.yanzhu.backend.postgraduateRecommendation.service.IPostgraduateRecommendationServiceTest;
import com.yanzhu.backend.postgraduateTest.controller.PostgraduateTestControllerTest;
import com.yanzhu.backend.postgraduateTest.service.IPostgraduateTestServiceTest;
import com.yanzhu.backend.user.controller.UserControllerTest;
import com.yanzhu.backend.user.service.IUserServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class BackendApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
@RunWith(Suite.class)
@Suite.SuiteClasses({
		ContestControllerTest.class,
		IContestServiceTest.class,
		CourseControllerTest.class,
		ICourseServiceTest.class,
		PostgraduateRecommendationTest.class,
		IPostgraduateRecommendationServiceTest.class,
		PostgraduateTestControllerTest.class,
		IPostgraduateTestServiceTest.class,
		UserControllerTest.class,
		IUserServiceTest.class
})
public class BackendApplicationTests {
	// This class remains empty, it is used only as a holder for the above annotations
}

