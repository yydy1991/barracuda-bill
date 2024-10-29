CREATE TABLE `bi_bill_type` (
                                `id` int unsigned NOT NULL AUTO_INCREMENT,
                                `name` varchar(64) DEFAULT NULL COMMENT '名称',
                                `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '编码',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账单类型表';

CREATE TABLE `bi_bill` (
                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `create_by` varchar(64) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_by` varchar(64) DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                           `bill_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账单类型',
                           `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
                           `del_flag` tinyint(1) DEFAULT NULL,
                           `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账单表';