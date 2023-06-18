create keyspace if not exists attendance_system with replication = {'class': 'NetworkTopologyStrategy', 'replication_factor': 1};

create type if not exists Point(lat double, long double);

create table if not exists attendance_system.device
(
    id       uuid,
    name     text,
    location Point,
    rules    set<text>,
    primary key (id, location),
);

CREATE MATERIALIZED VIEW attendance_system.device_by_name AS
  SELECT id, name
  FROM attendance_system.device
  WHERE name IS NOT NULL AND id IS NOT NULL
  PRIMARY KEY (name, id);


create table if not exists attendance_system.device_startup
(
    device_id            uuid,
    server_timestamp     timestamp,
    time_after_start_sec int,
    primary key ( device_id, server_timestamp )
);

create table if not exists attendance_system.admin
(
    username        uuid,
    password_hash   text,
    first_name      text,
    last_name       text,
    profile_picture blob,
    rules           set<text>,
    primary key ( username, password_hash)
);
create index if not exists on attendance_system.admin (username) with options = {'unique': 'true'};

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
create index if not exists on attendance_system.employee (card_uid) with options = {'unique': 'true'};

create table if not exists attendance_system.attendance_log
(
    timestamp        timestamp,
    device_id        text,
    card_uid         uuid,
    action           text,
    response_payload text,
    primary key ( timestamp, device_id, card_uid )
);

create table attendance_system.admin_commands_log
(
    device_id      text,
    command        text,
    admin_username text,
    command_payload text,
    timestamp      timestamp,
    primary key (device_id,command)
) with clustering order by (timestamp asc);

create table if not exists attendance_system.lock_opened_log
(
    device_id              text,
    server_timestamp       timestamp,
    time_after_startup_sec int,
    primary key ( device_id )
);

create table if not exists attendance_system.device_state_log
(
    device_id              text,
    server_timestamp       timestamp,
    time_after_startup_sec int,
    led_red                boolean,
    led_green              boolean,
    led_blue               boolean,
    primary key ( device_id )
) with clustering order by (server_timestamp asc );

