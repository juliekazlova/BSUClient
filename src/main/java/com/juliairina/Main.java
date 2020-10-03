package com.juliairina;

import com.juliairina.client.Client;
import com.juliairina.gui.MainWindow;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.net.InetAddress;
import java.security.Security;

public class Main {

    private static int port = 4000;
    private static String addressString = "127.0.0.4";
    private static int remotePort = 4005;
    private static String remoteAddressString = "127.0.0.2";

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Client client = new Client(InetAddress.getByName(remoteAddressString), remotePort,
                    InetAddress.getByName(addressString), port);
            MainWindow mainWindow = new MainWindow(client);
            mainWindow.setVisible(true);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
