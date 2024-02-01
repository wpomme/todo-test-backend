CREATE TABLE IF NOT EXISTS status (
    status_id VARCHAR(32) PRIMARY KEY,
    status_name VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS task (
    task_id VARCHAR(32) PRIMARY KEY,
    description VARCHAR(1024),
    status_id VARCHAR(32),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
);