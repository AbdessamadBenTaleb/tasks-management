create index IX_73A2677F on ABT_Task (companyId, groupId, status);
create index IX_42BF7490 on ABT_Task (companyId, taskUserId);
create index IX_B25D216B on ABT_Task (companyId, userId);
create index IX_25EBCFCB on ABT_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7B2BCD0D on ABT_Task (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9610B423 on BTA_Task (companyId, groupId, status);
create index IX_C6B4D16C on BTA_Task (companyId, taskUserId);
create index IX_895B4C47 on BTA_Task (companyId, userId);
create index IX_FB4ED96F on BTA_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_144CEFB1 on BTA_Task (uuid_[$COLUMN_LENGTH:75$], groupId);