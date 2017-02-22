package com.loonggg.mvpframe.ui.newstop;

import com.loonggg.mvpframe.data.api.model.NewsModel;
import com.loonggg.mvpframe.ui.base.MvpView;

/**
 * Created by Administrator on 2017/2/21.
 */

public interface NewsTopView extends MvpView {
    void onNewsTopList(NewsModel newsModel);

    void toError(String string);
}
