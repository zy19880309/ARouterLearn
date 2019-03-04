package cn.zhangyong.samplemodule.bean;

/**
 * description:
 * autour: zhangyong
 * date: 2019/1/29 17:04
 * update: 2019/1/29
 * version:
 */
public class Family{
    private String husband;
    private String wife;

    public Family() {
    }

    public String getHusband() {
        return husband;
    }

    public void setHusband(String husband) {
        this.husband = husband;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"husband\":\"")
                .append(husband).append('\"');
        sb.append(",\"wife\":\"")
                .append(wife).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
