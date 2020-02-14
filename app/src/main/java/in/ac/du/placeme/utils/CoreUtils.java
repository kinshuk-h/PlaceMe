package in.ac.du.placeme.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CoreUtils {
    public static String getWifiMACAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        return wInfo.getMacAddress();
    }
    public static String getMonth(String date) {
        final String[] months = {"January", "February", "March", "April", "May", "June",
                                 "July", "August", "September", "October", "November", "December"};
        String[] parts = date.split("_");
        int month = Integer.parseInt(parts[1]);
        return months[month-1];
    }
    public static String getMACAddress() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) { return ""; }
                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) { res1.append(String.format("%02X:",b)); }
                if (res1.length() > 0) { res1.deleteCharAt(res1.length() - 1); }
                return res1.toString();
            }
        } catch (Exception e) {
            Log.e(CoreUtils.class.getName(), "error: "+e); e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }
    public static String toQueryString(Map<String, String> map) {
        StringBuilder query = new StringBuilder();
        for(Map.Entry<String, String> pair : map.entrySet()) {
            if(query.length()!=0) query.append("&");
            query.append(pair.getKey()).append("=");
            query.append(pair.getValue()==null||pair.getValue().isEmpty()?"null":pair.getValue());
        }
        return query.toString();
    }
    public static int toPixels(Context context, int dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp*scale + 0.5f);
    }
    public static boolean allSet(Object... vars) {
        for(Object var : vars) {
            if(var==null || (var instanceof String && ((String)var).isEmpty())) return false;
        } return true;
    }
}
