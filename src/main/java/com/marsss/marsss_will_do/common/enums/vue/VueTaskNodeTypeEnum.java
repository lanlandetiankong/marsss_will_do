package com.marsss.marsss_will_do.common.enums.vue;

/**
 * 任务节点的类型配置
 */
public enum VueTaskNodeTypeEnum {
    PRIMARY(false,"bottom","primary","",""),
    SUCCESS(false,"bottom","success","",""),
    WARNING(false,"bottom","warning","",""),
    DANGGER(false,"bottom","danger","",""),
    INFO(false,"bottom","info","","");
    ;

    VueTaskNodeTypeEnum(boolean hideTimestamp, String placement, String type, String color, String icon) {
        this.hideTimestamp = hideTimestamp;
        this.placement = placement;
        this.type = type;
        this.color = color;
        this.icon = icon;
    }

    //是否隐藏时间戳
    private boolean hideTimestamp ;
    //时间戳位置 top,bottom
    private String placement ;
    //节点类型: primary / success / warning / danger / info
    private String type ;
    //节点颜色.  hsl / hsv / hex / rgb
    private String color ;
    //节点图标
    private String icon ;
}
