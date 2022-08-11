package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.ArrayList;

public class ThreadingSearch extends Thread {
    String ip;
    int inicio;
    int fin;
    ArrayList<Integer> blackListOcurrences = new ArrayList<Integer>();
    int ocurrencesCount;
    int checkedListsCount;
    HostBlacklistsDataSourceFacade skds;

    ThreadingSearch(HostBlacklistsDataSourceFacade skds, int inicio, int fin, String ip){
        this.ip  = ip;
        this.inicio = inicio;
        this.fin = fin;
        this.skds = skds;

    }

    @Override
    public void run() {
        for (int i=inicio;i<fin;i++){
            checkedListsCount+=1;
            if (skds.isInBlackListServer(i, ip)){
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
    }

    public ArrayList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }

    public int getCheckedListsCount() {
        return checkedListsCount;
    }

    public int getOcurrencesCount(){
                return ocurrencesCount;
        }

}
