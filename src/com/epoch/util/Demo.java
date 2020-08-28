/*
package com.epoch.face.security.util;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectory;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

*/
/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/21
 *//*

public class Demo {

    */
/**
     * 调整图片角度
     * make by dongxh 2017年11月1日下午3:51:08
     *
     * @param src
     * @param angel
     * @return
     *//*

    public static BufferedImage rotate(Image src, int angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        // calculate the new image size
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
                src_width, src_height)), angel);

        BufferedImage res = null;
        res = new BufferedImage(rect_des.width, rect_des.height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = res.createGraphics();
        // transform
        g2.translate((rect_des.width - src_width) / 2,
                (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

        g2.drawImage(src, null, null);
        return res;
    }

    */
/**
     * 计算旋转参数
     * make by dongxh 2017年11月1日下午3:51:29
     *
     * @param src
     * @param angel
     * @return
     *//*

    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {
        // if angel is greater than 90 degree, we need to do some conversion
        if (angel >= 90) {
            if (angel / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }

    */
/**
     * 获得图片调整角度
     * make by dongxh 2017年11月1日下午3:40:20
     *
     * @param imgFile
     * @return
     *//*

    public static Integer getImgRotateAngle(String imgFile) {
        Integer angel = 0;
        Metadata metadata = null;
        try {
            if (StringUtils.isBlank(imgFile)) return angel;
            File _img_file_ = new File(imgFile);
            if (!_img_file_.exists()) return angel;
            metadata = JpegMetadataReader.readMetadata(_img_file_);
            Directory directory = metadata.getDirectory(ExifDirectory.class);
            if (directory != null && directory.containsTag(ExifDirectory.TAG_ORIENTATION)) {
                int orientation = directory.getInt(ExifDirectory.TAG_ORIENTATION);
                // 原图片的方向信息
                if (6 == orientation) {
                    //6旋转90
                    angel = -90;
                } else if (3 == orientation) {
                    //3旋转180
                    angel = -180;
                } else if (8 == orientation) {
                    //8旋转90
                    angel = 90;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return angel;
    }

    */
/**
     * 调整图片角度
     * make by dongxh 2017年11月1日下午4:31:20
     *
     * @param imgFile
     *//*

    public static void rotateImage(String imgFile) {
        try {
            if (StringUtils.isBlank(imgFile)) {
                File _img_file_ = new File(imgFile);
                if (_img_file_.exists()) {
                    Integer angel = getImgRotateAngle(imgFile);
                    if (angel == 0) return;
                    BufferedImage src = ImageIO.read(_img_file_);
                    BufferedImage des = rotate(src, angel);
                    ImageIO.write(des, "jpg", _img_file_);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String fromPic = "d://img//11.jpg";
        //rotateImage(fromPic);

        Integer angel = getImgRotateAngle(fromPic);
        System.out.println(angel);
        Thumbnails.of(fromPic)
                .rotate(angel)
                .scale(1.0f)
                .outputFormat("jpg")
                .outputQuality(1.0f)
                .toFile(fromPic);

        System.out.println("==End==");
    }

}
*/
