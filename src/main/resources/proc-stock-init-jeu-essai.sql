create procedure init_jeu_essai
as
BEGIN
	declare @no_jeu INT;
	declare @no_client INT;
	declare @no_exemplaire INT;
delete from client;
delete from adresse;
delete from jeu_genre;
delete from exemplaire;
delete from jeu;
delete from genre;
insert into genre (no_genre, libelle) values (1, 'Jeu de plateau');
insert into genre (no_genre, libelle) values (2, 'Jeu de cartes');
insert into genre (no_genre, libelle) values (3, 'Jeu de stratégie');
insert into genre (no_genre, libelle) values (4, 'Coopératif');
insert into genre (no_genre, libelle) values (5, 'Jeu de dé');
insert into genre (no_genre, libelle) values (6, 'Jeu d''enquete');
insert into adresse(rue, code_postal, ville) values ('rue des Cormorans', '79000', 'Niort');
INSERT INTO client (nom, prenom, email, telephone, no_adresse) VALUES ('Curie', 'Marie', 'marie.curie@example.com', '123456789', scope_identity());
insert into adresse(rue, code_postal, ville) values ('rue des marguerites', '79500', 'Melle');
INSERT INTO client (nom, prenom, email, telephone, no_adresse) VALUES ('Einstein', 'Albert', 'albert.einstein@example.com', '0123456789', scope_identity());
insert into jeu (titre, description,reference, duree, age_min, tarif_jour) values ('Pandemic', 'Descr pandemic', 'refPandemic', 30,10, 12.5 );
select @no_jeu = no_jeu from jeu where reference='refPandemic';
insert into jeu_genre(no_jeu, no_genre) values (@no_jeu, 3);
insert into jeu_genre(no_jeu, no_genre) values (@no_jeu, 1);
insert into jeu (titre, description,reference, duree, age_min, tarif_jour) values ('Welcome', 'Descr welcome', 'refWelcome', 30,10, 9.3 );
select @no_jeu = no_jeu from jeu where reference='refWelcome';
insert into jeu_genre(no_jeu, no_genre) values (@no_jeu, 2);
insert into jeu_genre(no_jeu, no_genre) values (@no_jeu, 3);
insert into exemplaire (no_jeu, code_barre, louable) values (@no_jeu, '1111111111111', 1);
insert into exemplaire (no_jeu, code_barre, louable) values (@no_jeu, '2222222222222', 0);
insert into exemplaire (no_jeu, code_barre, louable) values (@no_jeu, '3333333333333', 1);
select @no_client = no_client from client where nom = 'Einstein';
select @no_exemplaire = no_exemplaire from exemplaire where code_barre= '1111111111111';
insert into location (no_client, no_exemplaire, tarif_jour, date_debut) values(@no_client, @no_exemplaire, 10.0, '20250323 14:00:00')
END;
