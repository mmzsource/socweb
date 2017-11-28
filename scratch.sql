SELECT * from USER;

CREATE TABLE IF NOT EXISTS league
  (id        SERIAL UNIQUE,
   name      VARCHAR(32),
   code      VARCHAR(3),
   logo      VARCHAR(128),
   standings VARCHAR(128));

DROP TABLE league;

SELECT * FROM league;

INSERT INTO league (name, code, logo, standings)
  VALUES
  ('Eredivisie',
   'EDE',
   'https://upload.wikimedia.org/wikipedia/commons/0/0f/Eredivisie_nieuw_logo_2017-.svg',
   'http://www.skysports.com/eredivisie-table');

INSERT INTO league (name, code, logo, standings)
  VALUES
  ('Premier League',
   'PLE',
   'https://upload.wikimedia.org/wikipedia/en/f/f2/Premier_League_Logo.svg',
   'http://www.skysports.com/premier-league-table');

INSERT INTO league (name, code, logo, standings)
  VALUES
  ('Primera Division',
   'PDN',
   'https://upload.wikimedia.org/wikipedia/commons/9/92/LaLiga_Santander.svg',
   'http://www.skysports.com/la-liga-table');

INSERT INTO league (name, code, logo, standings)
  VALUES
  ('1. Bundesliga',
   '1BL',
   'https://upload.wikimedia.org/wikipedia/en/d/df/Bundesliga_logo_%282017%29.svg',
   '');

SELECT * FROM league;

SELECT id, name, code, logo FROM league;
