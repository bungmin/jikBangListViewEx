package datas;

import java.io.Serializable;

public class JikBang implements Serializable {
    public int bojeng;
    public int payment_month;
    public int floor;
    public String addr;
    public String descriong;


    public JikBang(int bojeng, int payment_month, int floor, String addr, String descriong) {
        this.bojeng = bojeng;
        this.payment_month = payment_month;
        this.floor = floor;
        this.addr = addr;
        this.descriong = descriong;
    }
}
