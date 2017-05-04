package com.loonggg.godqrcode.data.api.model;

/**
 * Created by Administrator on 2017/5/4.
 */

public class QrCodeModel {

    /**
     * status : 1
     * msg : success
     * data : {"qr_filepath":"http://api.wwei.cn/Uploads/apiqrcode/2014/11/10/f03f5717616221de41881be555473a020.png","qr_data":"http://www.baidu.com/","new_descr":"","new_version":0}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * qr_filepath : http://api.wwei.cn/Uploads/apiqrcode/2014/11/10/f03f5717616221de41881be555473a020.png
         * qr_data : http://www.baidu.com/
         * new_descr :
         * new_version : 0
         */

        private String qr_filepath;
        private String qr_data;
        private String new_descr;
        private int new_version;

        public String getQr_filepath() {
            return qr_filepath;
        }

        public void setQr_filepath(String qr_filepath) {
            this.qr_filepath = qr_filepath;
        }

        public String getQr_data() {
            return qr_data;
        }

        public void setQr_data(String qr_data) {
            this.qr_data = qr_data;
        }

        public String getNew_descr() {
            return new_descr;
        }

        public void setNew_descr(String new_descr) {
            this.new_descr = new_descr;
        }

        public int getNew_version() {
            return new_version;
        }

        public void setNew_version(int new_version) {
            this.new_version = new_version;
        }
    }
}
