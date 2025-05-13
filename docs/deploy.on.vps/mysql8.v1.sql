create table association_value_entry
(
    id                bigint       not null
        primary key,
    association_key   varchar(255) not null,
    association_value varchar(255) null,
    saga_id           varchar(255) not null,
    saga_type         varchar(255) null
);

create index IDXgv5k1v2mh6frxuy5c0hgbau94
    on association_value_entry (saga_id, saga_type);

create index IDXk45eqnxkgd8hpdn6xixn8sgft
    on association_value_entry (saga_type, association_key, association_value);

create table association_value_entry_seq
(
    next_val bigint null
);

create table dead_letter_entry
(
    dead_letter_id       varchar(255)  not null
        primary key,
    cause_message        varchar(1023) null,
    cause_type           varchar(255)  null,
    diagnostics          blob          null,
    enqueued_at          datetime(6)   not null,
    last_touched         datetime(6)   null,
    aggregate_identifier varchar(255)  null,
    event_identifier     varchar(255)  not null,
    message_type         varchar(255)  not null,
    meta_data            blob          null,
    payload              blob          not null,
    payload_revision     varchar(255)  null,
    payload_type         varchar(255)  not null,
    sequence_number      bigint        null,
    time_stamp           varchar(255)  not null,
    token                blob          null,
    token_type           varchar(255)  null,
    type                 varchar(255)  null,
    processing_group     varchar(255)  not null,
    processing_started   datetime(6)   null,
    sequence_identifier  varchar(255)  not null,
    sequence_index       bigint        not null,
    constraint UKhlr8io86j74qy298xf720n16v
        unique (processing_group, sequence_identifier, sequence_index)
);

create index IDXe67wcx5fiq9hl4y4qkhlcj9cg
    on dead_letter_entry (processing_group);

create index IDXrwucpgs6sn93ldgoeh2q9k6bn
    on dead_letter_entry (processing_group, sequence_identifier);

create table domain_event_entry
(
    global_index         bigint       not null
        primary key,
    event_identifier     varchar(255) not null,
    meta_data            blob         null,
    payload              blob         not null,
    payload_revision     varchar(255) null,
    payload_type         varchar(255) not null,
    time_stamp           varchar(255) not null,
    aggregate_identifier varchar(255) not null,
    sequence_number      bigint       not null,
    type                 varchar(255) null,
    constraint UK8s1f994p4la2ipb13me2xqm1w
        unique (aggregate_identifier, sequence_number),
    constraint UK_fwe6lsa8bfo6hyas6ud3m8c7x
        unique (event_identifier)
);

create table domain_event_entry_seq
(
    next_val bigint null
);

create table saga_entry
(
    saga_id         varchar(255) not null
        primary key,
    revision        varchar(255) null,
    saga_type       varchar(255) null,
    serialized_saga blob         null
);

create table snapshot_event_entry
(
    aggregate_identifier varchar(255) not null,
    sequence_number      bigint       not null,
    type                 varchar(255) not null,
    event_identifier     varchar(255) not null,
    meta_data            blob         null,
    payload              blob         not null,
    payload_revision     varchar(255) null,
    payload_type         varchar(255) not null,
    time_stamp           varchar(255) not null,
    primary key (aggregate_identifier, sequence_number, type),
    constraint UK_e1uucjseo68gopmnd0vgdl44h
        unique (event_identifier)
);

create table tenants
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    active              bit          null,
    description         text         null,
    domain              varchar(255) null,
    language            varchar(255) null,
    name                varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint UK_4moql6miwoh3w0drxa2gmjbll
        unique (name),
    constraint FK4q20pfwnyvwvptoh8hjbxqsay
        foreign key (tenant_id) references tenants (id)
);

create table token_entry
(
    processor_name varchar(255) not null,
    segment        int          not null,
    owner          varchar(255) null,
    timestamp      varchar(255) not null,
    token          blob         null,
    token_type     varchar(255) null,
    primary key (processor_name, segment)
);

create table users
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    password            varchar(255) not null,
    username            varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FK21hn1a5ja1tve7ae02fnn4cld
        foreign key (tenant_id) references tenants (id),
    constraint FK8nakkftyppd62ke6tv7oo5a92
        foreign key (created_by_id) references users (id)
);

create table accounts
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    currency            varchar(250) not null,
    current_balance     double       not null,
    details             varchar(250) null,
    is_active           bit          not null,
    name                varchar(250) not null,
    previous_balance    double       not null,
    reference           varchar(255) null,
    updated_at          datetime(6)  null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FK9cdq3yoyrbt02qcs70okuh0fi
        foreign key (created_by_id) references users (id),
    constraint FKsw0lwjbtx192vq7wt1i90hoj
        foreign key (tenant_id) references tenants (id)
);

create table account_users
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    details             varchar(250) null,
    is_active           bit          not null,
    name                varchar(250) not null,
    reference           varchar(255) null,
    updated_at          datetime(6)  null,
    username            varchar(250) null,
    account_id          varchar(255) null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    user_id             varchar(255) null,
    constraint FK24na9y3o2dsj55bq7gkanwb7d
        foreign key (account_id) references accounts (id),
    constraint FK7ifp1lwvdxyh00ixq33mquidn
        foreign key (tenant_id) references tenants (id),
    constraint FKk49uh4thswiqchj2ml67wyxwh
        foreign key (created_by_id) references users (id),
    constraint FKqsjt5rp5y9ab708pr5rypa45s
        foreign key (user_id) references users (id)
);

create table api_keys
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    active              bit          not null,
    app_key             text         not null,
    created_at          datetime(6)  not null,
    expiration          datetime(6)  not null,
    username            varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FK73fmnbrbm5rogwognfn6vs3j
        foreign key (tenant_id) references tenants (id),
    constraint FKpy9cxsxjdwoirwbdr9u0umdc
        foreign key (created_by_id) references users (id)
);

create table categories
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    details             varchar(250) null,
    is_active           bit          not null,
    name                varchar(250) not null,
    reference           varchar(255) null,
    type_category_raw   varchar(250) null,
    updated_at          datetime(6)  null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FKb07hhhlceyn1pkhlw2xb99par
        foreign key (created_by_id) references users (id),
    constraint FKslnulryuuh7tq6tgyusgfk336
        foreign key (tenant_id) references tenants (id)
);

create table password_resets
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    expiration          datetime(6)  not null,
    token               text         not null,
    username            varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FKehltoshq2qdm63u64ea0q1oex
        foreign key (created_by_id) references users (id),
    constraint FKmsn1srjh0recwehwhd1kiky6t
        foreign key (tenant_id) references tenants (id)
);

create table permissions
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    name                varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FK6clx7crol7q58xoytg2mkngm4
        foreign key (tenant_id) references tenants (id),
    constraint FKd47ga816o7ne1vb2mtba16o89
        foreign key (created_by_id) references users (id)
);

create table refresh_tokens
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    expiration          datetime(6)  not null,
    token               text         not null,
    username            varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FK2fapngvfqcb44pbcrkuwaprdt
        foreign key (tenant_id) references tenants (id),
    constraint FKmpjip88pp97iqvdnrheab09bh
        foreign key (created_by_id) references users (id)
);

create table roles
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    name                varchar(255) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FKdmkr4ngbb21kad02beprkxghs
        foreign key (created_by_id) references users (id),
    constraint FKmvypqr2nolkxxru0qnbw8rh5m
        foreign key (tenant_id) references tenants (id)
);

create table role_permissions
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    created_by_id       varchar(255) null,
    permission_id       varchar(255) not null,
    role_id             varchar(255) not null,
    tenant_id           varchar(255) null,
    constraint FK447jhnh78wh4v4xlbo437wqha
        foreign key (tenant_id) references tenants (id),
    constraint FKegdk29eiy7mdtefy5c7eirr6e
        foreign key (permission_id) references permissions (id),
    constraint FKf89l0isdcs08n9q954duabi6u
        foreign key (created_by_id) references users (id),
    constraint FKn5fotdgk8d1xvo8nav9uv3muc
        foreign key (role_id) references roles (id)
);

create table settings
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    details             varchar(250) null,
    is_active           bit          not null,
    locale              varchar(250) not null,
    name                varchar(250) not null,
    reference           varchar(255) null,
    updated_at          datetime(6)  null,
    value               varchar(250) not null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    constraint FKkb5lu0g3ooq1n0exs3nmbomxi
        foreign key (created_by_id) references users (id),
    constraint FKp1hf5tg8hliwjexq7w7s8e0b3
        foreign key (tenant_id) references tenants (id)
);

alter table tenants
    add constraint FK2osep4x9x7a2i7xot0pjeqyg7
        foreign key (created_by_id) references users (id);

create table transactions
(
    id                   varchar(255) not null
        primary key,
    created_at_audit     datetime(6)  null,
    deleted_at_audit     datetime(6)  null,
    deleted_audit        bit          null,
    deleted_by_audit     varchar(255) null,
    source_system_audit  varchar(255) null,
    status_audit         varchar(255) null,
    updated_at_audit     datetime(6)  null,
    updated_by_audit     varchar(255) null,
    version_audit        varchar(255) null,
    amount               double       not null,
    date_transaction     datetime(6)  null,
    details              varchar(250) null,
    is_active            bit          not null,
    name                 varchar(250) not null,
    reference            varchar(255) null,
    type_transaction_raw varchar(250) null,
    updated_at           datetime(6)  null,
    account_id           varchar(255) null,
    category_id          varchar(255) null,
    created_by_id        varchar(255) null,
    tenant_id            varchar(255) null,
    constraint FK20w7wsg13u9srbq3bd7chfxdh
        foreign key (account_id) references accounts (id),
    constraint FK95o9d27cfwiw110yl5s9xkhpm
        foreign key (tenant_id) references tenants (id),
    constraint FKhxwmv67gqo1p5gx5hent905hy
        foreign key (created_by_id) references users (id),
    constraint FKsqqi7sneo04kast0o138h19mv
        foreign key (category_id) references categories (id)
);

create table transaction_users
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    details             varchar(250) null,
    is_active           bit          not null,
    name                varchar(250) not null,
    reference           varchar(255) null,
    updated_at          datetime(6)  null,
    username            varchar(250) null,
    created_by_id       varchar(255) null,
    tenant_id           varchar(255) null,
    transaction_id      varchar(255) null,
    user_id             varchar(255) null,
    constraint FK16lnuhk109d9g9u5uo32kgblu
        foreign key (transaction_id) references transactions (id),
    constraint FK5oyeyouvgybdq6a29f5g5tf88
        foreign key (created_by_id) references users (id),
    constraint FKarg1a3olumxgssmeytfjeffyk
        foreign key (tenant_id) references tenants (id),
    constraint FKd7ujh1pqonus22glxh9182eom
        foreign key (user_id) references users (id)
);

create table user_roles
(
    id                  varchar(255) not null
        primary key,
    created_at_audit    datetime(6)  null,
    deleted_at_audit    datetime(6)  null,
    deleted_audit       bit          null,
    deleted_by_audit    varchar(255) null,
    source_system_audit varchar(255) null,
    status_audit        varchar(255) null,
    updated_at_audit    datetime(6)  null,
    updated_by_audit    varchar(255) null,
    version_audit       varchar(255) null,
    created_by_id       varchar(255) null,
    role_id             varchar(255) not null,
    tenant_id           varchar(255) null,
    user_id             varchar(255) not null,
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id),
    constraint FKk3vhi4t5kuw61mr39qbywpxnl
        foreign key (tenant_id) references tenants (id),
    constraint FKtm1qif68odl7fldyu8vgutf8r
        foreign key (created_by_id) references users (id)
);

