package com.gjxaiou.dto;

import lombok.Data;

import java.io.InputStream;

/**
 * @author GJXAIOU
 * @create 2019-11-02-10:12
 */
@Data
public class ImageHolder {
    /**
     * 图片流
     */
    private InputStream image;
    /**
     * 图片名称
     */
    private String imageName;

    public ImageHolder(InputStream image, String imageName) {
        this.image = image;
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
