create  table books (accNo number (10) constraint accessionNumber Primary Key, bookTitle  varchar2(100) not null, authorName varchar2(100) default 'NA' ,publisherName varchar2(500) not null, noc number(6) constraint checkNoc check(noc>=0));



create table members(email varchar2(15) constraint emailPK Primary Key,firstName VARCHAR2(100) not null,lastName varchar2(100),dob date constraint DOB not null, password varchar2(25));



create table books_issue (issueId varchar2(10) constraint issuePK Primary Key, AccNo number references books,email varchar2(15) references members,dbi date not null,dbr date not null, odbr date, fine number (3,1) default 0);




