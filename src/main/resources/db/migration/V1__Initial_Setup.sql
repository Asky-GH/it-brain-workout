CREATE TABLE roles (
  id tinyint(4) NOT NULL,
  title varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE statuses (
  id tinyint(4) NOT NULL,
  title varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE types (
  id tinyint(4) NOT NULL,
  title varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE results (
  id tinyint(4) NOT NULL,
  title varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE subjects (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users_roles (
  user_id bigint(20) NOT NULL,
  roles_id tinyint(4) NOT NULL,
  PRIMARY KEY (user_id,roles_id),
  KEY FKa62j07k5mhgifpp955h37ponj (roles_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE questions (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  body longtext NOT NULL,
  status_id tinyint(4) NOT NULL,
  subject_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY STATUS_ID_FK (status_id),
  KEY SUBJECT_ID_FK (subject_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE answers (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  body longtext NOT NULL,
  type_id tinyint(4) NOT NULL,
  PRIMARY KEY (id),
  KEY TYPE_ID_FK (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE questions_answers (
  question_id bigint(20) NOT NULL,
  answers_id bigint(20) NOT NULL,
  PRIMARY KEY (question_id,answers_id),
  UNIQUE KEY UK_tq19n223pwlcaw8qwngigjtyq (answers_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE progresses (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  question_id bigint(20) NOT NULL,
  result_id tinyint(4) NOT NULL,
  subject_id int(11) NOT NULL,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY QUESTION_ID_FK (question_id),
  KEY RESULT_ID_FK (result_id),
  KEY SUBJECT_ID_FK (subject_id),
  KEY USER_ID_FK (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
