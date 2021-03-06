--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
-- insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 

CREATE SCHEMA mysqllib;
insert into Book (isbn, title, author, genre, shelf, copies, picUrl) values ('9781408711392', 'Fire and Fury: Inside the Trump White House', 'Michael Wolff', 'Politic', 'FMP-10', '10', 'https://s2.adlibris.com/images/38919617/fire-and-fury.jpg')
insert into Book (isbn, title, author, genre, shelf, copies, picUrl) values ('9789144052601', 'Skarp programmering med C#', 'Jan Skansholm', 'Datorer & IT', 'YMB-10', '2', 'https://s1.adlibris.com/images/446588/skarp-programmering-med-c.jpg')
insert into Book (isbn, title, author, genre, shelf, copies, picUrl) values ('9789144085876', 'Java : step by step', 'Luke Harding', 'Datorer & IT', 'CLP-10', '10', 'https://s1.adlibris.com/images/1157627/java-steg-for-steg.jpg')
insert into Book (isbn, title, author, genre, shelf, copies, picUrl) values ('9781471166945', 'What Happened','Hillary Rodham Clinton', 'Politic', 'WHP-10', '4', 'https://s1.adlibris.com/images/30796467/what-happened.jpg')

insert into User (firstName, lastName, email, password) values ('Erik', 'Thompson', 'erik@gmail.com', '290303') 
insert into User (firstName, lastName, email, password) values ('Tommy', 'Steger', 'tommysteger@gmail.com', '660306') 

--insert into Loan(book_id, user_id, startDate, endDate, returned) values(1, 2, "2017-12-05", "2017-12-19", false)
--insert into Loan(book_id, user_id, startDate, endDate, returned) values(2, 2, "2017-11-05", "2017-11-19", true)
--insert into Loan(book_id, user_id, startDate, endDate, returned) values(1, 2, "2018-01-05", "2018-01-19", false)
--insert into Loan(book_id, user_id, startDate, endDate, returned) values(1, 1, "2018-01-01", "2018-01-15", false)
--insert into Loan(book_id, user_id, startDate, endDate, returned) values(1, 1, "2017-01-01", "2017-01-15", false)
