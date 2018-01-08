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
insert into Book (isbn, title, author, genre, shelf, copies) values ('1250158060', 'Fire and Fury: Inside the Trump White House', 'Michael Wolff', 'Politic', 'FMP-10', '10')
insert into Book (isbn, title, author, genre, shelf, copies) values ('0801075254', 'Your Best Year Ever: A 5-Step Plan for Achieving Your Most Important Goals', 'Michael Hyatt', 'Business & Money', 'YMB-10', '2')

insert into User (firstName, lastName, email, password) values ('Erik', 'Thompson', 'erik@gmail.com', '290303') 
insert into User (firstName, lastName, email, password) values ('Tommy', 'Steger', 'tommysteger@gmail.com', '660306') 