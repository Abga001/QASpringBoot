DROP TABLE IF EXISTS 'country' CASCADE;

CREATE TABLE 'country' (
    'id' INTEGER PRIMARY KEY AUTO_INCREMENT,
    'name' VARCHAR(255),
    'capital' VARCHAR(255),
    'population' INTEGER NOT NULL,
)