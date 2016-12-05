package com.chris.demodialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View v){
        showDialog();
    }
    private void showDialog(){
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        View view = View.inflate(getApplicationContext(),
                R.layout.dialog_addblacknumber, null);

        // 黑名单号码编辑框
        final EditText et_blackNumber = (EditText) view
                .findViewById(R.id.et_telsmssafe_blacknumber);

        // 设置初始的黑名单号码
        et_blackNumber.setText("1300000000");

        // 短信拦截复选框
        final CheckBox cb_sms = (CheckBox) view
                .findViewById(R.id.cb_telsmssafe_smsmode);

        // 短信拦截复选框
        final CheckBox cb_phone = (CheckBox) view
                .findViewById(R.id.cb_telsmssafe_phonemode);

        // 添加黑名单号码按钮
        Button bt_add = (Button) view.findViewById(R.id.bt_telsmssafe_add);

        // 取消添加黑名单号码按钮
        Button bt_cancel = (Button) view
                .findViewById(R.id.bt_telsmssafe_cancel);

        bt_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        bt_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 添加黑名单数据
                String phone = et_blackNumber.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(getApplicationContext(), "黑名单号码不能为空", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                if (!cb_phone.isChecked() && !cb_sms.isChecked()) {
                    // 两个拦截都没选
                    Toast.makeText(getApplicationContext(), "至少选择一种拦截模式", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                int mode = 0;
                if (cb_phone.isChecked()) {
//                    mode |= BlackTable.TEL;// 设置电话拦截模式
                }
                if (cb_sms.isChecked()) {
//                    mode |= BlackTable.SMS;// 设置电话拦截模式
                }

                // dao.add(phone, mode);//添加数据到黑名单表中

//                // 界面看到用户新增的数据
//                BlackBean bean = new BlackBean();
//                bean.setMode(mode);
//                bean.setPhone(phone);
//
//                dao.add(bean);// 添加数据到黑名单表中
//                // 如果新增的数据已经存在
//                datas.remove(bean);// 该删除方法要靠equals和hashCode两个方法共同判断数据是否一致
//                datas.add(0, bean);// 添加数据到List中
//
//                // 让listview显示第一条数据
//                // lv_safenumbers.setSelection(0);
//                adapter = new MyAdapter();
//                lv_safenumbers.setAdapter(adapter);
                dialog.dismiss();
//                // 显示listview
//                lv_safenumbers.setVisibility(View.VISIBLE);
//
//                // 隐藏没有数据
//                tv_nodata.setVisibility(View.GONE);
//
//                // 隐藏加载数据的进度
//                pb_loading.setVisibility(View.GONE);

            }
        });
        ab.setView(view);

        // 创建对话框
        dialog = ab.create();
        dialog.show();// 显示对话框
    }
}
