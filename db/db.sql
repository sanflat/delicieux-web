CREATE TABLE genre (
    id SERIAL NOT NULL,
    name character varying(30) NOT NULL,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE recipe (
    id SERIAL NOT NULL,
    name character varying(30) NOT NULL,
    breakfast_flg smallint,
    lunch_flg smallint,
    dinner_flg smallint,
    material character varying(100) NOT NULL,
    spices character varying(100) NOT NULL,
    cook text NOT NULL,
    season_id integer NOT NULL,
    genre_id integer NOT NULL,
    memo character varying(100) DEFAULT NULL::character varying,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE recipe_set_recipe_board (
    recipe_set_id integer NOT NULL,
    recipe_id integer NOT NULL,
    board_id integer NOT NULL
);

CREATE TABLE board (
    id integer NOT NULL,
    name character varying(30) NOT NULL
);

INSERT INTO board(id, name) VALUES
(1,'SELECTED'),
(2,'MONDAY'),
(3,'TUESDAY'),
(4,'WEDNESDAY'),
(5,'THURSDAY'),
(6,'FRIDAY'),
(7,'SATURDAY'),
(8,'SUNDAY');

CREATE TABLE recipe_set (
    id SERIAL NOT NULL,
    name character varying(30) NOT NULL,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE season (
    id SERIAL NOT NULL,
    name character varying(30) NOT NULL,
    deleted_at timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
