package com.loonggg.godqrcode.ui.wwei;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loonggg.godqrcode.R;
import com.loonggg.godqrcode.data.Constants;
import com.loonggg.godqrcode.data.api.model.QrCodeModel;
import com.loonggg.godqrcode.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/21.
 */

public class WweiQrCodeActivity extends BaseActivity implements WweiQrCodeView {
    @Inject
    WweiQrCodePresenter presenter;
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_top);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        presenter.attachView(this);
        presenter.generateQrCode(Constants.API_KEY, "非著名程序员", "", "ff00ff", "00ff00", "fff000", "0");
    }

    @Override
    public void onNewsTopList(QrCodeModel qrCodeModel) {
        Glide
                .with(this)
                .load(qrCodeModel.getData().getQr_filepath())
                .centerCrop()
                .crossFade()
                .into(iv);
        Toast.makeText(this, qrCodeModel.getData().getQr_filepath(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void toError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
