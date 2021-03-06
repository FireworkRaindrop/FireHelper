package com.wyq.firehelper.architecture.mvp.translation.view;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wyq.firehelper.architecture.R;
import com.wyq.firehelper.architecture.R2;
import com.wyq.firehelper.architecture.mvp.translation.presenter.PresenterImpl;
import com.wyq.firehelper.base.BaseActivity;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * MVP(Model-View-Presenter)模式:

 Model: 数据层. 负责与网络层和数据库层的逻辑交互.
 View: UI层. 显示数据, 并向Presenter报告用户行为.
 Presenter: 从Model拿数据, 应用到UI层, 管理UI的状态, 决定要显示什么, 响应用户的行为.
 MVP模式的最主要优势就是耦合降低, Presenter变为纯Java的代码逻辑, 不再与Android Framework中的类如Activity, Fragment等关联, 便于写单元测试.
 */
public class MvpActivity extends BaseActivity implements IBaseView {

    @BindView(R2.id.architecture_activity_mvp_translate_tv)
    public TextView textView;

    @BindView(R2.id.architecture_activity_mvp_translate_et)
    public EditText editText;

    @BindView(R2.id.architecture_activity_mvp_translate_bt)
    public Button translateBt;

    @BindView(R2.id.toolbar)
    public Toolbar toolbar;

    private PresenterImpl presenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.architecture_activity_mvp_layout;
    }

    @Override
    public void initToolBar() {
        initToolBar(toolbar,"Translate",true);
    }

    @Override
    public void initView() {
        presenter = new PresenterImpl(this);
    }

    @OnClick(R2.id.architecture_activity_mvp_translate_bt)
    public void translate(){
        String str = editText.getText().toString();
        if (str != null && str.length() > 0) {
            presenter.translate(str);
        }
    }

    @Override
    public void showInfo(String bean) {
        textView.setText(bean);
    }

    @Override
    public void showError() {

    }
}
