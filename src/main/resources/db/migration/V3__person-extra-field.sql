alter table persons add column if not exists uid varchar(40);
alter table persons add column if not exists email varchar(255);
alter table persons add column if not exists created_at timestamp;
alter table persons add column if not exists updated_at timestamp;
