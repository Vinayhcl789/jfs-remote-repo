/*
    File Name   : login.sql
    Author      : Jakkula Vinay
    Created On  : 11-May-2026
    Description : Database schema for user login authentication
*/

-- =========================================
-- 1. USERS Table (Authentication)
-- =========================================

CREATE TABLE users (
    user_id        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username       VARCHAR2(50) NOT NULL UNIQUE,
    password       VARCHAR2(255) NOT NULL,   -- BCrypt hashed password
    email          VARCHAR2(100),
    status         VARCHAR2(20) DEFAULT 'ACTIVE',
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================
-- 2. Index for faster login lookup
-- =========================================

CREATE INDEX idx_users_username
ON users(username);

-- =========================================
-- 3. Sample User Insert
-- NOTE:
-- Password must be BCrypt-hashed from Java,
-- NOT manually typed.
-- =========================================

INSERT INTO users (username, password, email)
VALUES (
    'vinay',
