
SELECT * FROM employee WHERE id = ?;
INSERT INTO employee VALUES(?,?,?,?,?,?);
UPDATE employee SET org_id, fisrt_name, last_name, emp_position, is_married, years_in_company VALUES(?, ?, ?, ?, ?, ?) WHERE id=? AND org_id =?;
DELETE FROM employee WHERE id = ?;
DELETE FROM employee WHERE org_id = ?;
SELECT * FROM employee;
SELECT * FROM employee WHERE org_id = ?;

SELECT * FROM organization WHERE id = ?;
INSERT INTO organization VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
UPDATE organization SET org_name, org_phone, org_address, country, city, is_active, area_of_activity, number_of_offices, region VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?;
DELETE FROM organization WHERE id = ?;
SELECT * FROM organization;
