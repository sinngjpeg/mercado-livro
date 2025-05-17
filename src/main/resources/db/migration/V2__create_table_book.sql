CREATE TABLE book(
    id int auto_increment primary key,
    name varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id int not null,
    foreign key (customer_id) references customer(id)
);

