drop table if exists 'book'
drop table if exists 'book_log'
drop table if exists 'user'

create table 'book' (
	'id' bigint not null auto_increment,
	'create_at' datetime,
	'updated_at' datetime,
	'balance' integer,
	'memo' varchar(255),
	'title' varchar(255),
	'user_id' bigint,
	primary key ('id')
);

create table 'book_log' (
	'id' bigint not null auto_increment,
	'created_at' datetime,
	'updated_at' datetime,
	'category' varchar(255),
	'is_active' bit not null,
	'memo' varchar(255) not null,
	'money' integer not null,
	'money_type' bit not null,
	'book_id' bigint,
	primary key ('id')
);

create table 'user' (
	'id' bigint not null auto_increment,
	'created_at' datetime,
	'updated_at' datetime,
	'access_token' varchar(255),
	'authorities' varchar(255),
	'email' varchar(255),
	'password' varchar(255),
	primary key ('id')
);
