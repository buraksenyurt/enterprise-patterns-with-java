CREATE TABLE games (
    id               UUID         PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    platform         VARCHAR(50)  NOT NULL,
    total_copies     INT          NOT NULL,
    available_copies INT          NOT NULL
);

CREATE TABLE rentals (
    id                 UUID          PRIMARY KEY,
    game_id            UUID          NOT NULL,
    member_id          UUID          NOT NULL,
    rented_on          DATE          NOT NULL,
    due_on             DATE          NOT NULL,
    returned_on        DATE,
    status             VARCHAR(20)   NOT NULL,
    late_fee_amount    NUMERIC(10,2) NOT NULL,
    late_fee_currency  VARCHAR(3)    NOT NULL
);

CREATE INDEX idx_rentals_game_id ON rentals (game_id);