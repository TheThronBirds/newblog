package only.luzejin.newblog.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 包名称only.luzejin.newblog.Util
 * 类名称Captcha
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/4 22:05
 **/
public class Captcha {

    private int width;
    private int height;
    private int num = 4;
    private String code = "01abcde23fghi45jkmnpqrstu67vwxyz89";
    private static final Random ran = new Random();
    private static Captcha captcha;

    private Captcha() {
    }

    public static Captcha getInstance() {
        if (captcha == null) {
            captcha = new Captcha();
        }

        return captcha;
    }

    public void set(int width, int height, int num, String code) {
        this.width = width;
        this.height = height;
        this.setNum(num);
        this.setCode(code);
    }

    public void set(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String generateCheckcode() {
        StringBuffer cc = new StringBuffer();

        for(int i = 0; i < this.num; ++i) {
            cc.append(this.code.charAt(ran.nextInt(this.code.length())));
        }

        return cc.toString();
    }

    public BufferedImage generateCheckImg(String checkcode) {
        BufferedImage img = new BufferedImage(this.width, this.height, 1);
        Graphics2D graphic = img.createGraphics();
        graphic.setColor(Color.WHITE);
        graphic.fillRect(0, 0, this.width, this.height);
        graphic.setColor(Color.BLACK);
        graphic.drawRect(0, 0, this.width - 1, this.height - 1);
        Font font = new Font("宋体", 3, (int)((double)this.height * 0.8D));
        graphic.setFont(font);

        int i;
        for(i = 0; i < this.num; ++i) {
            graphic.setColor(new Color(ran.nextInt(180), ran.nextInt(180), ran.nextInt(180)));
            graphic.drawString(String.valueOf(checkcode.charAt(i)), i * (this.width / this.num) + 4, (int)((double)this.height * 0.8D));
        }

        for(i = 0; i < this.width + this.height; ++i) {
            graphic.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            graphic.drawOval(ran.nextInt(this.width), ran.nextInt(this.height), 1, 1);
        }

        return img;
    }
}
