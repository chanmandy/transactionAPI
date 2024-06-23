CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `document_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `operation_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(120) NOT NULL,
  `ledger_entry` enum('CREDIT','DEBIT') NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(38,2) NOT NULL,
  `event_date` datetime(6) NOT NULL,
  `account_id` bigint NOT NULL,
  `operation_type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_transaction_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_transaction_oprtype` FOREIGN KEY (`operation_type_id`) REFERENCES `operation_type` (`id`)
);

INSERT INTO operation_type(id, description, ledger_entry) VALUES (1, 'Normal Purchase', 'DEBIT');
INSERT INTO operation_type(id, description, ledger_entry) VALUES (2, 'Purchase with installments', 'DEBIT');
INSERT INTO operation_type(id, description, ledger_entry) VALUES (3, 'Withdrawal', 'DEBIT');
INSERT INTO operation_type(id, description, ledger_entry) VALUES (4, 'Credit Voucher', 'CREDIT');