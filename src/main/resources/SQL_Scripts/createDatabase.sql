drop database IF EXISTS webquestion;
create database webquestion;
use webquestion;
CREATE TABLE user (
   id int(11) NOT NULL AUTO_INCREMENT,
   name varchar(45),
   password varchar(45),
   PRIMARY KEY (id)
);
create table options(
	id int(11) not null AUTO_INCREMENT,
	description varchar(100),
	PRIMARY KEY (id)
);
create table question(
	id int(11) not null AUTO_INCREMENT,
	description varchar(100),
  	PRIMARY KEY (id)
);
create table question_options(
	id int(11) not null AUTO_INCREMENT,
	question_id int(11) not null,
	options_id int(11) not null,
	is_correct boolean not null,
	PRIMARY KEY (id),
	FOREIGN KEY (question_id) REFERENCES question(id),
	FOREIGN KEY (options_id) REFERENCES options(id)
);
create table test(
	id int(11) not null AUTO_INCREMENT,
	time int(11) not null,
	description varchar(100),
	PRIMARY KEY (id)
);
create table test_question_options(
	id int(11) not null AUTO_INCREMENT,
	test_id int(11) not null,
	question_options_id int(11),
	PRIMARY KEY (id),
	FOREIGN KEY (test_id) REFERENCES test(id),
	FOREIGN KEY (question_options_id) REFERENCES question_options(id)
);
create table user_test(
	id int(11) not null AUTO_INCREMENT,
	user_id int(11) not null,
	test_id int(11) not null,
	PRIMARY KEY (id),
	FOREIGN KEY (test_id) REFERENCES test(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
);

create table user_answer(
	id int(11) not null AUTO_INCREMENT,
	user_test_id int(11) not null,
	test_question_options_id int(11) not null,
	is_correct boolean not null,
	PRIMARY KEY (id),
	FOREIGN KEY (test_question_options_id) REFERENCES test_question_options(id),
	FOREIGN KEY (user_test_id) REFERENCES user_test(id)
);

