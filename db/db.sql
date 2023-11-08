CREATE TABLE genre (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE recipe (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    breakfast_flg smallint,
    lunch_flg smallint,
    dinner_flg smallint,
    material character varying(100) NOT NULL,
    spices character varying(100) NOT NULL,
    cook text NOT NULL,
    season_id character varying(30) NOT NULL,
    genre_id character varying(30) NOT NULL,
    memo character varying(100) DEFAULT NULL::character varying,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE public.season (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);