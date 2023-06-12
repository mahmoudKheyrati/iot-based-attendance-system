create keyspace if not exists attendance_system with replication = {'class': 'NetworkTopologyStrategy'};

create type if not exists Point(lat double, long double);

create table if not exists attendance_system.device
(
    id       uuid,
    name     text,
    location Point,
    cert     text,
    rules    set<text>,
    primary key ( id),
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
    id           uuid,
    first_name   text,
    last_name    text,
    email        text,
    phone_number text,
    caKeyHash    text,
    rules        set<text>,
    primary key ( id )
);

create index if not exists on attendance_system.employee (id) with options = {'unique': 'true'};

create table if not exists attendance_system.attendance_log
(
    timestamp     timestamp,
    employee_id   uuid,
    action        text,
    device_id     text,
    device_cert   text,
    employee_cert text,
    seen_by_admin boolean,
    primary key ( timestamp, employee_id, action )
);



create table attendance_system.admin_commands_log
(
    timestamp timestamp,
    device_id text,
    command   text,
    processed boolean,
    primary key (timestamp, command, processed)
);


