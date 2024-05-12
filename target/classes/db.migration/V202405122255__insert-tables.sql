-- Inserting IT Industry and skills
INSERT INTO industry (name, description) VALUES ('IT Industry', 'Information Technology Industry');
INSERT INTO skills (name, description, industry_id) VALUES ('Java', 'Java programming language', 1);
INSERT INTO skills (name, description, industry_id) VALUES ('Python', 'Python programming language', 1);
INSERT INTO skills (name, description, industry_id) VALUES ('MySQL', 'MySQL database management system', 1);

-- Inserting Consultancy Industry and skills
INSERT INTO industry (name, description) VALUES ('Consultancy', 'Consulting Services Industry');
INSERT INTO skills (name, description, industry_id) VALUES ('Consulting', 'Consulting skills', 2);
INSERT INTO skills (name, description, industry_id) VALUES ('Problem Solving', 'Problem-solving skills', 2);

-- Inserting Data Analyst Industry and skills
INSERT INTO industry (name, description) VALUES ('Data Analyst', 'Data Analysis Industry');
INSERT INTO skills (name, description, industry_id) VALUES ('Data Analysis', 'Data analysis skills', 3);
INSERT INTO skills (name, description, industry_id) VALUES ('Data Visualization', 'Data visualization skills', 3);
