package com.loonggg.mvpframe.ui.newstop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.loonggg.mvpframe.R;
import com.loonggg.mvpframe.data.api.model.NewsModel;
import com.loonggg.mvpframe.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/2/21.
 */

public class NewsTopActivity extends BaseActivity implements NewsTopView {
    @Inject
    NewsTopPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_top);
        getActivityComponent().inject(this);
        presenter.attachView(this);
        presenter.getNewsTop("top", "7f13e3ec7b12bc008f3c1643b6e9042f");
    }

    @Override
    public void onNewsTopList(NewsModel newsModel) {
        Toast.makeText(this, newsModel.getResult().getData().get(0).getTitle(), Toast.LENGTH_LONG).show();
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
