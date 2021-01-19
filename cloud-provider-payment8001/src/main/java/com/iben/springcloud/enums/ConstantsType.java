package com.iben.springcloud.enums;

/**
 * 定义常量
 *
 * @author Ben
 * @create 2019-10-14 20:44
 **/
public class ConstantsType {
    /**
     * 数据状态枚举类
     */
    public enum DataStateEnum implements BaseEnum {
        //已删除标志
        DELETE_FLAG("1", "已删除"),
        //未删除标志
        EXIST_FLAG("0", "未删除");


        private final String key;
        private String value;

        DataStateEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }

    }

    /**
     * 用户状态枚举类
     */
    public enum UserStateEnum implements BaseEnum {
        //用户状态
        USER_NO_ACTIVE("0", "未激活"),
        USER_ACTIVE("1", "已激活"),
        //用户锁定
        USER_NO_LOCK("0", "未锁定"),
        USER_LOCK("1", "已锁定"),
        //用户性别
        USER_MALE("0", "男"),
        USER_FEMALE("1", "女");

        private final String key;
        private String value;

        UserStateEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }

    }

    /**
     * 角色权限枚举类
     */
    public enum PermissionEnum implements BaseEnum {
        //用户权限
        CREATE_PERMISSION("0", "create"),
        UPDATE_PERMISSION("1", "update"),
        SHOW_PERMISSION("2", "show"),
        DELETE_PERMISSION("3", "delete");

        private final String key;

        private String value;

        PermissionEnum(String key, String value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }
    }

    /**
     * 值班规则枚举类
     */
    public enum DutyRuleEnum implements BaseEnum {
        //人员排序
        PERSON_ASC_ORDER("0", "按照编码从小到大升序排序"),
        PERSON_RANDOM_ORDER("1", "随机排序"),
        PERSON_DESC_ORDER("2", "按照编码从大到小降序"),
        //下月排班编号起点
        DUTY_START_POINT_RESTART("0", "重新从人员列表首位开始值班"),
        DUTY_START_POINT_SEQUENCE("1", "根据上个月末人员值班记录顺序排班");

        private final String key;

        private String value;

        DutyRuleEnum(String key, String value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }
    }

    /**
     * 节假日枚举类
     */
    public enum HolidayEnum implements BaseEnum {
        //工作日 休息日
        WORK_DAY("0", "工作日"),
        REST_DAY("1", "休息日");

        private String key;

        private String value;

        HolidayEnum(String key, String value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }
    }

    /**
     * 数据字典枚举类
     */
    public enum DictEnum implements BaseEnum {
        //节点数据列表
        KEY_COMMON_DICT_NODE("common:dict:node:data", "节点数据列表"),
        KEY_COMMON_DICT_VALUE("common:dict:value:date", "键值对数据列表"),
        KEY_COMMON_DICT_TIME("common:dict:time", "字典最后更新时间");

        private final String key;

        private String value;

        DictEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public BaseEnum setValue(String value) {
            this.value = value;
            return this;
        }
    }
}
