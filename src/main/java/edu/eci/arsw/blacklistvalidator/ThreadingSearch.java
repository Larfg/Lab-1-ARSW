package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class ThreadingSearch extends Thread {
    String ip;
    int inicio;
    int fin;

    int ocurrencesCount;
    HostBlacklistsDataSourceFacade skds;

    ThreadingSearch(HostBlacklistsDataSourceFacade skds, int inicio, int fin, String ip){
        this.ip  = ip;
        this.inicio = inicio;
        this.fin = fin;
        this.skds = skds;

    }

    @Override
    public void run() {
        for (int i=inicio;i<skds.getRegisteredServersCount();i++){
            if (skds.isInBlackListServer(i, ipaddress)){
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }

        }
    }

    public int getOcurrencesCount(){
                return ocurrencesCount;
        }

}
