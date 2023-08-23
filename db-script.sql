-- DROP DATABASE IF EXISTS ext_platform;
 
CREATE DATABASE ext_platform
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.account (
	id bigint NOT NULL,
	account_number varchar NOT NULL,
	account_type varchar NOT NULL,
	parent_id bigint NULL,
	iso_country_code varchar(4) NULL,
	currency_code varchar(4) NULL,
	contact_email varchar NULL,
	contact_number varchar NULL,
	contact_name varchar NULL,
	ext_identifier varchar NULL,
	source_name varchar NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	CONSTRAINT account_pk PRIMARY KEY (id)
);
CREATE INDEX account_id_idx ON public.account (id,account_number,parent_id,ext_identifier);

CREATE TABLE public.request (
	id bigint NOT NULL,
	correlation_id varchar NOT NULL,
	source_name varchar NULL,
	file_endpoint varchar NULL,
	status int NULL,
	message varchar NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	CONSTRAINT request_pk PRIMARY KEY (id)
);
CREATE INDEX request_id_idx ON public.request (id,correlation_id);

CREATE TABLE public.vendor (
	id bigint NOT NULL,
	account_number varchar NOT NULL,
	iso_country_code varchar(4) NULL,
	currency_code varchar(4) NULL,
	contact_email varchar NULL,
	contact_number varchar NULL,
	contact_name varchar NULL,
	ext_identifier varchar NULL,
	source_name varchar NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	CONSTRAINT vendor_account_pk PRIMARY KEY (id)
);
CREATE INDEX vendor_id_idx ON public.vendor (id,account_number,ext_identifier);


CREATE TABLE public."subscription" (
	id bigint NOT NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	subscription_id varchar NOT NULL,
	billing_frequency varchar NULL,
	account_id bigint NOT NULL,
	vendor_id bigint NOT NULL,
	ext_identifier varchar NULL,
	source_name varchar NULL,
	CONSTRAINT subscription_pk PRIMARY KEY (id),
	CONSTRAINT subscription_fk FOREIGN KEY (account_id) REFERENCES public.account(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT subscription_fk_1 FOREIGN KEY (vendor_id) REFERENCES public.vendor(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX subscription_id_idx ON public."subscription" (id,subscription_id,account_id,vendor_id,ext_identifier);

CREATE TABLE public.subscription_item (
	id bigint NOT NULL,
	item_number varchar NULL,
	ingram_part_number varchar NULL,
	currency_code varchar NULL,
	mpn varchar NULL,
	quantity integer NULL,
	unit_price float8 NULL,
	unit_cost float8 NULL,
	discount_percentage float8 NULL,
	discounted_cost float8 NULL,
	is_reseller_centric bool NULL,
	vendor_name varchar NULL,
	subs_id bigint NOT NULL,
	expected_start_date timestamp(0) NULL,
    expected_end_date timestamp(0) NULL,
    actual_start_date timestamp(0) NULL,
    actual_end_date timestamp(0) NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	ext_identifier varchar NULL,
	is_renewable bool NULL,
	CONSTRAINT sub_item_pk PRIMARY KEY (id),
	CONSTRAINT sub_item_fk FOREIGN KEY (subs_id) REFERENCES public."subscription"(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX subs_item_id_idx ON public.subscription_item (id,item_number,subs_id,ext_identifier);

CREATE TABLE public.subscription_attribute (
	id bigint NOT NULL,
	"key" varchar NOT NULL,
	value varchar NULL,
	subs_id bigint NOT NULL,
	CONSTRAINT subs_attribute_pk PRIMARY KEY (id)
);
CREATE INDEX subs_attribute_subs_id_idx ON public.subscription_attribute (subs_id,id);

CREATE TABLE public.request_subscription_map (
	id bigint NOT NULL,
	request_id bigint NOT NULL,
	subscription_id bigint NOT NULL
);
CREATE INDEX request_subscription_map_id_idx ON public.request_subscription_map (id,request_id,subscription_id);


CREATE TABLE public.orders (
	id bigint NOT NULL,
	order_number varchar NOT NULL,
	state int NOT NULL,
	subscription_id bigint NULL,
	source_name varchar NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	completion_date timestamp(0) NULL,
	ext_identifier varchar NULL,
	CONSTRAINT order_pk PRIMARY KEY (id),
	CONSTRAINT order_fk FOREIGN KEY (subscription_id) REFERENCES public."subscription"(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX order_id_idx ON public.orders (id,order_number,subscription_id,ext_identifier);


CREATE TABLE public.order_item (
	id bigint NOT NULL,
	item_number varchar NULL,
	ingram_part_number varchar NULL,
	currency_code varchar NULL,
	mpn varchar NULL,
	quantity integer NULL,
	unit_price float8 NULL,
	unit_cost float8 NULL,
	discount_percentage float8 NULL,
	discounted_cost float8 NULL,
	is_reseller_centric bool NULL,
	vendor_name varchar NULL,
	order_id bigint NOT NULL,
	expected_start_date timestamp(0) NULL,
    expected_end_date timestamp(0) NULL,
    actual_start_date timestamp(0) NULL,
    actual_end_date timestamp(0) NULL,
	creation_date timestamp(0) NOT NULL,
	update_date timestamp(0) NULL,
	ext_identifier varchar NULL,
	is_renewable bool NULL,
	CONSTRAINT order_item_pk PRIMARY KEY (id),
	CONSTRAINT order_item_fk FOREIGN KEY (order_id) REFERENCES public.orders(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX order_item_id_idx ON public.order_item (id,item_number,order_id,ext_identifier);


CREATE TABLE public.account_attribute (
	id bigint NOT NULL,
	"key" varchar NOT NULL,
	value varchar NULL,
	account_id bigint NOT NULL,
	CONSTRAINT account_attribute_pk PRIMARY KEY (id),
	CONSTRAINT account_attribute_fk FOREIGN KEY (account_id) REFERENCES public.account(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX account_attribute_id_idx ON public.account_attribute (id,account_id);

CREATE TABLE public.order_attribute (
	id bigint NOT NULL,
	"key" varchar NOT NULL,
	value varchar NULL,
	order_id bigint NOT NULL,
	CONSTRAINT order_attribute_pk PRIMARY KEY (id),
	CONSTRAINT order_attribute_fk FOREIGN KEY (order_id) REFERENCES public.orders(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX order_attribute_order_id_idx ON public.order_attribute (order_id,id);

CREATE TABLE public.users
(
    id bigint NOT NULL,
    user_name varchar(30) NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(30),
    phone varchar(15),
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_unique UNIQUE (user_name)

)

CREATE UNIQUE INDEX unam_id_idx ON public.users (user_name);


CREATE SEQUENCE req_id_seq START 1;
CREATE SEQUENCE acc_id_seq START 1;
CREATE SEQUENCE acc_attr_id_seq START 1;
CREATE SEQUENCE order_id_seq START 1;
CREATE SEQUENCE order_attr_id_seq START 1;
CREATE SEQUENCE order_item_id_seq START 1;
CREATE SEQUENCE subs_id_seq START 1;
CREATE SEQUENCE subs_item_id_seq START 1;
CREATE SEQUENCE subs_attr_id_seq START 1;
CREATE SEQUENCE vendor_id_seq START 1;
CREATE SEQUENCE req_subs_id_seq START 1;
CREATE SEQUENCE user_id_seq START 1;