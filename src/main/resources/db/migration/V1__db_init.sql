CREATE TABLE bank_account(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) DEFAULT NULL,
    last_name VARCHAR(20) DEFAULT NULL,
    balance NUMERIC(39,2) DEFAULT 0.00,
    account_number VARCHAR(10) NOT NULL
);

CREATE TABLE transaction(
    id BIGSERIAL PRIMARY KEY,
    transaction_reference VARCHAR(20) NOT NULL,
    amount NUMERIC(39,2) DEFAULT 0.00,
    transaction_fee NUMERIC(39,2) DEFAULT 0.00,
    billed_amount NUMERIC(39,2) DEFAULT 0.00,
    description VARCHAR(50) DEFAULT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT NULL,
    commission_worthy BOOLEAN DEFAULT FALSE,
    commission NUMERIC(39,2) DEFAULT 0.00
);

CREATE TABLE transfer(
    id SERIAL PRIMARY KEY,
    source_account VARCHAR(10) NOT NULL,
    destination_account VARCHAR(10) NOT NULL,
    amount NUMERIC(39,2) NOT NULL,
    description VARCHAR(100) DEFAULT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT NULL
);