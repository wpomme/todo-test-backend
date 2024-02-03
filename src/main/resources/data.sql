INSERT INTO
  status (id, status) VALUES
      ('01', 'active')
    , ('02', 'invalid')
    , ('03', 'error');

INSERT INTO
  task (id, description, status_id) VALUES
      ('01', 'aaa', '01')
    , ('02', 'bbb', '01')
    , ('03', 'ccc', '01');