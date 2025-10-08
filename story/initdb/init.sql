
CREATE TABLE IF NOT EXISTS stories
(
    id         serial PRIMARY KEY,
    title      TEXT,
    body       TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO stories(title, body) VALUES ('Example Title 1', 'Example body 1');
INSERT INTO stories(title, body) VALUES ('Example Title 2', 'Example body 2');

