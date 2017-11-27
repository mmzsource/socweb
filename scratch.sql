SELECT * from USER;

CREATE TABLE IF NOT EXISTS league
  (id   SERIAL UNIQUE,
   name VARCHAR(128),
   code VARCHAR(3),
   logo VARCHAR(256));

SELECT * FROM league;

INSERT INTO league (name, code, logo) VALUES ('Eredivisie', 'EDE', 'https://upload.wikimedia.org/wikipedia/commons/0/0f/Eredivisie_nieuw_logo_2017-.svg');

INSERT INTO league (name, code, logo) VALUES ('Premier League', 'PLE', 'https://upload.wikimedia.org/wikipedia/en/f/f2/Premier_League_Logo.svg');

INSERT INTO league (name, code, logo) VALUES ('Primera Division', 'PDN', 'https://upload.wikimedia.org/wikipedia/commons/9/92/LaLiga_Santander.svg');

INSERT INTO league (name, code, logo) VALUES ('1. Bundesliga', '1BL', 'https://upload.wikimedia.org/wikipedia/en/d/df/Bundesliga_logo_%282017%29.svg');

SELECT * FROM league;

SELECT id, name, code, logo FROM league;
