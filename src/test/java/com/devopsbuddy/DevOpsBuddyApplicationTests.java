package com.devopsbuddy;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import com.devopsbuddy.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevOpsBuddyApplicationTests {


	@Autowired
	private I18NService i18NService;

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	private static final int BASIC_PLAN_ID=1;

	@Before
	public void init(){
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}

	/*@Test
	public void testMessageByLocaleServie() throws Exception{
		String expectedresult = "Bootstrap starter template";
		String messageId="index.main.callout";
		String actual = i18NService.getMessage(messageId);
		Assert.assertEquals("The actual and expected strings don't match", expectedresult, actual);
	}*/

	@Test
	public void testCreateNewPlan() throws Exception{

		Plan basicPlan = createBasicPlan();
		planRepository.save(basicPlan);

		Plan retrievePlan = planRepository.findOne(BASIC_PLAN_ID);
		Assert.assertNotNull(retrievePlan);

	}

	private Plan createBasicPlan() {
		Plan plan = new Plan();
		plan.setId(BASIC_PLAN_ID);
		plan.setName("Basic");
		return plan;
	}

}
