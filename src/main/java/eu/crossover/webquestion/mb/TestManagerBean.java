package eu.crossover.webquestion.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import eu.crossover.webquestion.entity.Test;
import eu.crossover.webquestion.facade.TestFacade;

@ManagedBean(name="testMB", eager=true)
@ApplicationScoped
public class TestManagerBean {
	@ManagedProperty(value = "#{TestFacade}")
	private TestFacade testFacade;
	@ManagedProperty(value = "#{TestAplication}")
	private Test test;
	
	@PostConstruct
	public void init() {
		Test local = testFacade.getTest();
		test.setDescription(local.getDescription());
		test.setId(local.getId());
		test.setQuestionsOptions(local.getQuestionsOptions());
		test.setTime(local.getTime());
	}
	public void setTestFacade(TestFacade testFacade) {
		this.testFacade = testFacade;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
}
