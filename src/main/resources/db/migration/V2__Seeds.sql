INSERT INTO roles(id, title) VALUES(1, 'ROLE_ADMIN');
INSERT INTO roles(id, title) VALUES(2, 'ROLE_MODER');
INSERT INTO roles(id, title) VALUES(3, 'ROLE_USER');

INSERT INTO statuses(id, title) VALUES(1, 'APPROVED');
INSERT INTO statuses(id, title) VALUES(2, 'PENDING');

INSERT INTO types(id, title) VALUES(1, 'RIGHT');
INSERT INTO types(id, title) VALUES(2, 'WRONG');

INSERT INTO results(id, title) VALUES(1, 'CORRECT');
INSERT INTO results(id, title) VALUES(2, 'INCORRECT');

INSERT INTO subjects(id, title) VALUES(1, 'Java');
INSERT INTO subjects(id, title) VALUES(2, 'HTML');
INSERT INTO subjects(id, title) VALUES(3, 'CSS');
INSERT INTO subjects(id, title) VALUES(4, 'SQL');
INSERT INTO subjects(id, title) VALUES(5, 'JavaScript');
INSERT INTO subjects(id, title) VALUES(6, 'PHP');

INSERT INTO users(id, username, password) VALUES(1, 'admin', '$2a$10$dKFNExPwV2sxFVhKAQN2Je42IQ.y644hVRXk5ridNOtpmLp.M/7yy');
INSERT INTO users(id, username, password) VALUES(2, 'moder', '$2a$10$ZsiTVZl4i5D9yjNbZAZuI.2tcMAqX4pf7el0N7DN.G6l.I9omcjfK');
INSERT INTO users(id, username, password) VALUES(3, 'user', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(4, 'ActiveAngelic', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(5, 'WsEnjoy', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(6, 'Denouse', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(7, 'RingOne', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(8, 'Bleauxbr', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(9, 'FaithXoxox', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(10, 'Nanonicon', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(11, 'VirtuosoBug', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(12, 'AutAholic', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(13, 'Whiticus', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(14, 'AlertFighter', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(15, 'Unowticsys', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(16, 'Spreappli', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(17, 'Fesitari', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');
INSERT INTO users(id, username, password) VALUES(18, 'JinTinker', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');

INSERT INTO users_roles(user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES(1, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(2, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES(2, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(3, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(4, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(5, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(6, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(7, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(8, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(9, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(10, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(11, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(12, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(13, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(14, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(15, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(16, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(17, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(18, 3);

INSERT INTO questions(id, body, status_id, subject_id) VALUES(1, 'Каков размер данных типа char?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(2, 'Какое из следующих утверждений верно для класса: java.util.ArrayList?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(3, 'Какое из следующих ключевых слов используется для наследования класса?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(4, 'Какое из следующих утверждений верно для method-local inner class?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(5, 'Какое из следующих ключевых слов используется для наследования интерфейса?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(6, 'Какой идентификатор корректен?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(7, 'Какое ключевое слово не зарезервировано языком?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(8, 'Что из нижеперечисленного не является принципом ООП?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(9, 'Что из нижеперечисленного не является модификатором доступа?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(10, 'Какое из нижеперечисленных ключевых слов используется для определения аннотации?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(11, 'Как расшифровывается HTML?', 1, 2);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(12, 'Какое расширение должны иметь HTML документы?', 1, 2);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(13, 'Какой тег позволяет вставлять картинки в HTML документы?', 1, 2);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(14, 'Выберите ссылку с правильным синтаксисом.', 1, 2);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(15, 'С помощью какого тэга можно сделать текст жирным?', 1, 2);

-- Каков размер данных типа char?
INSERT INTO answers(id, body, type_id) VALUES(1, '16 бит', 2);
INSERT INTO answers(id, body, type_id) VALUES(2, '32 бит', 2);
INSERT INTO answers(id, body, type_id) VALUES(3, '7 бит', 2);
INSERT INTO answers(id, body, type_id) VALUES(4, '1 байт', 1);
-- Какое из следующих утверждений верно для класса: java.util.ArrayList?
INSERT INTO answers(id, body, type_id) VALUES(5, 'Коллекция гарантированно неизменная (immutable)', 2);
INSERT INTO answers(id, body, type_id) VALUES(6, 'Элементы в коллекции доступны с помощью уникального ключа', 2);
INSERT INTO answers(id, body, type_id) VALUES(7, 'Элементы в коллекции упорядочены', 1);
INSERT INTO answers(id, body, type_id) VALUES(8, 'Элементы коллекции гарантированно уникальные', 2);
--Какое из следующих ключевых слов используется для наследования класса?
INSERT INTO answers(id, body, type_id) VALUES(9, 'extends', 1);
INSERT INTO answers(id, body, type_id) VALUES(10, 'inherits', 2);
INSERT INTO answers(id, body, type_id) VALUES(11, 'implements', 2);
INSERT INTO answers(id, body, type_id) VALUES(12, 'derives', 2);
--Какое из следующих утверждений верно для method-local inner class?
INSERT INTO answers(id, body, type_id) VALUES(13, 'Может быть объявлен как static', 2);
INSERT INTO answers(id, body, type_id) VALUES(14, 'Может быть объявлен как final abstract', 1);
INSERT INTO answers(id, body, type_id) VALUES(15, 'Может быть объявлен как public', 2);
INSERT INTO answers(id, body, type_id) VALUES(16, 'Должен быть объявлен как final', 2);
--Какое из следующих ключевых слов используется для наследования интерфейса?
INSERT INTO answers(id, body, type_id) VALUES(17, 'extends', 2);
INSERT INTO answers(id, body, type_id) VALUES(18, 'inherits', 2);
INSERT INTO answers(id, body, type_id) VALUES(19, 'implements', 1);
INSERT INTO answers(id, body, type_id) VALUES(20, 'derives', 2);
--Какой идентификатор корректен?
INSERT INTO answers(id, body, type_id) VALUES(21, '2variable', 2);
INSERT INTO answers(id, body, type_id) VALUES(22, 'la_la#', 2);
INSERT INTO answers(id, body, type_id) VALUES(23, 'var', 1);
INSERT INTO answers(id, body, type_id) VALUES(24, '123', 2);
--Какое ключевое слово не зарезервировано языком?
INSERT INTO answers(id, body, type_id) VALUES(25, 'int', 2);
INSERT INTO answers(id, body, type_id) VALUES(26, 'break', 2);
INSERT INTO answers(id, body, type_id) VALUES(27, 'feed', 1);
INSERT INTO answers(id, body, type_id) VALUES(28, 'finally', 2);
--Что из нижеперечисленного не является принципом ООП?
INSERT INTO answers(id, body, type_id) VALUES(29, 'Инкапсуляция', 2);
INSERT INTO answers(id, body, type_id) VALUES(30, 'Полиморфизм', 2);
INSERT INTO answers(id, body, type_id) VALUES(31, 'Наследование', 2);
INSERT INTO answers(id, body, type_id) VALUES(32, 'Объективизация', 1);
--Что из нижеперечисленного не является модификатором доступа?
INSERT INTO answers(id, body, type_id) VALUES(33, 'public', 2);
INSERT INTO answers(id, body, type_id) VALUES(34, 'secret', 1);
INSERT INTO answers(id, body, type_id) VALUES(35, 'private', 2);
INSERT INTO answers(id, body, type_id) VALUES(36, 'protected', 2);
--Какое из нижеперечисленных ключевых слов используется для определения аннотации?
INSERT INTO answers(id, body, type_id) VALUES(37, '@interface', 1);
INSERT INTO answers(id, body, type_id) VALUES(38, '@annotation', 2);
INSERT INTO answers(id, body, type_id) VALUES(39, '@class', 2);
INSERT INTO answers(id, body, type_id) VALUES(40, '@definition', 2);
--Как расшифровывается HTML?
INSERT INTO answers(id, body, type_id) VALUES(41, 'HyperThread Mask Language', 2);
INSERT INTO answers(id, body, type_id) VALUES(42, 'HyperThread Markup Language', 2);
INSERT INTO answers(id, body, type_id) VALUES(43, 'HyperText Mask Language', 2);
INSERT INTO answers(id, body, type_id) VALUES(44, 'HyperText Markup Language', 1);
--Какое расширение должны иметь HTML документы?
INSERT INTO answers(id, body, type_id) VALUES(45, '.php или .asp', 2);
INSERT INTO answers(id, body, type_id) VALUES(46, '.txt или .doc', 2);
INSERT INTO answers(id, body, type_id) VALUES(47, '.doc', 2);
INSERT INTO answers(id, body, type_id) VALUES(48, '.html или .htm', 1);
--Какой тег позволяет вставлять картинки в HTML документы?
INSERT INTO answers(id, body, type_id) VALUES(49, '<pic>', 2);
INSERT INTO answers(id, body, type_id) VALUES(50, '<img>', 1);
INSERT INTO answers(id, body, type_id) VALUES(51, '<picture>', 2);
INSERT INTO answers(id, body, type_id) VALUES(52, '<image>', 2);
--Выберите ссылку с правильным синтаксисом.
INSERT INTO answers(id, body, type_id) VALUES(53, '<a href="http://www.wisdomweb.ru" value="wisdomweb.ru" />', 2);
INSERT INTO answers(id, body, type_id) VALUES(54, '<a name="http://www.wisdomweb.ru">wisdomweb.ru</a>', 2);
INSERT INTO answers(id, body, type_id) VALUES(55, '<a href="http://www.wisdomweb.ru">wisdomweb.ru</a>', 1);
INSERT INTO answers(id, body, type_id) VALUES(56, '<a src="http://www.wisdomweb.ru">wisdomweb.ru</a>', 2);
--С помощью какого тэга можно сделать текст жирным?
INSERT INTO answers(id, body, type_id) VALUES(57, '<b>', 1);
INSERT INTO answers(id, body, type_id) VALUES(58, '<i>', 2);
INSERT INTO answers(id, body, type_id) VALUES(59, '<big>', 2);
INSERT INTO answers(id, body, type_id) VALUES(60, '<h2>', 2);

INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 1);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 2);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 3);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 4);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 5);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 6);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 7);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 8);
INSERT INTO questions_answers(question_id, answers_id) VALUES(3, 9);
INSERT INTO questions_answers(question_id, answers_id) VALUES(3, 10);
INSERT INTO questions_answers(question_id, answers_id) VALUES(3, 11);
INSERT INTO questions_answers(question_id, answers_id) VALUES(3, 12);
INSERT INTO questions_answers(question_id, answers_id) VALUES(4, 13);
INSERT INTO questions_answers(question_id, answers_id) VALUES(4, 14);
INSERT INTO questions_answers(question_id, answers_id) VALUES(4, 15);
INSERT INTO questions_answers(question_id, answers_id) VALUES(4, 16);
INSERT INTO questions_answers(question_id, answers_id) VALUES(5, 17);
INSERT INTO questions_answers(question_id, answers_id) VALUES(5, 18);
INSERT INTO questions_answers(question_id, answers_id) VALUES(5, 19);
INSERT INTO questions_answers(question_id, answers_id) VALUES(5, 20);
INSERT INTO questions_answers(question_id, answers_id) VALUES(6, 21);
INSERT INTO questions_answers(question_id, answers_id) VALUES(6, 22);
INSERT INTO questions_answers(question_id, answers_id) VALUES(6, 23);
INSERT INTO questions_answers(question_id, answers_id) VALUES(6, 24);
INSERT INTO questions_answers(question_id, answers_id) VALUES(7, 25);
INSERT INTO questions_answers(question_id, answers_id) VALUES(7, 26);
INSERT INTO questions_answers(question_id, answers_id) VALUES(7, 27);
INSERT INTO questions_answers(question_id, answers_id) VALUES(7, 28);
INSERT INTO questions_answers(question_id, answers_id) VALUES(8, 29);
INSERT INTO questions_answers(question_id, answers_id) VALUES(8, 30);
INSERT INTO questions_answers(question_id, answers_id) VALUES(8, 31);
INSERT INTO questions_answers(question_id, answers_id) VALUES(8, 32);
INSERT INTO questions_answers(question_id, answers_id) VALUES(9, 33);
INSERT INTO questions_answers(question_id, answers_id) VALUES(9, 34);
INSERT INTO questions_answers(question_id, answers_id) VALUES(9, 35);
INSERT INTO questions_answers(question_id, answers_id) VALUES(9, 36);
INSERT INTO questions_answers(question_id, answers_id) VALUES(10, 37);
INSERT INTO questions_answers(question_id, answers_id) VALUES(10, 38);
INSERT INTO questions_answers(question_id, answers_id) VALUES(10, 39);
INSERT INTO questions_answers(question_id, answers_id) VALUES(10, 40);
INSERT INTO questions_answers(question_id, answers_id) VALUES(11, 41);
INSERT INTO questions_answers(question_id, answers_id) VALUES(11, 42);
INSERT INTO questions_answers(question_id, answers_id) VALUES(11, 43);
INSERT INTO questions_answers(question_id, answers_id) VALUES(11, 44);
INSERT INTO questions_answers(question_id, answers_id) VALUES(12, 45);
INSERT INTO questions_answers(question_id, answers_id) VALUES(12, 46);
INSERT INTO questions_answers(question_id, answers_id) VALUES(12, 47);
INSERT INTO questions_answers(question_id, answers_id) VALUES(12, 48);
INSERT INTO questions_answers(question_id, answers_id) VALUES(13, 49);
INSERT INTO questions_answers(question_id, answers_id) VALUES(13, 50);
INSERT INTO questions_answers(question_id, answers_id) VALUES(13, 51);
INSERT INTO questions_answers(question_id, answers_id) VALUES(13, 52);
INSERT INTO questions_answers(question_id, answers_id) VALUES(14, 53);
INSERT INTO questions_answers(question_id, answers_id) VALUES(14, 54);
INSERT INTO questions_answers(question_id, answers_id) VALUES(14, 55);
INSERT INTO questions_answers(question_id, answers_id) VALUES(14, 56);
INSERT INTO questions_answers(question_id, answers_id) VALUES(15, 57);
INSERT INTO questions_answers(question_id, answers_id) VALUES(15, 58);
INSERT INTO questions_answers(question_id, answers_id) VALUES(15, 59);
INSERT INTO questions_answers(question_id, answers_id) VALUES(15, 60);
