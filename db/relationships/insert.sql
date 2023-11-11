INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO rights (name) VALUES ('read');
INSERT INTO rights (name) VALUES ('write');
INSERT INTO rights (name) VALUES ('addition');
INSERT INTO rights (name) VALUES ('delete');

INSERT INTO roles_rights (fk_role, fk_right) VALUES (1, 1);
INSERT INTO roles_rights (fk_role, fk_right) VALUES (1, 2);
INSERT INTO roles_rights (fk_role, fk_right) VALUES (1, 3);
INSERT INTO roles_rights (fk_role, fk_right) VALUES (1, 4);
INSERT INTO roles_rights (fk_role, fk_right) VALUES (2, 1);
INSERT INTO roles_rights (fk_role, fk_right) VALUES (2, 2);

INSERT INTO users (name, fk_role) VALUES ('USER1', 1);
INSERT INTO users (name, fk_role) VALUES ('USER2', 2);

INSERT INTO categories (category) VALUES ('purchase');
INSERT INTO categories (category) VALUES ('sale');

INSERT INTO states (state) VALUES ('accepted for processing');
INSERT INTO states (state) VALUES ('sales');
INSERT INTO states (state) VALUES ('not for sale');

INSERT INTO items (name, fk_user, fk_category, fk_state) VALUES ('Fone', 2, 2, 1);

INSERT INTO comments (comment, fk_item) VALUES ('...', 1);

INSERT INTO attachments (attachment, fk_item) VALUES ('IMG', 1);
INSERT INTO attachments (attachment, fk_item) VALUES ('Video', 1);