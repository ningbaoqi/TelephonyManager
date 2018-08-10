package com.shop.ningbaoqi.telephonymanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> statusValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        statusValues.add(telephonyManager.getDeviceId());//获取设备编号
        statusValues.add(telephonyManager.getDeviceSoftwareVersion() != null ? telephonyManager.getDeviceSoftwareVersion() : "null");//获取系统平台的版本
        statusValues.add(telephonyManager.getNetworkOperator());//获取网络运营商代号
        statusValues.add(telephonyManager.getNetworkOperatorName());//获取网络运营商的名称
        statusValues.add(telephonyManager.getCellLocation() != null ? telephonyManager.getCellLocation().toString() : "null");//获取设备所在位置
        statusValues.add(telephonyManager.getSimCountryIso());//获取SIM卡的国别
        statusValues.add(telephonyManager.getSimSerialNumber());//获取SIM卡的序列号
        PhoneStateListener listener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
