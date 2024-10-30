CREATE TABLE `bi_bill_type` (
                                `id` int unsigned NOT NULL AUTO_INCREMENT,
                                `name` varchar(64) DEFAULT NULL COMMENT '名称',
                                `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '编码',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账单类型表';

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
    (2000, '账单', 0, 5, '#', 'menuItem', 'M', '0', '1', NULL, 'fa fa-credit-card-alt', 'admin', '2024-10-25 23:12:36', '', NULL, '');

INSERT INTO `bi_bill_type` (`id`, `name`, `code`)
VALUES
    (1, '餐饮美食', '0001'),
    (2, '服饰装扮', '0002'),
    (3, '日用百货', '0003'),
    (4, '家居家装', '0004'),
    (5, '数码电器', '0005'),
    (6, '运动户外', '0006'),
    (7, '美容美发', '0007');

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