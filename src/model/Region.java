/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:Region
 * Time:2019/10/1711:32
 * Description:
 */
package model;

public class Region {
    private Integer re_id;
    private String re_name;
    private Integer pid;
    private Integer re_level;

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRe_level() {
        return re_level;
    }

    public void setRe_level(Integer re_level) {
        this.re_level = re_level;
    }
}
