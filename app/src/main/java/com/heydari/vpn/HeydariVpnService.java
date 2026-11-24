package com.heydari.vpn;

import android.net.VpnService;
import android.content.Intent;
import android.os.ParcelFileDescriptor;

public class HeydariVpnService extends VpnService {

    private ParcelFileDescriptor vpnInterface;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (vpnInterface != null) {
            return START_STICKY;
        }

        Builder builder = new Builder();

        builder.setSession("Heydari VPN");
        builder.addAddress("10.10.0.2", 32);
        builder.addRoute("0.0.0.0", 0);
        builder.addDnsServer("1.1.1.1");

        try {
            vpnInterface = builder.establish();
        } catch (Exception e) {
            stopSelf();
            return START_NOT_STICKY;
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        try {
            if (vpnInterface != null) {
                vpnInterface.close();
                vpnInterface = null;
            }
        } catch (Exception ignored) {
        }

        super.onDestroy();
    }
}
