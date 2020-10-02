create database BDUE;

use BDUE;

create table cliente(id int primary key auto_increment,
nome varchar(50),
email varchar(50) unique,
image varchar(250));
)

insert into cliente values(null,'lu','lu@gmail.com',
'https://randomuser.me/api/portraits/women/2.jpg'
);


insert into cliente values(null,'andre','andre@gmail.com',
'https://randomuser.me/api/portraits/men/64.jpg'
);

insert into cliente values(null,'fabiana','fabiana@gmail.com',
'https://randomuser.me/api/portraits/women/68.jpg'
);

select* from cliente