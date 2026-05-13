/*
    File Name   : logout.sql
    Author      : Jakkula Vinay
    Created On  : 11-May-2026
    Description : SQL script to store user logout activity
*/

-- =========================================
-- 1. Logout Audit Table
-- =========================================

CREATE TABLE logout_audit (
    logout_id     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username      VARCHAR2(50) NOT NULL,
    logout_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ip_address    VARCHAR2(45),
    session_id    VARCHAR2(100)
);

-- =========================================
-- 2. Index for faster search (optional)
-- =========================================

CREATE INDEX idx_logout_user
ON logout_audit(username);

-- =========================================
-- 3. Sample Insert (called during logout)
-- =========================================

INSERT INTO logout_audit (username, ip_address, session_id)
VALUES ('vinay', '192.168.1.10', 'ABCD1234SESSION');

COMMIT;