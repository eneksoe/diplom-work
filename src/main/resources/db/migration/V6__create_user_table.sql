create table if not exists user_account
(
id serial primary key,
username    varchar(20)     unique not null,
password    varchar(100)    not null,
active      boolean         not null,
created      timestamp       not null,
email       varchar(50)     not null
);

create table if not exists activation_link
(
id               serial primary key,
user_accaount_id bigint unique not null,
code             varchar(36)  not null,
created           timestamp     not null
);
