package eu.crossover.webquestion.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import eu.crossover.webquestion.entity.Option;
import eu.crossover.webquestion.entity.Question;
import eu.crossover.webquestion.entity.QuestionOption;
import eu.crossover.webquestion.entity.Test;
import eu.crossover.webquestion.entity.User;
import eu.crossover.webquestion.entity.UserAnswer;
import eu.crossover.webquestion.entity.UserTest;
import eu.crossover.webquestion.facade.UserTestFacade;

@ManagedBean(name = "usrTestMB")
@SessionScoped
public class UserTestManagerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time;
	@ManagedProperty(value = "#{UserTestFacade}")
	private UserTestFacade userTestFacade;
	@ManagedProperty(value = "#{UserAplication}")
	private User user;
	@ManagedProperty(value = "#{TestAplication}")
	private Test test;
	private List<Integer> listIndexQuestion;
	private List<Question> questions;
	private Question userQuestion;
	private UserTest userTest;
	private int indexListQuestion;
	private List<Option> selectQuestionOptions;
	private boolean stop;
	private boolean renderlistIndexQuestionMessage;
	
	
	@PostConstruct
	public void init() {
		this.stop=false;
		this.renderlistIndexQuestionMessage=true;
		this.indexListQuestion = 0;
		listIndexQuestion = new ArrayList<Integer>();
		userTest = new UserTest();
		userTest.setTest(test);
		userTest.setUser(getUser());
		List<UserAnswer> listUserAnswers = new ArrayList<UserAnswer>();
		userTest.setUserAnswers(listUserAnswers);
		questions = new ArrayList<Question>();
		int indexQuestion = 0;
		for (int i = 0; i < test.getQuestionsOptions().size(); i++) {
			
			for (QuestionOption questionOption : test.getQuestionsOptions()) {
				UserAnswer userAnswer = new UserAnswer();
				userAnswer.setQuestionOption(questionOption);
				userAnswer.setUserTest(userTest);
				userAnswer.setIscorrect(false);
				listUserAnswers.add(userAnswer);
				if(!questions.contains(questionOption.getQuestion())){
					questions.add(questionOption.getQuestion());
					listIndexQuestion.add(indexQuestion++);
				}
			}
		
			
		}
		System.out.println("");
	}

	public List<Option> getSelectQuestionOptions() {
		return selectQuestionOptions;
	}

	public void setSelectQuestionOptions(List<Option> selectAnwers) {
		this.selectQuestionOptions = selectAnwers;
	}

	public int getTimeSecodes() {
		return userTest.getTest().getTime();
	}

	public void setUserTestFacade(UserTestFacade userTestFacade) {
		this.userTestFacade = userTestFacade;
	}
	
	public UserTest getUserTest() {
		return userTest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}
	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Question getUserQuestion() {
		if(listIndexQuestion.size() > 0){
			userQuestion = questions.get(indexListQuestion);
		}else{
			userQuestion = null;
		}
		return userQuestion;
	}

	public List<Integer> getListIndexQuestion() {
		return listIndexQuestion;
	}

	public int getIndexListQuestion() {
		return indexListQuestion;
	}

	public void setIndexListQuestion(int indexListQuestion) {
		this.indexListQuestion = indexListQuestion;
	}

	public boolean isRenderlistIndexQuestionMessage() {
		return renderlistIndexQuestionMessage;
	}

	public void setRenderlistIndexQuestionMessage(
			boolean renderlistIndexQuestionMessage) {
		this.renderlistIndexQuestionMessage = renderlistIndexQuestionMessage;
	}

	public String actionBtSubmitTest() {
		return "SUCCESS";
	}

	public String actionBtGoBack(){
		return "BACK";
	}
	
	/**
	 * Save the test made by the user.
	 * @return
	 */
	public String saveTest(){
		userTestFacade.saveUserTestFacade(userTest);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "END";
	}
	
	/**
	 * Update the listIndexQuestion and the chosen options made by the user.
	 * @return
	 */
	public void actionBtSubmitQuestion(ActionEvent actionEvent) {
		if(selectQuestionOptions!=null && selectQuestionOptions.size()>0){
			for(Option option : selectQuestionOptions){
				for(UserAnswer userAnswer2 : userTest.getUserAnswers()){
					if(userAnswer2.getQuestionOption().getOptions().equals(option)){
						userAnswer2.setIscorrect(true);
						break;
					}
				}
			}
			int index = listIndexQuestion.indexOf(indexListQuestion);
			listIndexQuestion.remove(index);
			if(listIndexQuestion.size() > 0){
				if(index > listIndexQuestion.size()-1 ){
					--index;
				}
				indexListQuestion = listIndexQuestion.get(index);
				renderlistIndexQuestionMessage = true;
			}else{
				renderlistIndexQuestionMessage = false;
			}
			selectQuestionOptions = new ArrayList<Option>();
		}
	}
	
	/**
	 * Edit the time for be show in the browser.
	 * @return
	 */
	public String getTime() {
		int timeSecodes = getTimeSecodes();
		int minutos = timeSecodes / 60;
		int seconds = timeSecodes % 60;
		time = minutos + ":" + seconds;
		return time;
	}

	/**
	 * Update the time value of the test.
	 */
	public void updateTime() {
		int time = userTest.getTest().getTime();
		if(time == 0){
			stop = true;
			 try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("final.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			userTest.getTest().setTime(--time);
		}
	}

}
