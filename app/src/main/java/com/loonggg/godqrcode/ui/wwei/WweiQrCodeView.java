package com.loonggg.godqrcode.ui.wwei;

import com.loonggg.godqrcode.data.api.model.NewsModel;
import com.loonggg.godqrcode.data.api.model.QrCodeModel;
import com.loonggg.godqrcode.ui.base.MvpView;

/**
 * Created by Administrator on 2017/2/21.
 */

public interface WweiQrCodeView extends MvpView {
    void onNewsTopList(QrCodeModel qrCodeModel);

    void toError(String string);
}
