CREATE DATABASE delicious_food_recipes;
USE delicious_food_recipes;

CREATE TABLE recipe(
    id INTEGER PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    cost INTEGER NULL,
    calorie INTEGER NULL,
    material_id INTEGER NOT NULL,
    spices_id INTEGER NOT NULL,
    cook_id INTEGER NOT NULL,
    season_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL, 
    review_id INTEGER NOT NULL,
    deleted_at TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE recipe_index (name)
);