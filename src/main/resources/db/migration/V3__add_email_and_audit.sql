alter table persons add column if not exists email varchar(200) not null;
alter table persons add column if not exists created_at timestamp default current_timestamp;
alter table persons add column if not exists updated_at timestamp default current_timestamp;
