create keyspace if not exists attendance_system with replication = {'class': 'NetworkTopologyStrategy', 'replication_factor': 1};

use attendance_system;

create type if not exists attendance_system.Point(lat double, long double);


create table if not exists attendance_system.device
(
    id       text,
    name     text,
    location Point,
    rules    set<text>,
    primary key (id),
);

insert into attendance_system.device(id, location, name, rules)
VALUES ('42564aa8-2119-4ad9-b430-5ad89d90bf75', (0, 0), 'esp32-1', {});

CREATE MATERIALIZED VIEW attendance_system.device_by_name AS
SELECT id, name
FROM attendance_system.device
WHERE name IS NOT NULL
  AND id IS NOT NULL
PRIMARY KEY (name, id);


create table if not exists attendance_system.device_startup
(
    device_id            text,
    server_timestamp     timestamp,
    time_after_start_sec int,
    primary key ( device_id, server_timestamp )
);

create table if not exists attendance_system.admin
(
    username        text,
    password_hash   text,
    first_name      text,
    last_name       text,
    profile_picture blob,
    rules           set<text>,
    primary key ( username, password_hash)
);

create table if not exists attendance_system.employee
(
    card_uid     text,
    first_name   text,
    last_name    text,
    email        text,
    phone_number text,
    rules        set<text>,
    primary key ( card_uid )
);
insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('CA1B5FA3', 'mahmoud.kheyrati.fard@gmail.com', 'MahmoudReza', 'KheyratiFard', '+989384892109',
        {'42564aa8-2119-4ad9-b430-5ad89d90bf75'});

insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('291F9630', 'mahmoudKheyrati@gmail.com', 'MahmoudReza', 'KheyratiFard', '+989925136188',
        {'42564aa8-2119-4ad9-b430-5ad89d90bf75'});

insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('9C1E2E8F', 'yasinrezaie@gmail.com', 'Yasin', 'Rezaei', '+9898888888',
        {'42564aa8-2119-4ad9-b430-5ad89d90bf75'});

insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('F9BFFB30', 'yasinrezaie@gmail.com', 'Yasin', 'Rezaei', '+989162833195',
        {'42564aa8-2119-4ad9-b430-5ad89d90bf75'});

insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('39AE9530', 'arlotfi79@gmail.com', 'Alireza', 'Lotfi', '+9890000000', {});

insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('E961814A', 'maher@gmail.com', 'ali', 'maher', '+9890000000', {});
insert into attendance_system.employee(card_uid, email, first_name, last_name, phone_number, rules)
VALUES ('D92FB02A', 'sogol@gmail.com', 'sogol', 'bazrafshan', '+9890000000', {'42564aa8-2119-4ad9-b430-5ad89d90bf75'});

create table if not exists attendance_system.attendance_log
(
    timestamp        timestamp,
    device_id        text,
    card_uid         text,
    action           text,
    response_payload text,
    primary key ( timestamp, device_id, card_uid )
);

create table attendance_system.admin_commands_log
(
    device_id       text,
    command         text,
    admin_username  text,
    command_payload text,
    timestamp       timestamp,
    primary key (device_id, command, admin_username)
) with clustering order by (command asc, admin_username asc);

create table if not exists attendance_system.lock_opened_log
(
    device_id              text,
    card_uid               text,
    server_timestamp       timestamp,
    time_after_startup_sec int,
    primary key ( device_id ,card_uid,  server_timestamp, time_after_startup_sec)
) with clustering order by (card_uid asc, server_timestamp asc, time_after_startup_sec asc);

create table if not exists attendance_system.device_state_log
(
    device_id              text,
    server_timestamp       timestamp,
    time_after_startup_sec int,
    led_red                boolean,
    led_green              boolean,
    led_blue               boolean,
    primary key ( device_id , server_timestamp, time_after_startup_sec)
) with clustering order by (server_timestamp asc, time_after_startup_sec asc);

