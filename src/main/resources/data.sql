INSERT INTO
  status (id, status) VALUES
      ('01', 'active')
    , ('02', 'invalid')
    , ('03', 'error');

INSERT INTO
  task (id, title, description, status_id) VALUES
      ('01', 'aaa', 'foo', '01')
    , ('02', 'bbb', 'bar', '01')
    , ('03', 'ccc', 'baz', '01');