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

INSERT INTO users(id, username, password) VALUES(1, 'admin', '$2a$10$dKFNExPwV2sxFVhKAQN2Je42IQ.y644hVRXk5ridNOtpmLp.M/7yy');
INSERT INTO users(id, username, password) VALUES(2, 'moder', '$2a$10$ZsiTVZl4i5D9yjNbZAZuI.2tcMAqX4pf7el0N7DN.G6l.I9omcjfK');
INSERT INTO users(id, username, password) VALUES(3, 'user', '$2a$10$GMy3UJXfTUYZuXNmGFdD9.ri9wWPhfoYWTe6/7wuY4z7RFTn3rh26');

INSERT INTO users_roles(user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES(1, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(2, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES(2, 3);
INSERT INTO users_roles(user_id, roles_id) VALUES(3, 3);

INSERT INTO questions(id, body, status_id, subject_id) VALUES(1, 'Каков размер данных типа char?', 1, 1);
INSERT INTO questions(id, body, status_id, subject_id) VALUES(2, 'Какое из следующих утверждений верно для класса: java.util.ArrayList?', 2, 1);

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

INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 1);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 2);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 3);
INSERT INTO questions_answers(question_id, answers_id) VALUES(1, 4);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 5);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 6);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 7);
INSERT INTO questions_answers(question_id, answers_id) VALUES(2, 8);
