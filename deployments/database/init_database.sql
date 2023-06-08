create keyspace if not exists attendance_system with replication = {'class': 'NetworkTopologyStrategy'};

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

create table if not exists attendance_system.employee
(
    id         uuid,
    first_name text,
    last_name  text,
    caKeyHash  text,
    rules      set<text>,
    primary key ( id )
);

create table if not exists attendance_system.attendance_log
(
    timestamp timestamp,
    user_id   uuid,
    action    text,
    seen_by_admin boolean,
    primary key ( timestamp, user_id, action )
);


create table attendance_system.admin_commands_log
(
    timestamp timestamp,
    command   text,
    processed boolean,
    primary key (timestamp, command, processed)
);


