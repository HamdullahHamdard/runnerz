CREATE TABLE IF NOT EXISTS Run(
    id INT NOT NULL,
    title varchar(300) NOT NULL,
    started_on timestamp NOT NULL,
    complated_on timestamp NOT NULL,
    miles int NOT NULL,
    location varchar(10) NOT NULL,
    PRIMARY KEY (id)
);
 