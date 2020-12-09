create table orders (
    id int8 generated by default as identity,
    date date,
    email varchar(255),
    filename varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(255),
    total_price float8,
    user_id int8,
    primary key (id)
);
create table orders_product_list (
    order_id int8 not null,
    product_list_id int8 not null,
    product_list_order int4 not null,
    primary key (order_id, product_list_order)
);
create table product (
    id int8 not null,
    description varchar(255),
    filename varchar(255),
    product_category varchar(255),
    product_name varchar(255),
    price int4 not null,
    quantity varchar(255),
    primary key (id)
);
create table user_role (
    user_id int8 not null,
    roles varchar(255)
);
create table usr (
    id int8 not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);
create table user_product_list (
    user_id int8 not null,
    product_list_id int8 not null
);
create table news (
    id int8 not null,
    description varchar(255),
    filename varchar(255),
    title varchar (255),
    primary key (id)
);
