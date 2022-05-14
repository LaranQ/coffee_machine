CREATE SEQUENCE IF NOT EXISTS public.coffee_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 32767
    CACHE 1
    OWNED BY coffee.id;

CREATE SEQUENCE IF NOT EXISTS public.coffee_machine_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 32767
    CACHE 1
    OWNED BY coffee_machine.id;

CREATE SEQUENCE IF NOT EXISTS public.coffee_orders_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY coffee_orders.id;

CREATE TABLE IF NOT EXISTS public.coffee(
    id smallint NOT NULL DEFAULT nextval('coffee_id_seq'::regclass),
    name character varying(16) COLLATE pg_catalog."default",
    water smallint NOT NULL DEFAULT 25,
    milk smallint NOT NULL DEFAULT 0,
    beans smallint NOT NULL DEFAULT 10,
    CONSTRAINT coffee_pkey PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS public.coffee_machine(
    id smallint NOT NULL DEFAULT nextval('coffee_machine_id_seq'::regclass),
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    water smallint NOT NULL DEFAULT 0,
    milk smallint NOT NULL DEFAULT 0,
    beans smallint NOT NULL DEFAULT 0,
    count_before_dirty smallint NOT NULL DEFAULT 5,
    CONSTRAINT coffee_machine_pkey PRIMARY KEY (id),
    CONSTRAINT coffee_machine_check_high_border CHECK (water < 10000 AND milk < 3000 AND beans < 2000) NOT VALID,
    CONSTRAINT coffee_machine_check_lower_border CHECK (water >= 0 AND milk >= 0 AND beans >= 0) NOT VALID,
    CONSTRAINT coffee_machine_count_before_dirty_check CHECK (count_before_dirty >= 0 AND count_before_dirty < 6) NOT VALID);

CREATE TABLE IF NOT EXISTS public.coffee_orders(
    id integer NOT NULL DEFAULT nextval('coffee_orders_id_seq'::regclass),
    coffee smallint,
    coffee_machine smallint,
    date timestamp(0) without time zone NOT NULL DEFAULT now(),
    CONSTRAINT coffee_orders_pkey PRIMARY KEY (id),
    CONSTRAINT coffee_orders_coffee_fkey FOREIGN KEY (coffee)
    REFERENCES public.coffee (id) MATCH SIMPLE
                      ON UPDATE CASCADE
                      ON DELETE SET NULL
    NOT VALID,
    CONSTRAINT coffee_orders_coffee_machine_fkey FOREIGN KEY (coffee_machine)
    REFERENCES public.coffee_machine (id) MATCH SIMPLE
                      ON UPDATE CASCADE
                      ON DELETE SET NULL
    NOT VALID);
