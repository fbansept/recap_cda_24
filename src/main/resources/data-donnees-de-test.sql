
INSERT INTO role (nom)
VALUES ("USER"), ("ADMIN"), ("CUSTOMER");

INSERT INTO utilisateur (code_client,pwd)VALUES
("toto","$2a$10$/Tw1vnuSMbPbi4/wkOdDa.7zti4iIXP3nZkwOU8.xq1Hi/GyCL03C"),
("titi","$2a$10$/Tw1vnuSMbPbi4/wkOdDa.7zti4iIXP3nZkwOU8.xq1Hi/GyCL03C"),
("tutu","$2a$10$/Tw1vnuSMbPbi4/wkOdDa.7zti4iIXP3nZkwOU8.xq1Hi/GyCL03C");

INSERT INTO utilisateur_liste_role (utilisateur_id, liste_role_id) VALUES
(1, 1), (1 , 2), (2, 1), (2, 3);